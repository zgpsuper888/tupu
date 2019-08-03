package com.tupu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tupu.domain.User;

/**
 * 
 * service
 * 
 * 
 */
@Service
public interface UserService {

    /**
     * 登陆
     *
     * @return 用户
     */
    User login(User user);


    /**
     * 获取用户信息列表
     *
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户 ID,查询用户信息
     *
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    void saveUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    void updateUser(User user);

    /**
     * 根据用户 ID,删除用户
     *
     * @param id
     * @return
     */
    Long deleteUser(String id);

    /**
     * 验证 token
     * 
     * @param id 用户 ID
     * @param token 用户 token
     * @return true 通过;false 失败
     */
    boolean checkToken(long id, String token);
}