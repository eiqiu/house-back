package com.xinjia.house.dao;

import com.xinjia.house.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserDao {
    public User getUser();
}
