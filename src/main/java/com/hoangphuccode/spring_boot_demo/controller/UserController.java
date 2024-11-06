package com.hoangphuccode.spring_boot_demo.controller;

import com.hoangphuccode.spring_boot_demo.entity.UserEntity;
import com.hoangphuccode.spring_boot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers(){
        return this.userService.getAllUsers();
    }
}
