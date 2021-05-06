package com.study.dao;

import com.study.model.UserLessons;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UserLessonsDao {

    @Insert({
        "insert into user_lessons (id, user_id, ",
        "class_id, lessons_number, ",
        "lessons_name, lessons_teacher, ",
        "lessons_address, is_delete, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=INTEGER}, ",
        "#{classId,jdbcType=INTEGER}, #{lessonsNumber,jdbcType=INTEGER}, ",
        "#{lessonsName,jdbcType=VARCHAR}, #{lessonsTeacher,jdbcType=VARCHAR}, ",
        "#{lessonsAddress,jdbcType=VARCHAR}, #{isDelete,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserLessons record);

    int insertSelective(UserLessons record);


    @Select({
        "select",
        "id, user_id, class_id, lessons_number, lessons_name, lessons_teacher, lessons_address, ",
        "is_delete, create_time, update_time",
        "from user_lessons",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.study.dao.UserLessonsDao.BaseResultMap")
    UserLessons selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLessons record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_lessons
     *
     * @mbg.generated Thu May 06 12:01:38 CST 2021
     */
    @Update({
        "update user_lessons",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "class_id = #{classId,jdbcType=INTEGER},",
          "lessons_number = #{lessonsNumber,jdbcType=INTEGER},",
          "lessons_name = #{lessonsName,jdbcType=VARCHAR},",
          "lessons_teacher = #{lessonsTeacher,jdbcType=VARCHAR},",
          "lessons_address = #{lessonsAddress,jdbcType=VARCHAR},",
          "is_delete = #{isDelete,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserLessons record);

    List<UserLessons> getAllUserLessonsByUserId(Long userId);
}