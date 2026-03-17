package com.shalom.learning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController
{
    @GetMapping
    public ResponseEntity<Map<String, Object>> info() {
        Map<String, Object> info = new LinkedHashMap<>(); // LinkedHashMap mantém a ordem

        info.put("projeto", "Book Learning API");
        info.put("descricao", "API para gerenciamento de livraria");
        info.put("desenvolvedor", "Shalom Pereira dos Santos");
        info.put("E-mail", "shalomsantos1234@gmail.com");
        info.put("versao", "1.2");
        info.put("stack", List.of(
                "Java 17",
                "Spring Boot 3",
                "Spring Data JPA",
                "Mysql"
        ));
        return ResponseEntity.ok(info);
    }
}
