package com.study.dao;

import com.study.model.Forum;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ForumDao {
    @Insert({
        "insert into forum (id, user_name, ",
        "title, is_delete, ",
        "create_time, update_time, ",
        "content)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{isDelete,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Forum record);

    int insertSelective(Forum record);

    @Select({
        "select",
        "id, user_name, title, is_delete, create_time, update_time, content",
        "from forum",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.study.dao.ForumDao.ResultMapWithBLOBs")
    Forum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Forum record);

    List<Forum> getAllForum();

}