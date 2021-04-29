package com.study.model;

import lombok.Data;

import java.util.Date;

/**
 * @author xueshaoyi
 * @Date 2021/4/28 11:38 下午
 **/
@Data
public class UserModel {
	private Long id;
	private String loginName;
	private String userName;
	private String password;
	private int status;
	private int isDelete;
	private Date createTime;
	private Date updateTime;
}
