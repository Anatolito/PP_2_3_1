package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

        String redirect = "redirect:/users";
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "userIndex";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "userInfo";
    }

    @PostMapping(value = "users/saveUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return redirect;
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(Model model, @RequestParam("userId") int id) {
        User user = userService.getUser(id);
        model.addAttribute("newUser", user);
        return "userInfo";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return redirect;
    }
}
