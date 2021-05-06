package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.model.Forum;
import com.study.model.ForumHf;
import com.study.model.Response;
import com.study.model.User;
import com.study.model.params.ForumParams;
import com.study.model.params.PageRequest;
import com.study.model.vo.ForumDetailVo;
import com.study.service.ForumService;
import com.study.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xsy
 * @date 2021-05-06 5:33 下午
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/forum")
public class ForumController {
    @Autowired
    ForumService forumService;

    @PostMapping(value = "/save")
    public Response<String> saveUserForum(@RequestBody Forum forum, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        forum.setUserName(user.getName());
        int i = forumService.addNewForum(forum);
        if (i > 0) {
            return ResponseUtil.makeSuccess("success");
        } else {
            return ResponseUtil.makeFail("新增异常，请检查");
        }
    }

    @GetMapping(value = "/list")
    public Response<PageInfo<Forum>> list(ForumParams params) {
        PageInfo<Forum> result = forumService.getAllForum(params);
        return ResponseUtil.makeSuccess(result);
    }


    @GetMapping(value = "/detail")
    public Response getFroumDetail(ForumParams params) {
        Forum forum = forumService.getForumById(params.getForumId());
        ForumDetailVo result = new ForumDetailVo();
        result.setContent(forum.getContent());
        result.setTitle(forum.getTitle());
        result.setUserName(forum.getUserName());
        PageInfo<ForumHf> allForumHf = forumService.getAllForumHf(params);
        result.setList(allForumHf);

        return ResponseUtil.makeSuccess(result);
    }

    @PostMapping(value = "/save-hf")
    public Response<String> saveForumHf(@RequestBody ForumHf forum, User user) {
        if (user.getId() == 0) {
            return ResponseUtil.makeNoLogin("登录态异常请重新登录");
        }
        forum.setUserName(user.getName());
        int i = forumService.addForumHf(forum);
        if (i > 0) {
            return ResponseUtil.makeSuccess("success");
        } else {
            return ResponseUtil.makeFail("新增异常，请检查");
        }
    }

}
