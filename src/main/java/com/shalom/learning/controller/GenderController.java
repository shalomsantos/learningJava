package com.shalom.learning.controller;

import com.shalom.learning.dto.GenderDto;
import com.shalom.learning.entity.Gender;
import com.shalom.learning.service.GenderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController
{
    @Autowired
    private GenderService genderService;

    @GetMapping
    public List<Gender> index(){ return genderService.all(); }

    @PostMapping
    public Gender store(@Valid @RequestBody GenderDto body)
    {
        return genderService.create(body);
    }
    //    public String show() {}
    //    public String update() {}
    //    public String destroy() {}
}
