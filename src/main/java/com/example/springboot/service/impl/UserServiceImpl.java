package com.example.springboot.service.impl;

import com.example.springboot.aop.InvokeLog;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @InvokeLog
    public List<User> getAll() {
        System.out.println("----------------------------------");
        return userMapper.getAll();
    }
}
