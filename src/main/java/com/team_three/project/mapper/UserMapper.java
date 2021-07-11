package com.team_three.project.mapper;

import com.team_three.project.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
public interface UserMapper extends BaseMapper<User> {
    User findByUserName(String userName);
//     void Logout(String userName);
}
