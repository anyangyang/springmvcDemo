package com.springmvc.Dao;

import com.springmvc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhujiating on 2017/6/28.
 */


public interface UserMapper {

     User loadUserById(int id);

     // 批量插入用户，用于测试myabtis keyGenerator
     int batchInsertUser(List<User> userList);

}
