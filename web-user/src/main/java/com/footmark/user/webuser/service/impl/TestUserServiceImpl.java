package com.footmark.user.webuser.service.impl;

import com.footmark.user.webuser.dao.TestUserMapper;
import com.footmark.user.webuser.service.TestUserService;
import com.web.common.footmark.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/11 9:14
 */
@Service
public class TestUserServiceImpl implements TestUserService {

   @Autowired
   private TestUserMapper testUserMapper;

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
     * description: 保存用户信息
     * @param users
     * @return : List<User>
     * @author : xiongyong
     * @date : 2018/10/11 9:15
     */
    @Override
    public void saveUserInfo(List<User> users) {
        testUserMapper.saveUserInfo(users);
    }
}
