package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.dao.UserPlanDao;
import com.study.model.User;
import com.study.model.UserPlan;
import com.study.model.params.UserPlanParams;
import com.study.service.UserPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xsy
 * @date 2021-04-30 4:18 下午
 */
@Slf4j
@Service
public class UserPlanServiceImpl implements UserPlanService {

    @Autowired
    UserPlanDao userPlanDao;
    @Override
    public PageInfo<UserPlan> getPageListUserPlan(UserPlanParams params) {
        List<UserPlan> plans = userPlanDao.getAllUserPlanByUserId(params);
        PageInfo<UserPlan> planList = PageHelper.startPage(params.getPageNumber(), params.getPageSize())
                                                    .setOrderBy("plan_day desc")
                                                    .doSelectPageInfo(() -> userPlanDao.getAllUserPlanByUserId(params));
        return planList;
    }

    @Override
    public int addNewPlan(UserPlan userPlan) {
        return userPlanDao.insertSelective(userPlan);
    }

    @Override
    public int updatePlan(UserPlan userPlan) {
        UserPlan oldPlan = userPlanDao.selectByPrimaryKey(userPlan.getId());
        oldPlan.setDescribe(userPlan.getDescribe());
        oldPlan.setPlanName(userPlan.getPlanName());
        return userPlanDao.updateByPrimaryKeySelective(oldPlan);
    }

    @Override
    public UserPlan getUserPlanById(Long id) {
        return userPlanDao.selectByPrimaryKey(id);
    }

    @Override
    public int delPlan(long planId, User user) {
        UserPlan userPlan = userPlanDao.selectByPrimaryKey(planId);
        userPlan.setIsDelete(1);

        return userPlanDao.updateByPrimaryKeySelective(userPlan);
    }

    @Override
    public int updateStatus(long planId, int status) {
        UserPlan userPlan = userPlanDao.selectByPrimaryKey(planId);
        userPlan.setStatus(status);
        return userPlanDao.updateByPrimaryKeySelective(userPlan);
    }
}
