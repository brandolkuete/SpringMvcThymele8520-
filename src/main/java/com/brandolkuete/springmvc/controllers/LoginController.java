package com.brandolkuete.springmvc.controllers;

import com.brandolkuete.springmvc.models.User;
import com.brandolkuete.springmvc.repository.UserRepository;
import com.brandolkuete.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String createNewUser(@Valid User user, BindingResult bindingResult,Model model) {
        final User userExists = userRepository.findByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            userService.save(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
        }
        return "registration";

    }

    @GetMapping("/access-denied")
    public String accedDenied(){
        return "access-denied";
    }


}
