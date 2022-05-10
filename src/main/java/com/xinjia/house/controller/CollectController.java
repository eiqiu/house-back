package com.xinjia.house.controller;

import com.xinjia.house.service.CollectService;
import com.xinjia.house.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "收藏")
@RestController("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @ApiOperation("收藏房屋")
    @RequestMapping(value = "/addCollect", method = RequestMethod.POST)
    public Result<String> addCollect(String userId, String housenId){
        return Result.success(200,"成功");
    }

    @ApiOperation("取消收藏房屋")
    @RequestMapping(value = "/removeCollect", method = RequestMethod.POST)
    public Result<String> removeCollect(String userId, String housenId){
        return Result.success(200,"成功");
    }
}
