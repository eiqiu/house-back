package com.xinjia.house.controller;

import com.github.pagehelper.PageInfo;
import com.xinjia.house.pojo.User;
import com.xinjia.house.service.HouseService;
import com.xinjia.house.service.UserService;
import com.xinjia.house.vo.House.HouseVo;
import com.xinjia.house.vo.Page.PageVo;
import com.xinjia.house.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@Api(tags = "管理员")
@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private HouseService houseService;

    @Autowired
    private UserService userService;

    @ApiOperation("获取所有房屋")
    @RequestMapping(value = "/getHouse", method = RequestMethod.POST)
    public Result<PageInfo<HouseVo>> selectAllByPageInfo(@RequestBody PageVo pageVo) {
        return Result.success(200, "成功", houseService.getAllHouse(pageVo));
    }

    @ApiOperation("根据关键字搜索房屋")
    @RequestMapping(value = "/searchHouse", method = RequestMethod.POST)
    public Result<PageInfo<HouseVo>> searchHouse(@RequestBody PageVo pageVo) {
        return Result.success(200, "成功", houseService.adminSearchHouse(pageVo));
    }

    @ApiOperation("修改房屋状态")
    @RequestMapping(value = "/changeHouseState", method = RequestMethod.POST)
    public Result<Boolean> changeHouseState(@RequestBody Map<String, Object> reqMap) {
        int house_id = Integer.parseInt(reqMap.get("house_id").toString());
        int house_state = Integer.parseInt(reqMap.get("house_state").toString());
        int user_id = Integer.parseInt(reqMap.get("user_id").toString());
        houseService.changeHouseState(house_id, house_state, user_id);
        return Result.success(200,"成功", true);
    }

    @ApiOperation("删除房屋")
    @RequestMapping(value = "/deleteHouse", method = RequestMethod.POST)
    public Result<Boolean> deleteHouse(@RequestBody Map<String, Object> reqMap) {
        int house_id = Integer.parseInt(reqMap.get("house_id").toString());
        houseService.deleteMyHouse(house_id);
        return Result.success(200, "删除成功", true);
    }

    @ApiOperation("获取所有的用户列表")
    @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public Result<List<User>> checkAllUserInfo(){
        return Result.success(200,"查询成功",userService.checkAllUser());
    }

    @ApiOperation("搜索用户")
    @RequestMapping(value = "/searchUserInfo",method = RequestMethod.POST)
    public Result<List<User>> searchUserInfo(@RequestBody Map<String, Object> reqMap){
        String keyWords = reqMap.get("keyWords").toString();
        return Result.success(200,"查询成功",userService.searchUserByKeyWord(keyWords));
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/deleteUserInfo",method = RequestMethod.POST)
    public Result deleteUserInfo(@RequestBody User user){
        userService.deleteUser(user.getUser_id());
        return Result.success(200,"删除成功");
    }

    @ApiOperation("修改个人信息")
    @RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST)
    public Result<User> modifyUser(@RequestBody User user) {
        System.out.println(user);
        return Result.success(200, "修改成功", userService.modifyUser(user));
    }
}
