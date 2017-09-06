package com.springmvc.controller;

import com.springmvc.entity.ApiResponse;
import com.springmvc.entity.User;
import com.springmvc.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

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

}
