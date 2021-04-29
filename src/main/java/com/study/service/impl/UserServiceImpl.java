package com.study.service.impl;

import com.study.dao.UserDao;
import com.study.model.UserModel;
import com.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xsy
 * @date 2021-04-29 5:19 下午
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public UserModel getUserByLoginName(String loginName) {
        return userDao.selectByLoginName(loginName);
    }

    @Override
    public UserModel getUserById(long userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public int addUser(UserModel userModel) {
        return userDao.insertSelective(userModel);
    }
}
