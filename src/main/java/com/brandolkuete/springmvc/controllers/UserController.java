package com.brandolkuete.springmvc.controllers;

import com.brandolkuete.springmvc.models.Role;
import com.brandolkuete.springmvc.models.User;
import com.brandolkuete.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/addRoleToUser")
    public String addRoleToUser(Model model){

        List<User> users = userService.findAll();
        List<Role> roles = userService.findRoles();

        model.addAttribute("users",users);
        model.addAttribute("roles",roles);

        return "roleToUser";
    }

    @PostMapping("/addRoleToUser")
    public String addRoleToUserForm(@ModelAttribute("username") String username, @ModelAttribute("role") String role, Model model){

        userService.addRoleToUser(username,role);

        model.addAttribute("successMessage", "User has been registered successfully");
        model.addAttribute("user", new User());

        return "addRoleToUser";
    }

}
