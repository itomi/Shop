package pl.bd2.shop2013.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.bd2.shop2013.domain.Authority;
import pl.bd2.shop2013.domain.User;
import pl.bd2.shop2013.service.IAuthorityService;
import pl.bd2.shop2013.service.ICategoryService;
import pl.bd2.shop2013.service.IUserService;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 05.08.13
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */

@Controller
@SessionAttributes({"errorList"})
public class TopController {

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IUserService userService;

    @Autowired
    IAuthorityService authorityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("categoryListCore", categoryService.findRootCategories());
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(HttpSession session, Model model) {
        try{
           model.addAttribute("errors", session.getAttribute("errors"));
           session.removeAttribute("errors");

           model.addAttribute("user", session.getAttribute("user"));
           session.removeAttribute("user");
        } catch (Exception e){
            e.printStackTrace();
        }
        return "register";
    }

    @RequestMapping(value = "/check-register", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult result, HttpSession session) {

        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            session.setAttribute("errors", errorList);
            session.setAttribute("user", user);
            return "redirect:/register.ftl";
        }

        Authority auth = authorityService.assignAuthority(user.getUsername());
        authorityService.create(auth);
        userService.create(user, auth);

        return "redirect:/register";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {

        return "about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
