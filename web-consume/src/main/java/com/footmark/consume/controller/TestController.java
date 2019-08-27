package com.footmark.consume.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t")
public class TestController {

    @RequestMapping("/test")
    public void test(String userId) {
        System.out.printf("---------------------------------");
        throw  new RuntimeException("ssssssssssss");
    }

}
