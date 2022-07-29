package com.sgq.xcx.Entity.RequestPoJo;


import com.sgq.xcx.Entity.BasePoJo.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxReq extends BaseRequest {
    private String code;
}
