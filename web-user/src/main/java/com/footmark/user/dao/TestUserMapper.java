package com.footmark.user.dao;

import com.common.footmark.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/10 13:17
 */
public interface TestUserMapper {

    /**
     * description: 查询用户信息
     * @author : xiongyong
     * @param  :  user
     * @return : List<User>
     * @date   : 2018/10/11 9:15
     */
    List<User> queryUserInfo(User user);
    /**
     * description: 保存用户信息
     * @author : xiongyong
     * @param  :  user
     * @return : List<User>
     * @date   : 2018/10/11 9:15
     */
     void saveUserInfo(List<User> users);
}
