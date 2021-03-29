package tienganhmienphi.com.backend.Springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tienganhmienphi.com.backend.Springboot.converter.LearnCourseConverter;
import tienganhmienphi.com.backend.Springboot.dto.LectureFinish;
import tienganhmienphi.com.backend.Springboot.entity.LearnCourse;
import tienganhmienphi.com.backend.Springboot.repository.LearnCourseReporitory;
import tienganhmienphi.com.backend.Springboot.service.LectureFinishService;

import java.util.List;

@Service
public class LectureFinishServiceImpl implements LectureFinishService {
    @Autowired
    private LearnCourseReporitory learnCourseReporitory;

    @Autowired
    private LearnCourseConverter learncourseConverter;

    @Override
    public LectureFinish insert(LectureFinish lectureFinish) {
        LearnCourse learnCourse = learncourseConverter.toLearnCourse(lectureFinish);
        return learncourseConverter.toLectureFinish(learnCourseReporitory.save(learnCourse));
    }

    @Override
    public List<LearnCourse> findAll() {
        return learnCourseReporitory.findAll();
    }
    public boolean checkId(long id){
        List<LearnCourse> learnCourses = learnCourseReporitory.findAll();
        for(LearnCourse learnCourse:learnCourses){
            if(learnCourse.getLectureID() == id)
                return true;
        }
        return false;
    }
}
