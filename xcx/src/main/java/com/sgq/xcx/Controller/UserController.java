package com.sgq.xcx.Controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sgq.xcx.Entity.BasePoJo.Response;
import com.sgq.xcx.Entity.LocalUser;
import com.sgq.xcx.Entity.RequestPoJo.UserReq;
import com.sgq.xcx.Entity.User;
import com.sgq.xcx.Mapper.UserMapper;
import com.sgq.xcx.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/getAllUser")
    @SentinelResource(value = "getAllUser", blockHandler = "exceptionHandler", fallback = "helloFallback")
    public List<User> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return allUser;
    }
    @PostMapping(value = "/addWxUser")
    public Response addWxUser(@RequestBody UserReq param){
        log.info("新增微信用户开始");
        log.info("入参："+param.toString());
        User build = User.builder().openid(param.getOpenid()).avatarUrl(param.getAvatarUrl()).city(param.getCity()).country(param.getCountry()).gender(param.getGender()).homelanguage(param.getHomelanguage()).nickName(param.getNickName()).province(param.getProvince()).build();
        int i = userService.addWxUser(build);
        Response response = Response.builder().code("200").msg("添加微信用户成功").data(i).build();
        return response;
    }

    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String helloFallback() {
        return String.format("Halooooo %d");
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at ";
    }

}
