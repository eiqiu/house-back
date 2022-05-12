package com.xinjia.house.service.impl;

import com.xinjia.house.dao.UserDao;
import com.xinjia.house.pojo.User;
import com.xinjia.house.service.UserService;
import com.xinjia.house.vo.User.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;

    @Override
    public Boolean ifExistUser(String user_account) {
        Boolean ifExist = userDao.ifExistUser(user_account);
        if (ifExist != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void registerUser(User user) {
        user.setUser_name("用户" + user.getUser_account().substring(0, 5));
        userDao.registerUser(user);
    }

    @Override
    public User checkUser(String user_account, String user_password) {
        return userDao.checkUser(user_account, user_password);
    }

    @Override
    public void modifyUser(User user) {
        userDao.modifyUser(user);
    }
}
