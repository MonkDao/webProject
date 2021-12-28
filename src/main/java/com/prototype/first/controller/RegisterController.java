package com.prototype.first.controller;

import com.prototype.first.dto.UserDto;
import com.prototype.first.exceptions.BadRequestException;
import com.prototype.first.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/form")
    public String registerPage() {
        return "form";
    }

    @PostMapping("/form")
    public String registerUser(@ModelAttribute("user") UserDto userDto, Model model) {
        try {
            UserDto user = userService.createUser(userDto);
            model.addAttribute("user", user);
            return "home";
        } catch (BadRequestException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "errorPage";
    }
}

