package com.hoangphuccode.spring_boot_demo.service.impl;

import com.hoangphuccode.spring_boot_demo.entity.UserEntity;
import com.hoangphuccode.spring_boot_demo.repository.UserRepository;
import com.hoangphuccode.spring_boot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }
}
