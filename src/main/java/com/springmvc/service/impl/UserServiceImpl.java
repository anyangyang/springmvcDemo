package com.springmvc.service.impl;

import com.springmvc.entity.User;
import com.springmvc.Dao.UserMapper;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by zhujiating on 2017/6/28.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User loadUserById(int id) {
        User user = userMapper.loadUserById(id);
        return user;
    }
}
