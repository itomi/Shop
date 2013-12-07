package pl.bd2.shop2013.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.bd2.shop2013.domain.*;
import pl.bd2.shop2013.service.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 07.08.13
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {

    @Autowired
    ICartService cartService;

    @Autowired
    IOrderService orderService;

    @Autowired
    IUserService userService;

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/addToCart-{productId}-{name}-{id}-{startFromProduct}")
    public String addToCart(@PathVariable("productId") Long id,
                            @ModelAttribute("amount") Integer amount,
                            @PathVariable("name") String catName,
                            @PathVariable("id") String catId,
                            @PathVariable("startFromProduct") String pagination,
                            RedirectAttributes rA)
    {
        String redirectURL = "redirect:/displayProducts-" + catName + "-" + catId + "-" + pagination;

        Product product = productService.getItemById(id);
        CartItem cartItem = new CartItem(product, amount);
        cartService.addCartItem(cartItem);

        return redirectURL;
    }

    @RequestMapping(value = "/deleteFromCart-{index}")
    public String deleteFromCart(@PathVariable("index") int index,
                                 RedirectAttributes rA)
    {
        cartService.deleteCartItem(index);

        return "redirect:/";
    }

    @RequestMapping(value = "/addOrder")
    public String addOrder(Model model, RedirectAttributes rA)
    {
        Map <Long, Integer> map = cartService.findProductQuantities();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByUsername(username);
        Order order = cartService.convertToOrder(Calendar.getInstance().getTime(), user);

        if (!productService.changeQuantities(map))
            return "redirect:/";

        productService.updateQuantities(map);

        orderService.create(order);

        cartService.clearCartItems();

        return "redirect:/";
    }

    @RequestMapping(value = "/cart")
    public String showCart(Model model)
    {
        model.addAttribute("cartItemList", cartService.findCartItemList());

        return "/cart";
    }

    @RequestMapping(value = "/clearCart")
    public String clearCart(Model model)
    {
        cartService.clearCartItems();

        model.addAttribute("cartItemList", cartService.findCartItemList());

        return "/cart";
    }

}
