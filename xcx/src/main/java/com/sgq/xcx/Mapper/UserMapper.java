package com.sgq.xcx.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sgq.xcx.Entity.LocalUser;
import com.sgq.xcx.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<LocalUser> {
    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from user  t where t.openid =#{openId}")
    User checkWxUserExist(String openid);

    @Insert("INSERT INTO user (openid,avatarUrl,city,country,gender,homelanguage,nickName,province) VALUES(#{openid},#{avatarUrl},#{city},#{country},#{gender},#{homelanguage},#{nickName},#{province})")
    int addWxUser(User user);
}
