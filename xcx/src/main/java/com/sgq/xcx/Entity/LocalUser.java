package com.sgq.xcx.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@TableName(value = "USER")
public class LocalUser {
    private int id;
    private String username;
    private String password;
    private String age;
    private String sex;
    private String email;
    private String address;
    private String phone;
}
