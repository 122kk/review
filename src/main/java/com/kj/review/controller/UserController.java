package com.kj.review.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kj.review.Entity.User;
import com.kj.review.Tools.JWTTockenUtils;
import com.kj.review.Tools.R;
import com.kj.review.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.concurrent.TimeUnit;

/**
 * @author kj
 * @date 2023/3/4
 * @apiNote
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api("用户接口")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     *
     * @param page 当前页
     * @param pageSize 每页显示条数
     * @return
     */
    @PostMapping("/page")
    public R<Page> getUserPage(int page,int pageSize){
        Page pageInfo=new Page(page,pageSize);
        userService.page(pageInfo);
        return R.success(200,pageInfo);
    }

    @PostMapping("/save")
    @ApiOperation("用户注册")
    public R<String> save(@RequestBody User user){
        log.info("user:{}",user);
        userService.save(user);
        log.info("user:{}",user);
        return R.success(200,"用户注册成功！！");
    }

    @GetMapping("/{id}")
    @ApiOperation("测试获取Token")
    public String getToken(@PathVariable Long id){

        return redisTemplate.opsForValue().get("userToken").toString();
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public R<String> login(@RequestBody User user){
        log.info("user:{}",user);
        log.info("redisTemplate:{}",redisTemplate);
        if ("admin".equals(user.getUserName())&&"123456".equals(user.getPassword())){
            String jwtToken = JWTTockenUtils.getJwtToken(user.getId());
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set("userToken",jwtToken,6, TimeUnit.HOURS);
            log.info("token:{}",jwtToken);
            return R.success(200,"登录成功",jwtToken);
        }
        return R.error(400,"密码错误！！！");
    }

    @GetMapping("/selectById/{id}")
    @ApiOperation("通过id查询用户")
    public R<User> selectById(@PathVariable Long id){
        User byId = userService.getById(id);
        return R.success(200,byId);
    }


    @DeleteMapping
    public R<String> delete(@RequestBody User user){
        userService.removeById(user.getId());
        return R.success(200,"用户删除成功!!!");
    }
}
