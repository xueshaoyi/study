package com.study.controller;

import com.study.model.Response;
import com.study.model.UserModel;
import com.study.service.UserService;
import com.study.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueshaoyi
 * @Date 2021/4/28 11:13 下午
 **/
@Slf4j
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/login")
	public Response<String> login(String loginName, String password) {
		String token = "";


		return ResponseUtil.makeSuccess(token);
	}
	
	@PostMapping(value = "/register")
	public Response<String> register(UserModel user) {
		log.info("user register user {}", user.toString());
		if (StringUtils.isEmpty(user.getLoginName()) || StringUtils.isEmpty(user.getPassword())) {
			return ResponseUtil.makeFail("登录名 密码不能为空～～");
		}
		UserModel oldUser = userService.getUserByLoginName(user.getLoginName());
		if (oldUser != null) {
			return ResponseUtil.makeFail("登录账号已存在～～");
		}
		int result = userService.addUser(user);
		if (result > 0) {
			return ResponseUtil.makeSuccess("注册成功～～");
		} else {
			return ResponseUtil.makeFail("注册失败～～");
		}
	}
}
