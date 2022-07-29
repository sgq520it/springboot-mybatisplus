package com.sgq.xcx.Entity.RequestPoJo;


import com.sgq.xcx.Entity.BasePoJo.BaseRequest;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserReq extends BaseRequest {
    private String userName;
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
