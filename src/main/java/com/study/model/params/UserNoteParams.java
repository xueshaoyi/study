package com.study.model.params;

import lombok.Data;

/**
 * @author xsy
 * @date 2021-05-04 8:45 下午
 */
@Data
public class UserNoteParams extends PageRequest{
    private Long userId;
    private Integer type;
}
