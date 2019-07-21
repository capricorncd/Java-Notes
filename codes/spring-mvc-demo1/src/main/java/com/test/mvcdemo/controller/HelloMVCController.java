package com.test.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMVCController {

  @RequestMapping("/mvc")
  // 该方法会响应请求host:8080/hello/mvc
  // 返回到home.jsp
  public String helloMVC() {
    // 返回到home.jsp
    return "home";
  }
  
}
