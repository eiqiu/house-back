package com.xinjia.house.service.impl;

import com.github.pagehelper.PageInfo;
import com.xinjia.house.dao.UserDao;
import com.xinjia.house.pojo.Message;
import com.xinjia.house.pojo.User;
import com.xinjia.house.service.UserService;
import com.xinjia.house.util.PageHelperUtils;
import com.xinjia.house.vo.Page.PageVo;
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
    public User modifyUser(User user) {
        userDao.modifyUser(user);
        return userDao.getUserById(user.getUser_id());
    }

    @Override
    public PageInfo<Message> getMessages(PageVo pageVo) {
        return PageHelperUtils.getPageInfo(pageVo.getPageNum(), pageVo.getPageSize(), userDao.getMessages(pageVo.getUser_id()));
    }

    @Override
    public void changeMessageState(int user_id) {
        userDao.changeMessageState(user_id);
    }

    @Override
    public List<User> checkAllUser() {
        return userDao.checkAllUser();
    }

    @Override
    public List<User> searchUserByKeyWord(String keyWords) {
        System.out.println(userDao.searchUserByKeyWord(keyWords));
        return userDao.searchUserByKeyWord(keyWords);
    }

    @Override
    public void deleteUser(int user_id) {
        userDao.deleteUser(user_id);
    }
}
