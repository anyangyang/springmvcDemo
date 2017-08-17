package com.springmvc.Dao;

import com.springmvc.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zhujiating on 2017/6/28.
 */


public interface UserMapper {

     User loadUserById(int id);

}
