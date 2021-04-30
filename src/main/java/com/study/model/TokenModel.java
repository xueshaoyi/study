package com.study.model;

import lombok.Data;

import java.util.Date;

/**
 * 用户权限与接口映射.
 *
 * @Author: WangYing on 2018/6/19
 */
@Data
public class TokenModel {
    private long id;
    private long userId;
    private String token;
    private Date expiresTime;
    private Date createTime;
    private Date updateTime;
    private int isDelete;
}
