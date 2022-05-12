package com.xinjia.house.dao;

import com.xinjia.house.pojo.HousePicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImageDao {
    void addHousePictures(@Param("list") List<HousePicture> pictures);
    int getLastHouseId();
    void deleteHousePictures(@Param("house_id")int house_id);
}
