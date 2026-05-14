package com.shalom.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shalom.learning.service.auth.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody LoginRequest login) {
      var token = new UsernamePasswordAuthenticationToken(login.email(), login.senha());
      var auth = authenticationManager.authenticate(token);
      return tokenService.gerarToken(auth);
    }

    public record LoginRequest(String email, String senha) {}
}
