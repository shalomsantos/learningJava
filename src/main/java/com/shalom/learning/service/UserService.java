package com.shalom.learning.service;

import com.shalom.learning.entity.User;
import com.shalom.learning.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRespository userRepository;

    public List<User> all() { return userRepository.findAll(); }

    public User findById(Long id) { return userRepository.findById(id).orElse(null); }
}
