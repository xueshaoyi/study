package com.study.utils;

import com.study.model.Response;

/**
 * @author xueshaoyi
 * @Date 2021/4/28 11:43 下午
 **/
public class ResponseUtil {

	public static <T> Response<T> makeResponse(int code, String msg, T obj) {
		Response<T> result = new Response<>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(obj);
		return result;
	}

	public static <T> Response<T> makeFail(String message) {
		return makeResponse(1, message, null);
	}

	public static <T> Response<T> makeNoLogin(String message) {
		return makeResponse(2, message, null);
	}

	public static <T> Response<T> makeSuccess(T obj) {
		return makeResponse(0, "", obj);
	}
}
