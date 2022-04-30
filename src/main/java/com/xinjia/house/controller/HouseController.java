package com.xinjia.house.controller;

import com.xinjia.house.pojo.House;
import com.xinjia.house.service.ImageSerice;
import com.xinjia.house.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Api(tags = "房屋")
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private ImageSerice imageSerice;
    @RequestMapping(value = "/addHouse", method = RequestMethod.POST)
    public Result<String> addHouse(@RequestPart("house") House house,@RequestPart("file")MultipartFile[] files){
        System.out.println(house);
        return Result.success(200,"成功",imageSerice.uploadImages(files));
    }
}
