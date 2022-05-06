package com.xinjia.house.controller;

import com.xinjia.house.pojo.Category;
import com.xinjia.house.pojo.User;
import com.xinjia.house.vo.Result;
import com.xinjia.house.vo.User.UserVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "登陆接口")
@RestController
public class LoginController {
    /**
     * 登陆接口
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Result<User> userLogin(@RequestBody UserVo userVo){
        System.out.println(userVo);
        User user = new User(1,"15066699887","张三","15988988787","男",21,"山东省,烟台市,莱山区,山东工商学院","123456","test");
        return Result.success(200,"成功",user);
    }
    /**
     * 测试接口
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody Result<List<Category>> userList(@RequestBody UserVo userVo){
        System.out.println(userVo);
        Category category1 = new Category(2,"学区房");
        Category category2 = new Category(3,"医院房");
        List<Category> categoryList = new ArrayList<Category>();
        categoryList.add(category1);
        categoryList.add(category2);
        return Result.success(200,"登陆成功",categoryList);
    }
}
