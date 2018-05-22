package com.springmvc.service;

import com.springmvc.entity.User;

import java.util.List;

/**
 * Created by zhujiating on 2017/6/28.
 */
public interface UserService {

     User loadUserById(int id);

     int batchInsertUser(List<User> userList);
}
