package com.study.service;

import com.study.model.UserModel;

/**
 * @author xsy
 * @date 2021-04-29 5:16 下午
 */
public interface UserService {
    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
    UserModel getUserByLoginName(String loginName);

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    UserModel getUserById(long userId);

    /**
     * 新增用户
     * @param userModel
     * @return
     */
    int addUser(UserModel userModel);

}
