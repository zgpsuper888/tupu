package com.tupu.domain;

//import java.io.Serializable;
//import com.tupu.common.*;

/**
 * User 实体类
 *
 * Created by lizhengyan on 01/08/2019.
 */

public class User {
    private String id;
    private String userName;
    private String password;
    private String mobile;
    private String email;
    private String token;
    private String c_time;
//    private datetime login_time;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
//        this.id = IdGen.getTabId();
    }
    public String getuserName() {
        return userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getpassWord() {
        return password;
    }
    public void setpassWord(String password) {
        this.password = password;
    }
    
    public String getmobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getToken() {
    	return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getCtime() {
    	return c_time;
    }
    public void setCtime(String c_time) {
        this.c_time = c_time;
    }
    
 
    
    public User() {
    	
    }
}