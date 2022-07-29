package com.sgq.xcx.Entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    private int id;
    private String username;
    private String password;
    private String age;
    private String sex;
    private String email;
    private String address;
    private String phone;
    private String openid;
    private String avatarUrl;
    private String city;
    private String country;
    private String gender;
    private String homelanguage;
    private String nickName;
    private String province;

}
