package com.shalom.learning.controller;

import com.shalom.learning.entity.User;
import com.shalom.learning.repository.UserRespository;
import com.shalom.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRespository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> index() { return userService.all(); }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) 
    {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Erro: E-mail já cadastrado!");
        }
        user.setSenha(encoder.encode(user.getSenha()));
        repository.save(user);

        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }
}
