package com.study.service.impl;

import com.study.dao.UserLessonsDao;
import com.study.model.User;
import com.study.model.UserLessons;
import com.study.service.UserLessonsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xsy
 * @date 2021-05-06 12:15 下午
 */
@Slf4j
@Service
public class UserLessonsServiceImpl implements UserLessonsService {
    @Resource
    UserLessonsDao userLessonsDao;

    @Override
    public int addNewLessons(UserLessons userLessons) {
        return userLessonsDao.insertSelective(userLessons);
    }

    @Override
    public int updateLessons(UserLessons userLessons) {
        UserLessons oldLesson = userLessonsDao.selectByPrimaryKey(userLessons.getId());
        oldLesson.setClassId(userLessons.getClassId());
        oldLesson.setLessonsAddress(userLessons.getLessonsAddress());
        oldLesson.setLessonsTeacher(userLessons.getLessonsTeacher());
        oldLesson.setLessonsName(userLessons.getLessonsName());
        return userLessonsDao.updateByPrimaryKeySelective(oldLesson);
    }

    @Override
    public UserLessons getUserLessonsById(Long id) {
        return userLessonsDao.selectByPrimaryKey(id);
    }

    @Override
    public int delLessons(long lessonId, User user) {
        UserLessons oldLesson = userLessonsDao.selectByPrimaryKey(lessonId);
        oldLesson.setIsDelete(1);
        return userLessonsDao.updateByPrimaryKeySelective(oldLesson);
    }

    @Override
    public List<List<UserLessons>> getAllLessons(Long userId) {
        List<UserLessons> allLessons = userLessonsDao.getAllUserLessonsByUserId(userId);

        return makeLessonsData(allLessons);
    }

    private List<List<UserLessons>> makeLessonsData(List<UserLessons> allLessons) {
        Map<Integer, List<UserLessons>> collect =
                allLessons.stream().collect(Collectors.groupingBy(lesson -> lesson.getClassId()));
        List<List<UserLessons>> result = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            List<UserLessons> userLessons = new ArrayList<>();
            List<UserLessons> userLessonsList = collect.get(i);
            for (int j = 1; j <= 7; j++) {
                UserLessons lessons = new UserLessons();
                if (userLessonsList != null) {
                    for (UserLessons userLessons1 : userLessonsList) {
                        if (userLessons1.getLessonsNumber() == j) {
                            lessons = userLessons1;
                        }
                    }
                }
                userLessons.add(lessons);
            }
            result.add(userLessons);
        }
        return result;
    }
}
