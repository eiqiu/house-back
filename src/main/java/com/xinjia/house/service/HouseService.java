package com.xinjia.house.service;

import com.github.pagehelper.PageInfo;
import com.xinjia.house.pojo.Category;
import com.xinjia.house.pojo.Collection;
import com.xinjia.house.pojo.House;
import com.xinjia.house.vo.House.HouseVo;
import com.xinjia.house.vo.Page.PageVo;

import java.util.List;

public interface HouseService {
    PageInfo<HouseVo> searchHouse(PageVo pageVo);

    void addHouse(House house);

    void modifyHouse(House house);

    PageInfo<HouseVo> selectAllByPageInfo(PageVo pageVo);

    HouseVo getHouseById(int houseId);

    List<Category> getCategories();

    Boolean ifCollected(int userId, int houseId);

    void deleteCollectionHouse(int user_id, int house_id);

    void addCollectionHouse(Collection collection);

    PageInfo<HouseVo> getCollection(PageVo pageVo);

    PageInfo<HouseVo> getMyHouse(PageVo pageVo);

}
