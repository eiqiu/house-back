package com.xinjia.house.controller;

import com.github.pagehelper.PageInfo;
import com.xinjia.house.pojo.Category;
import com.xinjia.house.pojo.Collection;
import com.xinjia.house.pojo.House;
import com.xinjia.house.service.HouseService;
import com.xinjia.house.service.ImageService;
import com.xinjia.house.vo.House.HouseVo;
import com.xinjia.house.vo.Page.PageVo;
import com.xinjia.house.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Api(tags = "房屋的各类信息接口")
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private ImageService imageService;
    @Autowired
    private HouseService houseService;

    @ApiOperation("获取所有房屋")
    @RequestMapping(value = "/getHouse", method = RequestMethod.POST)
    public Result<PageInfo<HouseVo>> selectAllByPageInfo(@RequestBody PageVo pageVo) {
        return Result.success(200, "成功", houseService.selectAllByPageInfo(pageVo));
    }

    @ApiOperation("获取单一房屋")
    @RequestMapping(value = "/getHouseByID", method = RequestMethod.POST)
    public Result<HouseVo> getHouseById(@RequestBody Map<String, Object> reqMap) {
        int house_id = Integer.parseInt(reqMap.get("house_id").toString());
        return Result.success(200, "成功", houseService.getHouseById(house_id));
    }

    @ApiOperation("发布房屋")
    @RequestMapping(value = "/addHouse", method = RequestMethod.POST)
    public Result<String> addHouse(@RequestPart("house") House house, @RequestPart("file") MultipartFile[] files) {
        houseService.addHouse(house);
        imageService.uploadImages(files);
        return Result.success(200, "成功", "成功");
    }

    @ApiOperation("修改房屋")
    @RequestMapping(value = "/modifyHouse", method = RequestMethod.POST)
    public Result<String> modifyHouse(@RequestPart("house") House house, @RequestPart("file") MultipartFile[] files) {
        System.out.println(house);
        houseService.modifyHouse(house);
        imageService.modifyImages(files,house.getHouse_id());
        return Result.success(200, "成功","成功修改！");
    }

    @ApiOperation("获取分类列表")
    @RequestMapping(value = "/getCategory", method = RequestMethod.POST)
    public Result<List<Category>> getCategorys() {
        return Result.success(200, "成功获取到分类信息", houseService.getCategories());
    }

    @ApiOperation("是否已收藏")
    @RequestMapping(value = "/ifCollected", method = RequestMethod.POST)
    public Result<Boolean> ifCollected(@RequestBody Collection collection) {
        Boolean ifCollected = houseService.ifCollected(collection.getUser_id(), collection.getHouse_id());
        if (ifCollected) {
            // 已收藏
            return Result.success(200, "已收藏", true);
        } else {
            return Result.success(200, "未收藏", false);
        }
    }

    @ApiOperation("获取收藏房屋")
    @RequestMapping(value = "/getCollection", method = RequestMethod.POST)
    public Result<PageInfo<HouseVo>> getCollection(@RequestBody PageVo pageVo) {
        return Result.success(200, "成功", houseService.getCollection(pageVo));
    }

    @ApiOperation("获取我发布的房屋")
    @RequestMapping(value = "/getMyHouse", method = RequestMethod.POST)
    public Result<PageInfo<HouseVo>> getMyHouse(@RequestBody PageVo pageVo) {
        return Result.success(200, "成功", houseService.getMyHouse(pageVo));
    }

    @ApiOperation("添加收藏")
    @RequestMapping(value = "/addCollection", method = RequestMethod.POST)
    public Result<Boolean> addCollection(@RequestBody Collection collection) {
        houseService.addCollectionHouse(collection);
        return Result.success(200, "收藏成功", true);
    }

    @ApiOperation("取消收藏")
    @RequestMapping(value = "/deleteCollection", method = RequestMethod.POST)
    public Result<Boolean> deleteCollection(@RequestBody Collection collection) {
        houseService.deleteCollectionHouse(collection.getUser_id(), collection.getHouse_id());
        return Result.success(200, "取消收藏成功", true);
    }

    @ApiOperation("删除我的房屋")
    @RequestMapping(value = "/deleteMyHouse", method = RequestMethod.POST)
    public Result<Boolean> deleteMyhouse(@RequestBody Map<String, Object> reqMap){
        int house_id = Integer.parseInt(reqMap.get("house_id").toString());
        houseService.deleteMyHouse(house_id);
        return Result.success(200,"删除成功", true);
    }

    @ApiOperation("根据关键字搜索房屋")
    @RequestMapping(value = "/searchHouse", method = RequestMethod.POST)
    public Result<PageInfo<HouseVo>> searchHouse(@RequestBody PageVo pageVo) {
        return Result.success(200, "成功", houseService.searchHouse(pageVo));
    }

    @ApiOperation("增加用户点击量")
    @RequestMapping(value = "/addClick", method = RequestMethod.POST)
    public void addClick(@RequestBody Map<String, Object> reqMap){
        int house_id = Integer.parseInt(reqMap.get("house_id").toString());
        houseService.addClick(house_id);
    }
}
