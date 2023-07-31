package com.yang.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.dao.User;
import com.yang.mapper.UserMapper;
import com.yang.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
