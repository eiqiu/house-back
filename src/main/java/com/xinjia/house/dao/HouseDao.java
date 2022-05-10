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
    void addHouse(House house);
    public List<Category> getCategories();
    public HouseVo getHouseById(@Param("house_id") int house_id);
    public Boolean ifCollected(@Param("user_id")int user_id, @Param("house_id")int house_id);
    public void deleteCollectionHouse(@Param("user_id") int user_id,@Param("house_id")int house_id);
    public Collection checkCollectionHouse(@Param("user_id") int user_id,@Param("house_id")int house_id);
    public void addCollectionHouse(@Param("user_id") int user_id,@Param("house_id") int house_id);
    public List<House> searchHouse(String searchWord);
    public List<HouseVo> selectAllByPage(@Param("pageVo") PageVo pageVo);
}
