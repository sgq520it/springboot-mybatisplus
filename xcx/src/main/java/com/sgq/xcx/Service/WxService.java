package com.sgq.xcx.Service;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sgq.xcx.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WxService {

    @Autowired
    private UserService userService;

    public Map wxAuth(String code) {
        Map map = new HashMap<>();
        String authUrl= "https://api.weixin.qq.com/sns/jscode2session?appid=wxea7ce16bbde9d214&secret=828bb84c8477e0f3dda7e8768c18e1c9&js_code="+code+"&grant_type=authorization_code";
        String str = HttpUtil.get(authUrl);
        //{"session_key":"FueJRpDFBP6hWTOt6nmAfw==","openid":"oltQK4wLfuK1ztoz1WhroGnQYTC4"}
        log.info("授权响应信息："+str);
        JSONObject jsonObject = JSONUtil.parseObj(str);
        String openid = jsonObject.getStr("openid");
        map.put("openid",openid);
        if((null == openid )|| ("".equals(openid))){
            throw new RuntimeException(jsonObject.getStr("errmsg"));
        }
        int isExist ;
        User user = userService.checkWxUserExist(openid);
        if(null == user){
            isExist = 0;
        }else {
            isExist = 1;
        }
        map.put("isExist",isExist);
        map.put("userInfo",user);
        if(isExist == 0){
            log.info("该微信用户为新用户，需要跳转至微信授权页面");
            return map;
        }else {
            log.info("该微信用户为已存在用户");
            return map;
        }
    }
}
