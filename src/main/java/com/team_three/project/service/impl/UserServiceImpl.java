package com.team_three.project.service.impl;

import com.team_three.project.entity.User;
import com.team_three.project.mapper.UserMapper;
import com.team_three.project.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private UserMapper mapper;
    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User findByUserName(String userName) {
        User user = mapper.findByUserName(userName);
        return user;
    }


//
//    @Override
//    public void Logout(String userName) {
//        mapper.Logout(userName);
//    }
}
