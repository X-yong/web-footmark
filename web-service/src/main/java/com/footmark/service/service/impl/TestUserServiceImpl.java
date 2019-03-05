package com.footmark.service.service.impl;

import com.footmark.service.api.TestUserFeignService;
import com.footmark.service.dao.TestUserMapper;
import com.footmark.service.service.TestUserService;
import com.web.common.footmark.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/11 9:14
 */
@Service
public class TestUserServiceImpl implements TestUserService {

   @Autowired
   private TestUserMapper testUserMapper;

   @Autowired
   private TestUserFeignService testUserFeignService;
    /**
     * description: 查询用户信息
     * @param user
     * @return : List<User>
     * @author : xiongyong
     * @date : 2018/10/11 9:15
     */
    @Override
    public List<User> queryUserInfo(User user) {
        return testUserMapper.queryUserInfo(user);
    }

    /**
     * description: 查询用户信息
     * @param users
     * @return : List<User>
     * @author : xiongyong
     * @date : 2018/10/11 9:15
     */
    @Override
    @Transactional
    public void saveUserInfo(List<User> users) {
            testUserMapper.saveUserInfo(users);
        users.get(0).setId(users.get(0).getId() + 1);
        testUserFeignService.saveUserInfo(users);
    }
}
