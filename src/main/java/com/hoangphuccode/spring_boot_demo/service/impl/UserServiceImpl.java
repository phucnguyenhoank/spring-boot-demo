package com.hoangphuccode.spring_boot_demo.service.impl;

import com.hoangphuccode.spring_boot_demo.entity.UserEntity;
import com.hoangphuccode.spring_boot_demo.repository.UserRepository;
import com.hoangphuccode.spring_boot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<UserEntity> getAllUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public Page<UserEntity> getByName(String name, Pageable pageable) {
        return this.userRepository.findByName(name, pageable);
    }
}
