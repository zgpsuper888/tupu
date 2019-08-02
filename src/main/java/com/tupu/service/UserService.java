package com.tupu.service;

import com.tupu.domain.User;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 
 * service
 * 
 * 
*/
@Service
public interface UserService {

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
	 Long saveUser(User user);
	 /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
	 Long updateUser(User user);

    /**
     * 根据用户 ID,删除用户
     *
     * @param id
     * @return
     */
	 Long deleteUser(String id);
	 
//	 public Long checkUserName(User userName);
	 
}