package com.xinjia.house.service;

import com.xinjia.house.pojo.Category;

import java.util.List;

public interface HouseService {
    // 获取房屋分类列表
    public List<Category> getCategories();
}
