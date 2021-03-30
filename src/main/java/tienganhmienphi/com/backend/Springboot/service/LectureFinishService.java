package tienganhmienphi.com.backend.Springboot.service;

import tienganhmienphi.com.backend.Springboot.dto.LectureFinish;
import tienganhmienphi.com.backend.Springboot.entity.LearnCourse;

import java.util.List;

public interface LectureFinishService {
    LectureFinish insert(LectureFinish lectureFinish);
    List<LearnCourse> findAll();
    boolean checkId(long id,Long userID);
    int count(long userID,long courseID);
    double progree(String courseName,String userid);
}
