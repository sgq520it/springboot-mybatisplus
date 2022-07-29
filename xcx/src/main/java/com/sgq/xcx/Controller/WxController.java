package com.sgq.xcx.Controller;


import com.sgq.xcx.Entity.BasePoJo.Response;
import com.sgq.xcx.Entity.RequestPoJo.WxReq;
import com.sgq.xcx.Service.WxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/wx")
@Slf4j
public class WxController {

    @Autowired
    private WxService wxService;


    @PostMapping(value = "/wxAuth")
    @ResponseBody
    public Response wxAuth(@RequestBody WxReq param){
        log.info("微信授权开始 code:"+param.getCode());
        Map map = wxService.wxAuth(param.getCode());
        Response response = new Response();
        response.setCode("200");
        response.setMsg("判断微信用户是否授权过接口调用成功");
        response.setData(map);
        return  response;
    }
}
