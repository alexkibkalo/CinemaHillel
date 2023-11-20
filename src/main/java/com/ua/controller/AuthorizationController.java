package com.ua.controller;

import com.ua.service.authorization.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

}
