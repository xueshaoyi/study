package com.study.dao;

import com.study.model.ForumHf;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ForumHfDao {
    int insertSelective(ForumHf record);

    List<ForumHf> getAllForumHf(long forumId);
}