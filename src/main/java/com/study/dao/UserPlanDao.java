package com.study.dao;

import com.study.model.UserModel;
import com.study.model.UserPlan;
import com.study.model.params.UserPlanParams;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UserPlanDao {


    @Insert({
        "insert into user_plan (id, user_id, ",
        "plan_name, plan_day, ",
        "status, is_delete, ",
        "create_time, update_time, ",
        "describe)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=INTEGER}, ",
        "#{planName,jdbcType=VARCHAR}, #{planDay,jdbcType=DATE}, ",
        "#{status,jdbcType=TINYINT}, #{isDelete,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{describe,jdbcType=LONGVARCHAR})"
    })
    int insert(UserPlan record);

    int insertSelective(UserPlan record);

    @Select({
        "select",
        "*",
        "from user_plan",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.study.dao.UserPlanDao.BaseResultMap")
    UserPlan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPlan record);

    @Update({
        "update user_plan",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "plan_name = #{planName,jdbcType=VARCHAR},",
          "plan_day = #{planDay,jdbcType=DATE},",
          "status = #{status,jdbcType=TINYINT},",
          "is_delete = #{isDelete,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "describe = #{describe,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(UserPlan record);

    List<UserPlan> getAllUserPlanByUserId(UserPlanParams params);

}