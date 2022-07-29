package com.sgq.xcx.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleWithUser {
    private int id;
    private String title;
    private String content;
    private String imgurl;
    private String openid;
    private int did;
    private String createtime;
    private String nickname;
}
