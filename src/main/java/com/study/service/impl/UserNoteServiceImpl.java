package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.dao.UserNoteDao;
import com.study.model.User;
import com.study.model.UserNote;
import com.study.model.params.UserNoteParams;
import com.study.service.UserNoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xsy
 * @date 2021-05-04 8:29 下午
 */
@Slf4j
@Service
public class UserNoteServiceImpl implements UserNoteService {

    @Autowired
    UserNoteDao userNoteDao;

    @Override
    public PageInfo<UserNote> getPageListUserNote(UserNoteParams params) {
        PageInfo<UserNote> planList = PageHelper.startPage(params.getPageNumber(), params.getPageSize())
                                                .setOrderBy("create_time desc")
                                                .doSelectPageInfo(() -> userNoteDao.getAllUserNoteByUserId(params));
        return planList;
    }

    @Override
    public int addNewNote(UserNote userNote) {
        return userNoteDao.insertSelective(userNote);
    }

    @Override
    public int updateNote(UserNote userNote) {
        UserNote oldNote = userNoteDao.selectByPrimaryKey(userNote.getId());
        oldNote.setDescribe(userNote.getDescribe());
        oldNote.setType(userNote.getType());
        return userNoteDao.updateByPrimaryKeySelective(oldNote);
    }

    @Override
    public UserNote getUserNoteById(Long id) {
        return userNoteDao.selectByPrimaryKey(id);
    }

    @Override
    public int delNote(long noteId, User user) {
        UserNote oldNote = userNoteDao.selectByPrimaryKey(noteId);
        oldNote.setIsDelete(1);
        return userNoteDao.updateByPrimaryKeySelective(oldNote);
    }
}
