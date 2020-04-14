package com.github.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.datasource.DataSourceNames;
import com.github.datasource.annotation.DataSource;
import com.github.mybatis.entity.User;
import com.github.mybatis.mapper.UserMapper;
import com.github.mybatis.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * User Service
 * </p>
 *
 * @package: com.github.mybatis.service.impl
 * @description: User Service
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 类上 {@code @DataSource(name = DataSourceNames.YUM)} 代表使用YUM库，默认采用YUM库
     *
     * @param user 用户
     */
    @Override
    @DataSource(name = DataSourceNames.YUM)
    public void addUser(User user) {
        baseMapper.insert(user);
    }

    @Override
    /*@DataSource(name = DataSourceNames.LOCAL)*/
    public User getUserById(String id){
        return baseMapper.selectById(id);
    }
}
