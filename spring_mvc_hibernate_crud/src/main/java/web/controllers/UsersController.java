package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("allUsers", users);
        return "showAllUsers";
    }

    @GetMapping("/userInfo")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-info-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            userService.save(user);
        } else {
            userService.edit(user);
        }
        return "redirect:/";
    }

    @GetMapping( "/edit" )
    public String editUser(@RequestParam("id") int id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user-info-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
