package pl.solsoft.shop2013.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.solsoft.shop2013.domain.Category;
import pl.solsoft.shop2013.domain.Order;
import pl.solsoft.shop2013.domain.Product;
import pl.solsoft.shop2013.domain.User;
import pl.solsoft.shop2013.dto.ProductDTO;
import pl.solsoft.shop2013.dto.CategoryDTO;
import pl.solsoft.shop2013.service.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 06.08.13
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
@SessionAttributes({"errorList"})
public class AdminController {

    @Autowired
    IUserService userService;

    @Autowired
    IAuthorityService authorityService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IOrderService orderService;

    @Autowired
    IOrderItemService orderItemService;

    @Autowired
    IProductService productService;

    @Autowired
    ICategoryProductRelationService categoryProductRelationService;

    private static Logger logger = Logger.getLogger(AdminController.class.getName());

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") @Valid ProductDTO productDTO, BindingResult result, HttpSession session) {
        logger.info("Mapping /addProduct");

        if (result.hasErrors()){
            List<FieldError> errorList = result.getFieldErrors();
            session.setAttribute("errors", result.getFieldErrors());
            for (FieldError error : errorList){
                logger.error(error.getDefaultMessage());
            }
            return "redirect:/admin/productsTab.ftl";
        }

        Product lProduct = productDTO.createObject();
        productService.create(lProduct);

        Category lCategory = categoryService.getItemById(productDTO.getCategoryId());
        categoryProductRelationService.createRelations(lCategory, lProduct);

        logger.trace("Product addeded!");

        return "redirect:/admin/productsTab.ftl";
    }

    @RequestMapping(value = "/deleteProduct-{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Long id) {
        if (orderItemService.isProductInOrderItems(id)) {
            logger.error("Product is already in order list!");
        } else {
            logger.trace("Product is not in the order list!");
            categoryProductRelationService.deleteRelations(id, "product");
            Product product = productService.getItemById(id);
            productService.delete(product);
            logger.trace("Product deleted!");
        }

        return "redirect:/admin/productsTab.ftl";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") @Valid CategoryDTO categoryDTO, BindingResult result, HttpSession session) {
        logger.info("Mapped /addCategory");

        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            session.setAttribute("errors", errorList);
            return "redirect:/admin/categoriesTab.ftl";
        }

        Category aCategory = categoryDTO.createObject();
        Category parentCat = categoryService.getItemById(categoryDTO.getParentId());
        aCategory.setParentCategory(parentCat);
        categoryService.create(aCategory);
        logger.trace("Category created!");

        return "redirect:/admin/categoriesTab.ftl";
    }

    @RequestMapping(value = "/deleteCategory-{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("id") Long id) {
        logger.trace("Mapped /deleteCategory");
        categoryProductRelationService.deleteRelations(id, "category");
        Category category = categoryService.getItemById(id);
        categoryService.assignChildCategories(category);
        categoryService.delete(category);
        logger.trace("Category deleted!");

        return "redirect:/admin/categoriesTab.ftl";
    }

    @RequestMapping(value = "/categories-{name}-{id}", method = RequestMethod.GET)
    public String findCategories(@PathVariable("id") Long parentId,
                                 @PathVariable("name") String header,
                                 Model model) {
        model.addAttribute("parentId", parentId);
        model.addAttribute("categoryListCore", categoryService.findItems());
        model.addAttribute("headerCategory", header);

        return "/admin/categories";
    }

    @RequestMapping(value = "/deleteUser-{username}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("username") String username) {
        logger.trace("Mapped /deleteUser");
        userService.deleteUserByName(username);
        logger.trace("User deleted");

        return "redirect:/admin/usersTab.ftl";
    }

    @RequestMapping(value = "/userDetails-{username}", method = RequestMethod.GET)
    public ModelAndView userDetails(@PathVariable("username") String username,
                                    Model model, HttpSession session) {

        try{
            model.addAttribute("errors", session.getAttribute("errors"));
            session.removeAttribute("errors");

            model.addAttribute("user", session.getAttribute("user"));
            session.removeAttribute("user");
        } catch (Exception e){
            e.printStackTrace();
        }

        logger.trace("Mapped /userDetails");
        User aUser = userService.getUserByUsername(username);
        ModelAndView mV = new ModelAndView("admin/userDetails", "user", aUser);
        return mV;
    }

    @RequestMapping(value = "/changeUserDetails", method = RequestMethod.POST)
    public String changeUserDetails(@ModelAttribute("user") @Valid User user, BindingResult result, HttpSession session) {

        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            session.setAttribute("errors", errorList);
            session.setAttribute("user", user);
            return "redirect:/admin/userDetails-" + user.getUsername();
        }

        logger.trace("Mapped /changeUserDetails");
        userService.update(user);
        logger.trace("User updated!");

        return "redirect:/admin/usersTab.ftl";
    }

    @RequestMapping(value = "/order-{orderId}", method = RequestMethod.GET)
    public String orderDetails(@PathVariable("orderId") Long orderId, Model model) {
        logger.trace("Mapped /order");
        Order order = orderService.getItemById(orderId);
        order.setOrderItemList(orderItemService.findOrderItems(orderId));
        model.addAttribute("order", order);
        logger.trace("Order details received!");

        return "admin/orderDetails";
    }


//    tabs in admin panel
    @RequestMapping(value = "/ordersTab", method = RequestMethod.GET)
     public String ordersTab(Model model){
        model.addAttribute("orderListCore", orderService.findItems());
        return "admin/ordersTab";
    }

    @RequestMapping(value = "/usersTab", method = RequestMethod.GET)
    public String usersTab(Model model){
        model.addAttribute("userListCore", userService.findItems());
        return "admin/usersTab";
    }

    @RequestMapping(value = "/categoriesTab", method = RequestMethod.GET)
    public String categoriesTab(Model model, HttpSession session){

        try{
            model.addAttribute("errors", session.getAttribute("errors"));
            session.removeAttribute("errors");
        } catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("categoryListCore", categoryService.findItems());
        model.addAttribute("parentId", -1);
        return "admin/categoriesTab";
    }

    @RequestMapping(value = "/productsTab", method = RequestMethod.GET)
    public String productsTab(Model model, HttpSession session){

        try{
            model.addAttribute("errors", session.getAttribute("errors"));
            session.removeAttribute("errors");
        } catch (Exception e){
            e.printStackTrace();
        }

        model.addAttribute("productListCore", productService.findItems());
        model.addAttribute("categoryListCore", categoryService.findItems());
        return "admin/productsTab";
    }

}