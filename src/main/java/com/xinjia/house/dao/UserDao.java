package com.xinjia.house.dao;

import com.xinjia.house.pojo.Message;
import com.xinjia.house.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    Boolean ifExistUser(@Param("user_account") String user_account);

    void registerUser(User user);

    User checkUser(@Param("user_account") String user_account, @Param("user_password") String user_password);

    void modifyUser(User user);

    User getUserById(@Param("user_id")int user_id);

    List<Message> getMessages(@Param("user_id") int user_id);

    void changeMessageState(@Param("user_id") int user_id);

    void noticeUser(@Param("user_id") int user_id, @Param("msg") String msg);

    List<User> checkAllUser();

    List<User> searchUserByKeyWord(@Param("keyWords") String keyWords);

    void deleteUser(@Param("user_id") int user_id);
}
