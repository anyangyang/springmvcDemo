package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

}
