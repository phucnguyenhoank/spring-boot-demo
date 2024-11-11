package com.hoangphuccode.spring_boot_demo.service;

import com.hoangphuccode.spring_boot_demo.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    Page<UserEntity> getAllUsers(Pageable pageable);
    Page<UserEntity> getByName(String address, Pageable pageable);
}
