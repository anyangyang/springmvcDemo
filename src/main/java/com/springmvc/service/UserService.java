package com.springmvc.service;

import com.springmvc.entity.User;

/**
 * Created by zhujiating on 2017/6/28.
 */
public interface UserService {
    public User loadUserById(int id);
}