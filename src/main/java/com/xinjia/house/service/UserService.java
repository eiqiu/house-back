package com.xinjia.house.service;

import com.github.pagehelper.PageInfo;
import com.xinjia.house.pojo.Message;
import com.xinjia.house.pojo.User;
import com.xinjia.house.vo.Page.PageVo;

import java.util.List;

public interface UserService {
    Boolean ifExistUser(String user_account);

    void registerUser(User user);

    User checkUser(String user_account, String user_password);

    User modifyUser(User user);

    PageInfo<Message> getMessages(PageVo pageVo);

    void changeMessageState(int user_id);

    List<User> checkAllUser();

    List<User> searchUserByKeyWord(String keyWords);

    void deleteUser(int user_id);
}
