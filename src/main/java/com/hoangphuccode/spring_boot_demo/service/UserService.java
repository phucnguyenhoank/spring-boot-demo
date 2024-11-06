package com.hoangphuccode.spring_boot_demo.service;

import com.hoangphuccode.spring_boot_demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity addUser(UserEntity userEntity);
    List<UserEntity> getAllUsers();
}
