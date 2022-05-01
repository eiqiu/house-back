package com.xinjia.house.controller;

import com.xinjia.house.pojo.User;
import com.xinjia.house.service.UserService;
import com.xinjia.house.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "登陆")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "login")
    public Result<User> login(String username, String password){
        return Result.success(200,"成功");
    }
}
