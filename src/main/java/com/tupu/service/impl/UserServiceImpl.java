package com.tupu.service.impl;

import com.tupu.dao.UserDao;
import com.tupu.domain.User;
import com.tupu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public List<User> getAllUser(){
        return userDao.getUserList();
    }
    @Override
    public User findUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public Long saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public Long updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Long deleteUser(String id) {
        return userDao.deleteUser(id);
    }
    
//    @Override
//    public Long checkUserName(User user) {
//    	System.out.println(userDao.findByUserName(user));
//        return userDao.findByUserName(user);
//    }


}