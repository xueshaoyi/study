package com.study.model.vo;

import com.github.pagehelper.PageInfo;
import com.study.model.ForumHf;
import lombok.Data;

/**
 * @author xsy
 * @date 2021-05-06 6:51 下午
 */
@Data
public class ForumDetailVo {
    private String content;
    private String title;
    private String userName;
    private PageInfo<ForumHf> list;
}
