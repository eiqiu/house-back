package com.xinjia.house.dao;

import com.xinjia.house.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    Boolean ifExistUser(@Param("user_account") String user_account);
    void registerUser(User user);
    User checkUser(@Param("user_account") String user_account, @Param("user_password") String user_password);
}
