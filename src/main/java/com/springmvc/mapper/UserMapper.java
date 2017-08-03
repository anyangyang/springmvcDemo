package com.springmvc.mapper;

import com.springmvc.entity.User;

/**
 * Created by zhujiating on 2017/6/28.
 */


public interface UserMapper {
    public User loadUserById(int id);
}
