package com.github.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.mybatis.entity.User;

/**
 * <p>
 * User Service
 * </p>
 *
 * @package: com.github.mybatis.service
 * @description: User Service
 */
public interface UserService extends IService<User> {
    /**
     * 添加 User
     * @param user 用户
     */
    void addUser(User user);

    public User getUserById(String id);
}
