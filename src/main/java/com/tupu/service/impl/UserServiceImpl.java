package com.tupu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tupu.common.IdGen;
import com.tupu.common.UserToken;
import com.tupu.dao.UserDao;
import com.tupu.domain.User;
import com.tupu.service.UserService;
import com.tupu.utils.SecurityUtils;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(User userParam) {
        String passwordDigest = SecurityUtils.md5(userParam.getPassword());
        User loginUser = userDao.login(userParam.getUserName(), passwordDigest);

        if (loginUser != null) {
            // 登陆成功,重置 token
            String token = UserToken.getToken();
            loginUser.setToken(token);
            userDao.updateUser(loginUser);
        }

        return loginUser;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getUserList();
    }

    @Override
    public User findUserById(long id) {
        return userDao.findById(id);
    }

    @Override
    public void saveUser(User user) {
        String passwordDigest = SecurityUtils.md5(user.getPassword());
        user.setPassword(passwordDigest);

        user.setId(IdGen.getUniqueId());
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public Long deleteUser(long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public boolean checkToken(long id, String token) {
        int num = userDao.findByToken(id, token);

        return num == 1;
    }
}