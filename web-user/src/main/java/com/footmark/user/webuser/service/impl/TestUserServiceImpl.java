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
     * description: 查询用户信息
     * @param users
     * @return : List<User>
     * @author : xiongyong
     * @date : 2018/10/11 9:15
     */
    @Override
    public void saveUserInfo(List<User> users) {
        int size = users.size();
        for (int j = (size-1)*30; j <= size*30; j++) {
            if(j == 0) {
                j = 1;
            }
            final int index = j;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<User> users1 = new ArrayList<>();
                    for (int i = (index-1)*50000; i < 50000*index; i++) {
                        users1.add(new User(i,"zhangsan"+i));
                    }
                    testUserMapper.saveUserInfo(users1);
                }
            }).start();
        }

      /*  for (int i = 1; i < 10000; i++) {
            users.add(new User(i,"zhangsan"+i));
        }
        testUserMapper.saveUserInfo(users);

        List<User> users1 = new ArrayList<>();
        for (int i = 10000; i < 20000; i++) {
            users1.add(new User(i,"lisi"+i));
        }
        testUserMapper.saveUserInfo(users1);

        List<User> users2 = new ArrayList<>();
        for (int i = 20000; i < 30000; i++) {
            users2.add(new User(i,"wangwu"+i));
        }
        testUserMapper.saveUserInfo(users2);*/
    }
}
