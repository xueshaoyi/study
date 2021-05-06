package com.study.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ForumHf {
    private Long id;

    private Long forumId;

    private String userName;

    private String content;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

}