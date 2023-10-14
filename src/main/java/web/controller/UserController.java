package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    String redirect = "redirect:/";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "index";
    }

    @RequestMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "userInfo";
    }

    @RequestMapping("/saveUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return redirect;
    }

    @RequestMapping("/updateUser")
    public String updateUser(Model model, @RequestParam("userId") int id) {
        User user = userService.getUser(id);
        model.addAttribute("newUser", user);
        return "userInfo";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return redirect;
    }
}
