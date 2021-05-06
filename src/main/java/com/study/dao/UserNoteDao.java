package com.study.dao;

import com.study.model.UserNote;
import com.study.model.params.UserNoteParams;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserNoteDao {


    @Insert({
        "insert into user_note (user_id, ",
        "note_name, type",
        "is_delete, ",
        "create_time, update_time, ",
        "describe)",
        "values (#{userId,jdbcType=INTEGER}, ",
        "#{noteName,jdbcType=VARCHAR}, #{type,jdbcType=TINYINT}, ",
        "#{isDelete,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{describe,jdbcType=LONGVARCHAR})"
    })
    int insert(UserNote record);

    int insertSelective(UserNote record);

    @Select({
        "select",
        "*",
        "from user_note",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.study.dao.UserNoteDao.BaseResultMap")
    UserNote selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserNote record);

    List<UserNote> getAllUserNoteByUserId(UserNoteParams params);

}