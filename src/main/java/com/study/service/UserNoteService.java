package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.User;
import com.study.model.UserNote;
import com.study.model.params.UserNoteParams;

/**
 * @author xsy
 * @date 2021-05-04 8:29 下午
 */
public interface UserNoteService {
    PageInfo<UserNote> getPageListUserNote(UserNoteParams params);
    int addNewNote(UserNote userNote);
    int updateNote(UserNote userNote);
    UserNote getUserNoteById(Long id);

    int delNote(long noteId, User user);
}
