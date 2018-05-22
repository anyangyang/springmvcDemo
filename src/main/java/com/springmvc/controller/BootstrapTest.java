package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/bootstrap")
public class BootstrapTest {

    @RequestMapping(value = "/test",method = {RequestMethod.GET,RequestMethod.POST})
    public String bootstrapTest(HttpServletResponse response, HttpServletRequest request) {
        return "/bootstrapTest";
    }
}
