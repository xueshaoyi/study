package com.study.service;

import com.study.model.TokenModel;

/**
 * @author xsy
 * @date 2021-04-29 9:26 下午
 */
public interface TokenService {
    int addToken(long userId, String token);
    long getUserIdByToken(String token);
    int logoutByToken(String token);
}
