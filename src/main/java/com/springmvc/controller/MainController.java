package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;
import com.springmvc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhujiating on 2017/6/27.
 */
@Controller
//@RequestMapping(value="/main")
public class MainController {


    @RequestMapping(value = "/welcome",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView index(HttpServletRequest request){
        UserServiceImpl userServiceImpl= new UserServiceImpl();
        User user = userServiceImpl.loadUserById(1);
        ModelAndView model = new ModelAndView("/welcome","user",user);
        return model;
    }


}
