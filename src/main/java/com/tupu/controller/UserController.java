package com.tupu.controller;

import com.tupu.common.GlobalVariable;
import com.tupu.utils.JsonUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tupu.common.ErrorCodeEnum;
import com.tupu.domain.User;
import com.tupu.result.JsonResult;
import com.tupu.service.UserService;

@RestController
@ResponseBody
public class UserController {

    final static Logger log= LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;


    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody User user) {
        User loginUser = userService.login(user);
        if (loginUser == null) {
            return JsonResult.fail(ErrorCodeEnum.LOGIN_ERROR);
        }

        return JsonResult.success(JsonUtils.object2JsonIgnoreNull(loginUser));
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public JsonResult findOneUser(@PathVariable("id") long id) {

        User user = userService.findUserById(id);
        return JsonResult.success(user);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public JsonResult createUser(@RequestBody User user) {
        // 参数校验
        JsonResult validateResult = addValidate(user);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }

        userService.saveUser(user);

        return JsonResult.success(null);
    }

    private JsonResult addValidate(User user) {
        Map<String, String> errorMap = new HashMap<>();

        long id = user.getId();
        if (id < 1) {
            errorMap.put("id", "id 必填");
        }

        String userName = user.getUserName();
        if (StringUtils.isEmpty(userName)) {
            errorMap.put("userName", "用户名必填");
        }

        String passWord = user.getPassword();
        if (StringUtils.isEmpty(passWord)) {
            errorMap.put("passWord", "密码必填");
        }

        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }

        return JsonResult.fail(errorMap);
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public JsonResult delUser(@PathVariable("id") long id) {
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
