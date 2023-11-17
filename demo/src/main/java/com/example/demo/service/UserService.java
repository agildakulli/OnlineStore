package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.respository.UserRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserService {

    private UserRespository userRespository;
    private UserMapper userMapper;
}
