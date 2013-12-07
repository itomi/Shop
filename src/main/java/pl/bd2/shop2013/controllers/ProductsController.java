package pl.bd2.shop2013.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bd2.shop2013.service.ICategoryService;
import pl.bd2.shop2013.service.IProductService;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 12.08.13
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ProductsController {

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/displayProducts-{name}-{id}-{startFromProduct}", method = RequestMethod.GET)
    public String displayProducts(@PathVariable("id") Long parentId, // it's also id
                                  @PathVariable("name") String header,
                                  @PathVariable("startFromProduct") int start,
                                  Model model) {
        model.addAttribute("categoryListCore", categoryService.findCategoriesByParentId(parentId));
        model.addAttribute("headerCategory", header);
        model.addAttribute("parentId", parentId);
        model.addAttribute("previousCategory", categoryService.getParentIdOfCategoryId(parentId)); // parentId its also category id
        model.addAttribute("pageSize", start);
        model.addAttribute("productListPage", productService.findProducts(start, parentId));

        return "/products";
    }

    @RequestMapping(value = "/searchProducts*", method = RequestMethod.GET)
    public String searchProducts(Model model,
                                 @RequestParam("search") String search){

        model.addAttribute("productListPage",productService.findProductsByText(search));

        return "/searchProducts";
    }
}