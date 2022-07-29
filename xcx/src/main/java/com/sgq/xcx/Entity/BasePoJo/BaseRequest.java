package com.sgq.xcx.Entity.BasePoJo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class BaseRequest implements Serializable {
    private String ip;
    private String gps;
    private String device;
    private String pagesize;
    private String currentpage;
    private String token;
}
