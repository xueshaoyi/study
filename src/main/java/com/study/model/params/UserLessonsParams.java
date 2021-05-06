package com.study.model.params;

import lombok.Data;

import java.util.Date;

/**
 * @author xsy
 * @date 2021-05-06 12:51 下午
 */
@Data
public class UserLessonsParams {
    private Long id;

    private Long userId;

    private Integer classId;
    private String lessonsNumber;

    private String lessonsName;

    private String lessonsTeacher;

    private String lessonsAddress;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;
}
