package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhujiating on 2017/6/27.
 */
@Controller
@RequestMapping
public class MainController {

    @Autowired
    UserServiceImpl userServiceImpl ;

    @RequestMapping(value = "/hello",method={RequestMethod.POST,RequestMethod.GET})
    public String index(HttpServletRequest request,Model model){
        User user = userServiceImpl.loadUserById(1);
        model.addAttribute(user);
        return "/hello";
    }


}
