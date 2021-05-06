package com.study.controller;

import com.study.model.Response;
import com.study.model.User;
import com.study.model.UserLessons;
import com.study.model.UserNote;
import com.study.model.params.UserLessonsParams;
import com.study.service.UserLessonsService;
import com.study.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsy
 * @date 2021-05-06 12:41 下午
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/user-course")
public class UserLessonsController {
    @Autowired
    UserLessonsService userLessonsService;

    @GetMapping(value = "/list")
    public Response getLessonsList(User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        List<List<UserLessons>> result = new ArrayList<>();
        result = userLessonsService.getAllLessons(user.getId());

        return ResponseUtil.makeSuccess(result);
    }

    @GetMapping(value = "/get/{id}")
    public Response<UserLessons> getUserNote(@PathVariable("id") long id, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        UserLessons userLessons = userLessonsService.getUserLessonsById(id);
        return ResponseUtil.makeSuccess(userLessons);
    }

    @PostMapping(value = "/save")
    public Response<String> saveUserNote(@RequestBody UserLessons userLessons, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        userLessons.setUserId(user.getId());
        int i = userLessonsService.addNewLessons(userLessons);
        if (i > 0) {
            return ResponseUtil.makeSuccess("success");
        } else {
            return ResponseUtil.makeFail("新增异常，请检查");
        }
    }

    @PostMapping(value = "/update")
    public Response<String> updateUserNote(@RequestBody UserLessonsParams userLessonsParams, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        UserLessons userLessons = modifyLessons(userLessonsParams);
        userLessons.setUserId(user.getId());
        int i = userLessonsService.updateLessons(userLessons);
        if (i > 0) {
            return ResponseUtil.makeSuccess("success");
        } else {
            return ResponseUtil.makeFail("新增异常，请检查");
        }
    }
    @PostMapping(value = "/del")
    public Response<String> delUserNote(String id, User user) {
        log.info("id: {}", id);
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        int i = userLessonsService.delLessons(Long.valueOf(id), user);
        if (i > 0) {
            return ResponseUtil.makeSuccess("success");
        } else {
            return ResponseUtil.makeFail("新增异常，请检查");
        }
    }

    private UserLessons modifyLessons(UserLessonsParams userLessonsParams) {
        UserLessons userLessons = new UserLessons();
        userLessons.setId(userLessonsParams.getId());
        userLessons.setLessonsName(userLessonsParams.getLessonsName());
        userLessons.setLessonsTeacher(userLessonsParams.getLessonsTeacher());
        userLessons.setLessonsAddress(userLessonsParams.getLessonsAddress());
        userLessons.setClassId(userLessonsParams.getClassId());
        if (userLessonsParams.getLessonsNumber().equals("一")) {
            userLessons.setLessonsNumber(1);
        } else if (userLessonsParams.getLessonsNumber().equals("二")) {
            userLessons.setLessonsNumber(2);
        } else if (userLessonsParams.getLessonsNumber().equals("三")) {
            userLessons.setLessonsNumber(3);
        } else if (userLessonsParams.getLessonsNumber().equals("四")) {
            userLessons.setLessonsNumber(4);
        } else if (userLessonsParams.getLessonsNumber().equals("五")) {
            userLessons.setLessonsNumber(5);
        } else if (userLessonsParams.getLessonsNumber().equals("六")) {
            userLessons.setLessonsNumber(6);
        } else if (userLessonsParams.getLessonsNumber().equals("日")) {
            userLessons.setLessonsNumber(7);
        }
        return userLessons;
    }
}
