package com.xinjia.house.service;

import com.github.pagehelper.PageInfo;
import com.xinjia.house.pojo.Category;
import com.xinjia.house.pojo.Collection;
import com.xinjia.house.pojo.House;
import com.xinjia.house.vo.House.HouseVo;
import com.xinjia.house.vo.Page.PageVo;

import java.util.List;
import java.util.Map;

public interface HouseService {
    void addHouse(House house);
    public PageInfo<HouseVo> selectAllByPageInfo(PageVo pageVo);
    public HouseVo getHouseById(int houseId);
    public List<Category> getCategories();
    public Boolean ifCollected(int userId, int houseId);
    public void deleteCollectionHouse(int user_id,int house_id);
    public Collection checkCollectionHouse(int user_id,int house_id);
    public void addCollectionHouse(int user_id,int house_id);
    public List<House> searchHouse(String searchWord);
    public Map<String,Object> searchHouse(Integer pageNum,Integer pageSize,String searchWord);
}
