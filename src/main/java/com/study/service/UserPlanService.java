package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.User;
import com.study.model.UserPlan;
import com.study.model.params.UserPlanParams;

import java.util.List;

/**
 * @author xsy
 * @date 2021-04-30 4:18 下午
 */
public interface
UserPlanService {
    PageInfo<UserPlan> getPageListUserPlan(UserPlanParams params);
    int addNewPlan(UserPlan userPlan);
    int updatePlan(UserPlan userPlan);
    UserPlan getUserPlanById(Long id);

    int delPlan(long planId, User user);

    int updateStatus(long planId, int status);
}
