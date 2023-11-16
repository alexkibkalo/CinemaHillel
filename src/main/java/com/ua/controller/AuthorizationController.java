package com.ua.controller;

import com.ua.model.User;
import com.ua.service.authorization.AuthorizationService;
import com.ua.transport.dto.UserIncomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("/welcome")
    public String getWelcomeView() {
        return "welcome";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserIncomeDto dto) {
        boolean response = authorizationService.login(dto);
        if (response) {
            return "redirect:/welcome";
        } else {
            return "redirect:/error";
        }
    }

    @PostMapping("/logout")
    public String logout(@ModelAttribute UserIncomeDto dto) {
        authorizationService.logout(dto);
        return "redirect:/login";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserIncomeDto dto) {
        boolean response = authorizationService.signup(dto);
        if (response) {
            return "redirect:/welcome";
        } else {
            return "redirect:/error";
        }
    }
}
