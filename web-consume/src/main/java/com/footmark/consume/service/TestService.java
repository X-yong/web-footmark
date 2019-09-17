package com.footmark.consume.service;

import com.common.footmark.User;
import com.footmark.consume.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;


    @Transactional
    public void insert(User u) {
        testMapper.insert(u);
        throw  new RuntimeException("ssssssssssss");
    }
}
