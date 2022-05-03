package com.xinjia.house.dao;

import com.xinjia.house.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface HouseDao {
    public List<Category> getCategories();
}
