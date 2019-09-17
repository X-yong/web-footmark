package com.footmark.consume.controller;


import com.common.footmark.User;
import com.footmark.consume.dao.TestMapper;
import com.footmark.consume.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/t")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public void test(String userId) {
        System.out.printf("---------------------------------");
        User u = new User();
        u.setName(UUID.randomUUID().toString());
        testService.insert(u);
    }

}
