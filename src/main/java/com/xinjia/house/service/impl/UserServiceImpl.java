package com.xinjia.house.service.impl;

import com.xinjia.house.dao.UserDao;
import com.xinjia.house.pojo.User;
import com.xinjia.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUser() {
        return userDao.getUser();
    }
}
