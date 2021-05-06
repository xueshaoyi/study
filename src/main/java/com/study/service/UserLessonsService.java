package com.study.service;

import com.study.model.User;
import com.study.model.UserLessons;

import java.util.List;

/**
 * @author xsy
 * @date 2021-05-06 12:15 下午
 */
public interface UserLessonsService {
    int addNewLessons(UserLessons userLessons);
    int updateLessons(UserLessons userLessons);
    UserLessons getUserLessonsById(Long id);

    int delLessons(long lessonId, User user);

    List<List<UserLessons>> getAllLessons(Long userId);

}
