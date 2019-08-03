package com.tupu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tupu.domain.User;
import com.tupu.result.JsonResult;
import com.tupu.service.UserService;

@RestController
@ResponseBody
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public JsonResult findOneUser(@PathVariable("id") String id) {
        // TODO 参数校验
        User user = userService.findUserById(id);

        return JsonResult.success(user);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public JsonResult createUser(@RequestBody User user) {
        userService.saveUser(user);

        return JsonResult.success(null);
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public JsonResult delUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return JsonResult.success(null);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public JsonResult findAllUser() {
        List<User> users = userService.getAllUser();

        return JsonResult.success(users);
    }

    @RequestMapping(value = "/api/user/", method = RequestMethod.PUT)
    public JsonResult modifyUser(@RequestBody User user) {
        userService.updateUser(user);

        return JsonResult.success(null);
    }
}
