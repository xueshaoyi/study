package com.study.model;

import lombok.Data;

/**
 * @author xueshaoyi
 * @Date 2021/4/28 11:41 下午
 **/
@Data
public class Response<T> {
	private int code;
	private String msg;
	private Object data;
}
