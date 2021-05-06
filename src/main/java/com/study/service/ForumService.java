package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.Forum;
import com.study.model.ForumHf;
import com.study.model.User;
import com.study.model.params.ForumParams;
import com.study.model.params.PageRequest;

import java.util.List;

/**
 * @author xsy
 * @date 2021-05-06 5:25 下午
 */
public interface ForumService {
    int addNewForum(Forum forum);
    int updateForum(Forum forum);
    Forum getForumById(Long id);

    int delForum(long forumId, User user);
    PageInfo<Forum> getAllForum(PageRequest params);

    int addForumHf(ForumHf forumHf);
    PageInfo<ForumHf> getAllForumHf(ForumParams params);
}
