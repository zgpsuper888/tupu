package com.tupu.controller;

import com.tupu.domain.User;
import com.tupu.service.UserService;

//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tupu.common.*;
/**
 * 
 *
 * Created by bysocket on 26/09/2017.
 */
@RestController
public class UserController {
//	private Logger log4j = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	
	/*
	 * Param String id
	 * @return userinfo
	 */
	@RequestMapping(value = "/api/user/{id}",method = RequestMethod.GET)
	public User findOneUser(@PathVariable("id") String id){
//		User a = new IdGen();
		System.out.println("-----------------");
		System.out.println(UserToken.getToken());
		return userService.findUserById(id);
	}
	@RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
		System.out.println(UserToken.getToken());
		User udata = new User();
		udata.setId(IdGen.getTabId());
		udata.setToken(UserToken.getToken());
		userService.saveUser(udata);
    }
//	@RequestParam
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public String delUser(@PathVariable("id") String id) {
		
		
		userService.deleteUser(id);
		return "Ok";
    }
	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public List<User> findAllUser() {
		System.out.println("11111");
		System.out.println(UserToken.getToken());
        return userService.getAllUser();
    }
	@RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public void modifyUser(@RequestBody User user) {
		System.out.println("---------");
////		System.out.println(user);
//		User a = new User();
		System.out.println(user);
        userService.updateUser(user);
    }
}
