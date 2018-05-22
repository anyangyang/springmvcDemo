package com.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.springmvc.entity.messages.ApiResponse;
import com.springmvc.entity.User;
import com.springmvc.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhujiating on 2017/6/27.
 */
@Controller
@RequestMapping
public class MainController {

    @Autowired
    UserServiceImpl userServiceImpl ;

    HashMap hashMap = new HashMap();

    @Autowired
    JedisPool jedisPool;

    @RequestMapping(value = "/hello",method={RequestMethod.POST,RequestMethod.GET})
    public String index(HttpServletRequest request,Model model){
        User user = userServiceImpl.loadUserById(1);
        model.addAttribute(user);
        return "/hello";
    }


    @ResponseBody
    @RequestMapping(value = "/requestJson",method = {RequestMethod.GET,RequestMethod.POST})
    public User rquestJson(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setFirstName("anyang");
        user.setId(1);
        user.setLastName("an");
        user.setNickName("anyangyang");
//        HashMap<String,String> map = new HashMap<String,String>();
//        map.put("name","anyang");

        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/redisTest",method = {RequestMethod.GET,RequestMethod.POST})
    public ApiResponse redisTest(HttpServletRequest request,HttpServletResponse responser) throws IOException{
        ApiResponse api = new ApiResponse();
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.set("name","安阳");
        }finally {
            jedis.close();
        }

        String name = new String(jedis.get("name").getBytes(),"UTF8");
        api.setData(name);
        return api;
    }


    @ResponseBody
    @RequestMapping(value = "/redisPut",method = {RequestMethod.GET,RequestMethod.POST})
    public ApiResponse redisPut(HttpServletRequest request,HttpServletResponse responser) throws IOException{
        ApiResponse api = new ApiResponse();
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.hset("user","name","anyang");
            jedis.hset("user","sex","male");
            jedis.hset("user","age","23");
        }finally {
            jedis.close();
        }

//        String name = new String(jedis.get("name").getBytes(),"UTF8");
//        api.setData(name);
        return api;
    }

    @ResponseBody
    @RequestMapping(value = "/redisPop",method = {RequestMethod.GET,RequestMethod.POST})
    public ApiResponse redisPop(HttpServletRequest request,HttpServletResponse responser) throws IOException{
        ApiResponse api = new ApiResponse();
        User user = new User();
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            user.setNickName(jedis.hget("user","name"));
            user.setAge(Integer.valueOf(jedis.hget("user","age")));
            user.setSex(jedis.hget("user","sex"));
        }finally {
            jedis.close();
        }

//        String name = new String(jedis.get("name").getBytes(),"UTF8");
        api.setData(user);
        return api;
    }

    @ResponseBody
    @RequestMapping(value = "/batchInsertUser",method = {RequestMethod.GET,RequestMethod.POST})
    public ApiResponse<?> batchInsertUser(HttpServletRequest request, HttpServletResponse response){
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setFirstName("anyang");
        user1.setId(1);
        user1.setLastName("an");
        user1.setNickName("anyangyang");

        User use2r = new User();
        use2r.setFirstName("anyang");
        use2r.setId(1);
        use2r.setLastName("an");
        use2r.setNickName("anyangyang");
//
        userList.add(user1);
        userList.add(use2r);

        int i = userServiceImpl.batchInsertUser(userList);

        Iterator it = userList.iterator();
        while(it.hasNext()){
            User user = (User)it.next();
            System.out.println("userId:" + user.getId());
        }

        return ApiResponse.invokeSuccess(JSON.toJSONString(userList));

    }

}
