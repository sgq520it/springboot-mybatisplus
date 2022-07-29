package com.sgq.xcx.Entity.RequestPoJo;


import com.sgq.xcx.Entity.BasePoJo.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleReq extends BaseRequest {
    private String id;
    private String title;
    private String content;
    private String imgurl;
    private String openid;
}
