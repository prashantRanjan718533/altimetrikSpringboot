package com.twitterAPI.altimetrik.healthCheck;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/login")
    public String login() {

        return JwtUtil.generateToken("user");
    }
}