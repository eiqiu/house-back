package com.xinjia.house.controller;

import com.xinjia.house.pojo.Category;
import com.xinjia.house.pojo.House;
import com.xinjia.house.service.HouseService;
import com.xinjia.house.service.ImageSerice;
import com.xinjia.house.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Api(tags = "房屋的各类信息接口")
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private ImageSerice imageSerice;
    @Autowired
    private HouseService houseService;

    @ApiOperation("发布房屋")
    @RequestMapping(value = "/addHouse", method = RequestMethod.POST)
    public Result<String> addHouse(@RequestPart("house") House house,@RequestPart("file")MultipartFile[] files){
        System.out.println(house);
        return Result.success(200,"成功",imageSerice.uploadImages(files));
    }

    @ApiOperation("获取分类列表")
    @RequestMapping(value = "/getCategorys", method = RequestMethod.POST)
    public Result<List<Category>> getCategorys(){
        return Result.success(200,"成功获取到分类信息", houseService.getCategories());
    }
}
