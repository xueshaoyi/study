package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.model.Response;
import com.study.model.User;
import com.study.model.UserPlan;
import com.study.model.params.UserPlanParams;
import com.study.service.UserPlanService;
import com.study.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xsy
 * @date 2021-04-30 4:38 下午
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/user-plan")
public class UserPlanController {
    @Autowired
    UserPlanService userPlanService;

    @PostMapping(value = "/save")
    public Response<String> saveUserPlan(@RequestBody UserPlan userPlan, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        userPlan.setUserId(user.getId());
        int i = userPlanService.addNewPlan(userPlan);
        if (i > 0) {
            return ResponseUtil.makeSuccess("success");
        } else {
            return ResponseUtil.makeFail("新增异常，请检查");
        }
    }

    @PostMapping(value = "/update")
    public Response<String> updateUserPlan(@RequestBody UserPlan userPlan, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        userPlan.setUserId(user.getId());
        int i = userPlanService.updatePlan(userPlan);
        if (i > 0) {
            return ResponseUtil.makeSuccess("success");
        } else {
            return ResponseUtil.makeFail("新增异常，请检查");
        }
    }
    @GetMapping(value = "/get/{id}")
    public Response<UserPlan> getUserPlan(@PathVariable("id")long id, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        UserPlan userPlan = userPlanService.getUserPlanById(id);
        return ResponseUtil.makeSuccess(userPlan);
    }

    @GetMapping(value = "/list")
    public Response<PageInfo<UserPlan>> list(UserPlanParams params, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        params.setUserId(user.getId());
        PageInfo<UserPlan> result = userPlanService.getPageListUserPlan(params);
        return ResponseUtil.makeSuccess(result);
    }

    @PostMapping(value = "/del")
    public Response<Integer> delPlan(long planId, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        if (planId == 0) {
            return ResponseUtil.makeFail("计划id异常，请重新选择");
        }
        int result = userPlanService.delPlan(planId, user);
        return ResponseUtil.makeSuccess(result);
    }

    @PostMapping(value = "/status")
    public Response<Integer> statusChangePlan(long planId, int status) {
        log.info("planId {}, status {}", planId, status);
        if (planId == 0) {
            return ResponseUtil.makeFail("计划id异常，请重新选择");
        }
        int result = userPlanService.updateStatus(planId, status);
        return ResponseUtil.makeSuccess(result);
    }

}
