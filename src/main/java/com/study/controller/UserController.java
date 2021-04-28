package com.study.controller;

import com.study.model.Response;
import com.study.model.UserModel;
import com.study.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping(value = "/login")
	public Response<String> login(String loginName, String password) {
		String token = "";


		return ResponseUtil.makeSuccess(token);
	}
	
	@GetMapping(value = "/register")
	public Response<String> register(UserModel user) {

		return ResponseUtil.makeFail("登录账号已存在～～");
	}
}
