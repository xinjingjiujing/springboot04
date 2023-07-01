package com.lanou.controller;

import com.lanou.entity.User;
import com.lanou.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 段小威
 * @since 2023-05-08
 */
@RestController
@RequestMapping("/user")
@Api(tags = "蓝鸥接口文档")
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping("/findUserById/{id}")
    @ApiOperation(value = "根据id查找一个用户信息")
    public User findUserById(@PathVariable("id") int id){
        return userService.getById(id);
    }

    @DeleteMapping("/deleteUserById/{id}")
    @ApiOperation(value = "根据id删除一个用户信息")
    public boolean deleteUserById(@PathVariable("id") int id){
        return userService.removeById(id);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查找所有用户信息")
    public List<User> findAll(){
        return userService.list();
    }

    @PostMapping("/addUser")
    @ApiOperation("添加一个用户信息")
    public boolean addUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/updateUser")
    @ApiOperation("修改一个用户信息")
    public boolean updateUser(@RequestBody User user){
        return userService.update(user,null);
    }
}
