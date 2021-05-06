package com.study.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Forum {
    private Long id;

    private String userName;

    private String title;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private String content;
}