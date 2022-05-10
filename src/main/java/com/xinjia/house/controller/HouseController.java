package com.xinjia.house.controller;

import com.github.pagehelper.PageInfo;
import com.xinjia.house.pojo.Category;
import com.xinjia.house.pojo.Collection;
import com.xinjia.house.pojo.House;
import com.xinjia.house.service.HouseService;
import com.xinjia.house.service.ImageSerice;
import com.xinjia.house.vo.House.CollectionHouseVo;
import com.xinjia.house.vo.House.HouseVo;
import com.xinjia.house.vo.House.search;
import com.xinjia.house.vo.Page.PageVo;
import com.xinjia.house.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(tags = "房屋的各类信息接口")
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private ImageSerice imageSerice;
    @Autowired
    private HouseService houseService;

    @ApiOperation("获取所有房屋")
    @RequestMapping(value = "/getHouse", method = RequestMethod.POST)
    public Result<PageInfo<HouseVo>> selectAllByPageInfo(@RequestBody PageVo pageVo) {
        return Result.success(200,"成功",houseService.selectAllByPageInfo(pageVo));
    }

    @ApiOperation("获取单一房屋")
    @RequestMapping(value = "/getHouseByID", method = RequestMethod.POST)
    public Result<HouseVo> getHouseById(@RequestBody Map<String,Object> reqMap) {
        int house_id = Integer.parseInt(reqMap.get("house_id").toString());
        return Result.success(200,"成功",houseService.getHouseById(house_id));
    }

    @ApiOperation("发布房屋")
    @RequestMapping(value = "/addHouse", method = RequestMethod.POST)
    public Result<String> addHouse(@RequestPart("house") House house,@RequestPart("file")MultipartFile[] files){
        houseService.addHouse(house);
        imageSerice.uploadImages(files);
        return Result.success(200,"成功","成功");
    }

    @ApiOperation("修改房屋")
    @RequestMapping(value = "/modifyHouse", method = RequestMethod.POST)
    public Result<String> modifyHouse(@RequestPart("house") House house,@RequestPart("file")MultipartFile[] files){
        return Result.success(200, "成功");
    }

    @ApiOperation("获取分类列表")
    @RequestMapping(value = "/getCategory", method = RequestMethod.POST)
    public Result<List<Category>> getCategorys(){
        return Result.success(200,"成功获取到分类信息", houseService.getCategories());
    }

    @ApiOperation("是否已收藏")
    @RequestMapping(value = "/ifCollected", method = RequestMethod.POST)
    public Result<Boolean> ifCollected(@RequestBody CollectionHouseVo collectionHouseVo){
        Boolean ifCollected = houseService.ifCollected(collectionHouseVo.getUser_id(), collectionHouseVo.getHouse_id());
        if (ifCollected){
            // 已收藏
            return Result.success(200,"已收藏",true);
        }else {
            return Result.success(200,"未收藏",false);
        }
    }
    /**
     *删除收藏的房屋
     * @param collectionHouseVo
     * @return
     */
    @ApiOperation("删除收藏的房屋")
    @RequestMapping(value = "/delCollectionHouse",method = RequestMethod.POST)
    public Result delCollectionHouse(@RequestBody CollectionHouseVo collectionHouseVo){
        System.out.println(collectionHouseVo);
        int user_id = collectionHouseVo.getUser_id();
        int house_id = collectionHouseVo.getHouse_id();
        //先检查是否存在这个收藏房屋
        Collection check_collection_exist1 = houseService.checkCollectionHouse(user_id,house_id);
        if (check_collection_exist1 != null){
            houseService.deleteCollectionHouse(user_id,house_id);
            //再检查是否删除
            Collection check_collection_exist2 = houseService.checkCollectionHouse(user_id,house_id);
            if (check_collection_exist2 != null){
                return Result.failure(999,"删除失败!");
            }else{
                return Result.success(100,"删除成功！");
            }
        }else{
            return Result.failure(999,"该房屋不存在！");
        }
    }

    /**
     * 添加收藏房屋
     * @param collectionHouseVo
     * @return
     */
    @ApiOperation("添加收藏房屋")
    @RequestMapping(value = "/addCollectionHouse",method = RequestMethod.POST)
    public Result addCollectionHouse(@RequestBody CollectionHouseVo collectionHouseVo){
        System.out.println(collectionHouseVo);
        int user_id = collectionHouseVo.getUser_id();
        int house_id = collectionHouseVo.getHouse_id();
        //先检查是否存在这个收藏房屋
        Collection check_collection_exist1 = houseService.checkCollectionHouse(user_id,house_id);
        if (check_collection_exist1 != null){
            return Result.failure(999,"该房屋已在收藏列表里啦~");
        }else {
            houseService.addCollectionHouse(user_id,house_id);
        }
        Collection collection = houseService.checkCollectionHouse(user_id,house_id);
        System.out.println(collection);
        return Result.success(100,"收藏成功",collection);
    }
    @ApiOperation("根据关键字搜索房屋")
    @RequestMapping(value = "/searchHouseList",method = RequestMethod.POST)
    public Result <Map<String,Object>> searchHouseList(@RequestBody search searchWord, int page, int limit){
        System.out.println(searchWord);
        String search  = searchWord.getSearchWord();
        Map<String,Object> house = houseService.searchHouse(page,limit,search);
        if (house != null){
            return Result.success(100,"搜索成功",house);
        }else{
            return Result.failure(999,"搜索失败");
        }
    }
}
