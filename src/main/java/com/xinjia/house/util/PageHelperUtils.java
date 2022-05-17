package com.xinjia.house.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sd150
 */
public class PageHelperUtils {
    /**
     * 手动分页，当涉及到多表查询时，默认的PageHelper不好用，其原理为跟踪SQL，根据其查询的次数进行匹配
     * @param currentPage
     * @param pageSize
     * @param list
     * @param <T>
     * @return
     */
    public static <T> PageInfo<T> getPageInfo(int currentPage, int pageSize, List<T> list) {
        // 首先获取查询到个数
        int total = list.size();
        // 处理 total 与 pageSize 不符的问题
        if (total > pageSize) {
            int toIndex = pageSize * currentPage;
            if (toIndex > total) {
                toIndex = total;
            }
            // 截取当前页的 list 数据
            if (pageSize * (currentPage - 1)<toIndex) {
                list = list.subList(pageSize * (currentPage - 1), toIndex);
            }
            else {
                list=new ArrayList<>();
            }
        }
        Page<T> page = new Page<>(currentPage, pageSize);
        page.addAll(list);
        page.setPages((total + pageSize - 1) / pageSize);
        page.setTotal(total);

        return new PageInfo<>(page);
    }
}

