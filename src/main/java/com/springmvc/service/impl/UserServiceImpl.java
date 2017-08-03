package com.springmvc.service.impl;

import com.springmvc.entity.User;
import com.springmvc.mapper.UserMapper;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by zhujiating on 2017/6/28.
 */

public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    public User loadUserById(int id) {
      return  userMapper.loadUserById(id);
    }


}
