package com.study.dao;

import com.study.model.TokenModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: sea-auth-client
 * @description:
 * @author: jijs
 * @create: 2020-09-21 11:03
 */
@Mapper
public interface TokenDao {
    Integer add(TokenModel tokenModel);
    Integer getUserIdByToken(String token);
    Integer logoutByTokens(@Param("tokens")List<String> tokens);
    TokenModel getThirdLastTokenByUserId(int userId);

}
