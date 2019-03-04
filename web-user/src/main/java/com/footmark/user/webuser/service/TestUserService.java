package com.footmark.user.webuser.service;

import com.web.common.footmark.User;

import java.util.List;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/11 9:13
 */

public interface TestUserService {

    /**
     * description: 查询用户信息
     * @author : xiongyong
     * @param  :  user
     * @return : List<User>
     * @date   : 2018/10/11 9:15
     */
    List<User> queryUserInfo(User user);

    /**
     * description: 查询用户信息
     * @author : xiongyong
     * @param  :  user
     * @return : List<User>
     * @date   : 2018/10/11 9:15
     */
    void saveUserInfo(List<User> users);
 }
