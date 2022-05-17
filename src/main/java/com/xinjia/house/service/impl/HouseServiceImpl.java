package com.xinjia.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinjia.house.dao.HouseDao;
import com.xinjia.house.pojo.Category;
import com.xinjia.house.pojo.Collection;
import com.xinjia.house.pojo.House;
import com.xinjia.house.service.HouseService;
import com.xinjia.house.util.PageHelperUtils;
import com.xinjia.house.vo.House.HouseVo;
import com.xinjia.house.vo.Page.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseDao houseDao;

    @Override
    public PageInfo<HouseVo> searchHouse(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        List<HouseVo> houses = houseDao.searchHouse(pageVo);
        return new PageInfo<>(houses);
    }

    @Override
    public void addHouse(House house) {
        houseDao.addHouse(house);
    }

    @Override
    public void modifyHouse(House house) {
        houseDao.modifyHouse(house);
    }

    @Override
    public void deleteMyHouse(int house_id) {
        houseDao.deleteMyHouse(house_id);
    }

    @Override
    public PageInfo<HouseVo> selectAllByPageInfo(PageVo pageVo) {
        return PageHelperUtils.getPageInfo(pageVo.getPageNum(), pageVo.getPageSize(), houseDao.selectAllByPage(pageVo));
    }

    @Override
    public HouseVo getHouseById(int houseId) {
        return houseDao.getHouseById(houseId);
    }

    @Override
    public List<Category> getCategories() {
        return houseDao.getCategories();
    }

    @Override
    public Boolean ifCollected(int userId, int houseId) {
        Boolean ifCollect = houseDao.ifCollected(userId, houseId);
        if (ifCollect != null) {
            // 已经收藏
            return true;
        } else {
            // 没有收藏
            return false;
        }
    }

    @Override
    public void deleteCollectionHouse(int user_id, int house_id) {
        houseDao.deleteCollectionHouse(user_id, house_id);
    }

    @Override
    public void addCollectionHouse(Collection collection) {
        collection.setCollection_time(new Date());
        houseDao.addCollectionHouse(collection);
    }

    @Override
    public PageInfo<HouseVo> getCollection(PageVo pageVo) {
        return PageHelperUtils.getPageInfo(pageVo.getPageNum(), pageVo.getPageSize(), houseDao.getCollection(pageVo.getCollected_user_id()));
    }

    @Override
    public PageInfo<HouseVo> getMyHouse(PageVo pageVo) {
        return PageHelperUtils.getPageInfo(pageVo.getPageNum(), pageVo.getPageSize(), houseDao.getMyHouse(pageVo.getMyHouse_user_id()));
    }

    @Override
    public void addClick(int house_id) {
        houseDao.addClick(house_id);
    }

    /**
     * 用于定时任务，修改热门商品
     */
    @Override
    public void modifyHotHouse() {

    }

}
