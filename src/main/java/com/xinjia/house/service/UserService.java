package com.xinjia.house.service;

import com.xinjia.house.pojo.User;
import com.xinjia.house.vo.User.UserVo;

import java.util.List;

public interface UserService {
    Boolean ifExistUser(String user_account);

    void registerUser(User user);

    User checkUser(String user_account, String user_password);

    User modifyUser(User user);
}
