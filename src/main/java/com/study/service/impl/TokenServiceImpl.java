package com.study.service.impl;

import com.study.dao.TokenDao;
import com.study.model.TokenModel;
import com.study.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xsy
 * @date 2021-04-29 9:39 下午
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {
    @Resource
    TokenDao tokenDao;
    @Override
    public int addToken(long userId, String token) {
        TokenModel model = new TokenModel();
        model.setUserId(userId);
        model.setToken(token);
        model.setExpiresTime(DateUtils.addMinutes(new Date(), 60 * 24));
        Integer count = tokenDao.add(model);
        return count;
    }

    @Override
    public long getUserIdByToken(String token) {
        return tokenDao.getUserIdByToken(token);
    }

    @Override
    public int logoutByToken(String token) {
        List<String> tokens = new ArrayList<>();
        tokens.add(token);
        Integer count = tokenDao.logoutByTokens(tokens);
        return count;
    }
}
