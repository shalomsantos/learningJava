package com.shalom.learning.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService
{
    public String greeting(String name)
    {
        return "hellow home: " + name;
    }
}
