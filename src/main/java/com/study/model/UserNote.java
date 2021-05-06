package com.study.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserNote {
    private Long id;

    private Long userId;

    private String noteName;

    private int type;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private String describe;

}