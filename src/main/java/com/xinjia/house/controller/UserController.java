package com.xinjia.house.controller;

import com.xinjia.house.pojo.User;
import com.xinjia.house.service.UserService;
import com.xinjia.house.vo.Result;
import com.xinjia.house.vo.User.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<User> userLogin(@RequestBody UserVo userVo) {
        User user = userService.checkUser(userVo.getUser_account(), userVo.getUser_password());
        if (user != null) {
            return Result.success(200, "登陆成功", user);
        } else {
            return Result.failure(201, "用户账号或密码错误！");
        }
    }

    @ApiOperation("用户是否存在")
    @RequestMapping(value = "/ifExist", method = RequestMethod.POST)
    public Result<Boolean> ifExistUser(@RequestBody Map<String, Object> reqMap) {
        String user_account = reqMap.get("user_account").toString();
        Boolean ifExist = userService.ifExistUser(user_account);
        if (ifExist) {
            // 账号存在
            return Result.success(200, "抱歉账号以存在", true);
        }
        return Result.success(200, "可以使用", false);
    }

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    Result<Boolean> userRegister(@RequestBody User user) {
        //用户进行注册
        userService.registerUser(user);
        return Result.success(200, "成功", true);
    }

    @ApiOperation("修改个人信息")
    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    public Result<String> modifyUser(@RequestBody User user) {
        userService.modifyUser(user);
        return Result.success(200, "修改成功", "ok");
    }

}
