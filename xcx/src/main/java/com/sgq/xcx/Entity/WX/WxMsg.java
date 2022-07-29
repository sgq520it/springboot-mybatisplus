package com.sgq.xcx.Entity.WX;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WxMsg {
    private String ToUserName;
    private String FromUserName;
    private int CreateTime;
    private String MsgType;
    private String Content;
}
