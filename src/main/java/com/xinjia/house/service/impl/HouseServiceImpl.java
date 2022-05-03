package com.xinjia.house.service.impl;

import com.xinjia.house.dao.HouseDao;
import com.xinjia.house.pojo.Category;
import com.xinjia.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseDao houseDao;

    /**
     * 获取分类列表
     * @return
     */
    @Override
    public List<Category> getCategories() {
        return houseDao.getCategories();
    }
}
