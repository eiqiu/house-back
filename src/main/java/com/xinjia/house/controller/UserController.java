package com.xinjia.house.controller;

import com.xinjia.house.pojo.User;
import com.xinjia.house.service.UserService;
import com.xinjia.house.vo.Result;
import com.xinjia.house.vo.User.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("登陆")
    @RequestMapping(value = "/login")
    public Result<User> login(@RequestBody UserVo userVo){
        User user = new User(1,"15066699887","张三","15988988787","男",21,"山东省,烟台市,莱山区,山东工商学院","123456","test");
        return Result.success(200,"成功",user);
    }

    @ApiOperation("注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result<String> register(String user_account, String user_password){
        System.out.println(user_account);
        return Result.success(200,"成功");
    }

    @ApiOperation("用户是否存在")
    @RequestMapping(value = "/findUserAccount",method = RequestMethod.POST)
    public Result<String> fineUserAccount(String user_account){
        System.out.println(user_account);
        return Result.success(200,"成功","没有重复的");
    }
}
