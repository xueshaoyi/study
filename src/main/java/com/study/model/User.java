package com.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xsy
 * @date 2021-04-29 9:59 下午
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private long id;
    private String name;
    private String loginName;
}
