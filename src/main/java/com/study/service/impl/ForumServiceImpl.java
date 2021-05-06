package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.dao.ForumDao;
import com.study.dao.ForumHfDao;
import com.study.model.Forum;
import com.study.model.ForumHf;
import com.study.model.User;
import com.study.model.UserPlan;
import com.study.model.params.ForumParams;
import com.study.model.params.PageRequest;
import com.study.service.ForumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xsy
 * @date 2021-05-06 5:25 下午
 */
@Service
@Slf4j
public class ForumServiceImpl implements ForumService {
    @Resource
    ForumDao forumDao;
    @Resource
    ForumHfDao forumHfDao;
    @Override
    public int addNewForum(Forum forum) {
        return forumDao.insertSelective(forum);
    }

    @Override
    public int updateForum(Forum forum) {
        Forum oldForum = forumDao.selectByPrimaryKey(forum.getId());
        oldForum.setContent(forum.getContent());
        oldForum.setTitle(forum.getTitle());

        return forumDao.updateByPrimaryKeySelective(oldForum);
    }

    @Override
    public Forum getForumById(Long id) {
        return forumDao.selectByPrimaryKey(id);
    }

    @Override
    public int delForum(long forumId, User user) {
        Forum oldForum = forumDao.selectByPrimaryKey(forumId);
        oldForum.setIsDelete(1);
        return forumDao.updateByPrimaryKeySelective(oldForum);
    }

    @Override
    public PageInfo<Forum> getAllForum(PageRequest params) {
        PageInfo<Forum> forumList = PageHelper.startPage(params.getPageNumber(), params.getPageSize())
                                                .setOrderBy("create_time desc")
                                                .doSelectPageInfo(() -> forumDao.getAllForum());
        return forumList;
    }

    @Override
    public int addForumHf(ForumHf forumHf) {
        return forumHfDao.insertSelective(forumHf);
    }

    @Override
    public PageInfo<ForumHf> getAllForumHf(ForumParams params) {
        PageInfo<ForumHf> forumHfList = PageHelper.startPage(params.getPageNumber(), params.getPageSize())
                                              .setOrderBy("create_time desc")
                                              .doSelectPageInfo(() -> forumHfDao.getAllForumHf(params.getForumId()));
        return forumHfList;
    }
}
