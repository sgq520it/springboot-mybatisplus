package com.sgq.xcx.Entity;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    private int id;
    private String title;
    private String content;
    private String imgurl;
    private String openid;
    private int did;
    private String createtime;
}
