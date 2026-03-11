package com.shalom.learning.controller;

import com.shalom.learning.dto.UserDto;
import com.shalom.learning.entity.Usuario;
import com.shalom.learning.service.HomeService;
import com.shalom.learning.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController
{
    @Autowired
    private HomeService homeService;
    @Autowired
    private UsuarioService userService;

    @GetMapping
    public String home()
    {
        return homeService.greeting("Shalom santos");
    }
    
    @GetMapping("/users")
    public List<Usuario> users()
    {
        return userService.all();
    }

    @PostMapping("/about")
    public String about(@RequestBody UserDto body)
    {
        return String.format("veio na requisição nome:.%s e email:.%s", body.getName(), body.getEmail());
    }
}
