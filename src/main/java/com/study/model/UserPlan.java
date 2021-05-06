package com.study.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UserPlan {
    private Long id;

    private Long userId;

    private String planName;

    private Date planDay;

    private int status;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private String describe;

}