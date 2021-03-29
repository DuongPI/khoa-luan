package tienganhmienphi.com.backend.Springboot.service;

import tienganhmienphi.com.backend.Springboot.dto.LectureFinish;
import tienganhmienphi.com.backend.Springboot.entity.LearnCourse;

import java.util.List;

public interface LectureFinishService {
    LectureFinish insert(LectureFinish lectureFinish);
    List<LearnCourse> findAll();
    boolean checkId(long id);
}
