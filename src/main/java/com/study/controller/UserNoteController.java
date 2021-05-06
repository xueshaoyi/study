package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.model.Response;
import com.study.model.User;
import com.study.model.UserNote;
import com.study.model.params.UserNoteParams;
import com.study.service.UserNoteService;
import com.study.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xsy
 * @date 2021-05-04 8:28 下午
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/user-note")
public class UserNoteController {

    @Autowired
    UserNoteService userNoteService;

    @PostMapping(value = "/save")
    public Response<String> saveUserNote(@RequestBody UserNote userNote, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        userNote.setUserId(user.getId());
        int i = userNoteService.addNewNote(userNote);
        if (i > 0) {
            return ResponseUtil.makeSuccess("success");
        } else {
            return ResponseUtil.makeFail("新增异常，请检查");
        }
    }

    @PostMapping(value = "/update")
    public Response<String> updateUserNote(@RequestBody UserNote userNote, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        userNote.setUserId(user.getId());
        int i = userNoteService.updateNote(userNote);
        if (i > 0) {
            return ResponseUtil.makeSuccess("success");
        } else {
            return ResponseUtil.makeFail("新增异常，请检查");
        }
    }
    @GetMapping(value = "/get/{id}")
    public Response<UserNote> getUserNote(@PathVariable("id")long id, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        UserNote userNote = userNoteService.getUserNoteById(id);
        return ResponseUtil.makeSuccess(userNote);
    }

    @GetMapping(value = "/list")
    public Response<PageInfo<UserNote>> list(UserNoteParams params, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        params.setUserId(user.getId());
        PageInfo<UserNote> result = userNoteService.getPageListUserNote(params);
        return ResponseUtil.makeSuccess(result);
    }

    @PostMapping(value = "/del")
    public Response<Integer> delNote(long NoteId, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        if (NoteId == 0) {
            return ResponseUtil.makeFail("计划id异常，请重新选择");
        }
        int result = userNoteService.delNote(NoteId, user);
        return ResponseUtil.makeSuccess(result);
    }

}
