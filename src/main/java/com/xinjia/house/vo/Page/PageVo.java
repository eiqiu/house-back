package com.xinjia.house.vo.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    // 当前页码
    private int pageNum;
    // 每页显示数
    private int pageSize;
    // 查询分类
    private int categoryID;
    private String keywords;
}
