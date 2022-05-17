package com.xinjia.house.dao;

import com.xinjia.house.pojo.Category;
import com.xinjia.house.pojo.Collection;
import com.xinjia.house.pojo.House;
import com.xinjia.house.vo.House.HouseVo;
import com.xinjia.house.vo.Page.PageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HouseDao {
    List<HouseVo> searchHouse(@Param("pageVo") PageVo pageVo);

    void addHouse(House house);

    void modifyHouse(House house);

    void deleteMyHouse(@Param("house_id") int house_id);

    List<Category> getCategories();

    HouseVo getHouseById(@Param("house_id") int house_id);

    Boolean ifCollected(@Param("user_id") int user_id, @Param("house_id") int house_id);

    void deleteCollectionHouse(@Param("user_id") int user_id, @Param("house_id") int house_id);

    void addCollectionHouse(@Param("collection") Collection collection);

    List<HouseVo> selectAllByPage(@Param("pageVo") PageVo pageVo);

    List<HouseVo> getCollection(@Param("user_id") int user_id);

    List<HouseVo> getMyHouse(@Param("user_id") int user_id);

    void addClick(@Param("house_id") int house_id);

    void modifyHotHouse();
}
