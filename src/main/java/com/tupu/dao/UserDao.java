package com.tupu.dao;

import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.tupu.domain.User;
import java.util.List;

/**
 * 用户 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Repository
public interface UserDao {

    /**
     * 根据名称，查询城市信息
     *
     * @param UserName 用户名
     */
    
    List<User> getUserList();
    
    User findById(@Param("id") String id);
    
    Long saveUser(User user);

    Long updateUser(User user);

    Long deleteUser(String id);
    
//    Long findByUserName(String userName);
    
}