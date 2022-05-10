package com.xinjia.house.dao;

import com.xinjia.house.pojo.HousePicture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImageDao {
    void addHousePictures(List<HousePicture> pictures);
}
