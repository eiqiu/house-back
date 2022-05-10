package com.xinjia.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinjia.house.dao.HouseDao;
import com.xinjia.house.pojo.Category;
import com.xinjia.house.pojo.Collection;
import com.xinjia.house.pojo.House;
import com.xinjia.house.service.HouseService;
import com.xinjia.house.vo.House.HouseVo;
import com.xinjia.house.vo.Page.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseDao houseDao;

    @Override
    public void addHouse(House house) {
        houseDao.addHouse(house);
    }

    @Override
    public PageInfo<HouseVo> selectAllByPageInfo(PageVo pageVo) {
        // 设置起始页，页数据量大小
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        List<HouseVo> houses = houseDao.selectAllByPage(pageVo);
        return new PageInfo<>(houses);
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
        if (ifCollect != null){
            // 已经收藏
            return true;
        }else {
            // 没有收藏
            return false;
        }
    }

    @Override
    public void deleteCollectionHouse(int user_id, int house_id) {
        System.out.println("Service"+user_id+house_id);
        houseDao.deleteCollectionHouse(user_id,house_id);
    }

    /**
     * 查看收藏房屋
     * @param user_id
     * @param house_id
     * @return
     */
    @Override
    public Collection checkCollectionHouse(int user_id, int house_id) {
        System.out.println("checkService"+user_id+house_id);
        return houseDao.checkCollectionHouse(user_id,house_id);
    }

    /**
     *添加收藏房屋
     * @param user_id
     * @param house_id
     */
    @Override
    public void addCollectionHouse(int user_id, int house_id) {
        System.out.println("Service插入");
        houseDao.addCollectionHouse(user_id,house_id);
    }

    /**
     * 模糊查询，根据关键字搜索房屋
     * @param searchWord
     * @return
     */
    @Override
    public List<House> searchHouse(String searchWord) {
        return houseDao.searchHouse(searchWord);
    }

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @param searchWord
     * @return
     */
    @Override
    public Map<String,Object> searchHouse(Integer pageNum,Integer pageSize,String searchWord){
        PageHelper.startPage(pageNum, pageSize);
        List<House> list = houseDao.searchHouse(searchWord);
        PageInfo<House> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("total",total);
        return map;
    }
}
