package com.study.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserLessons {
    private Long id;

    private Long userId;

    private Integer classId;
    private Integer lessonsNumber;

    private String lessonsName;

    private String lessonsTeacher;

    private String lessonsAddress;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

}