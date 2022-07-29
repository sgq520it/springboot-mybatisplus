package com.sgq.xcx.Service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgq.xcx.Entity.LocalUser;
import com.sgq.xcx.Entity.User;
import com.sgq.xcx.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserService extends ServiceImpl<UserMapper,LocalUser> implements IService<LocalUser> {


    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public User checkWxUserExist(String openid) {
        return userMapper.checkWxUserExist(openid);
    }


    public int addWxUser(User user) {
        return userMapper.addWxUser(user);
    }


}
