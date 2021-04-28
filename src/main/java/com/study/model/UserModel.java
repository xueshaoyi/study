package com.study.model;

import lombok.Data;

/**
 * @author xueshaoyi
 * @Date 2021/4/28 11:38 下午
 **/
@Data
public class UserModel {
	private Long id;
	private String loginName;
	private String name;
	private String password;
}
