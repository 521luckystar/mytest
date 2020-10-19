package com.wcc.mytest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping("/hello")
    public String hello(){
        return "wangchenchen, hello springboot !";
    }

}
