package com.study.dao;

import com.study.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserDao {
    int insertSelective(UserModel record);


    @Select({
        "select",
        "id, login_name, user_name, password, status, create_time, update_time, is_delete",
        "from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    UserModel selectByPrimaryKey(Long id);

    @Select({
            "select",
            "id, login_name, user_name, password, status, create_time, update_time, is_delete",
            "from user",
            "where login_name = #{loginName,jdbcType=VARCHAR}"
    })
    UserModel selectByLoginName(String loginName);

    int updateByExampleSelective(@Param("record") UserModel record);


    int updateByPrimaryKeySelective(UserModel record);

}