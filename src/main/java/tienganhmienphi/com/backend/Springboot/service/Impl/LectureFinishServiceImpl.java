package tienganhmienphi.com.backend.Springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tienganhmienphi.com.backend.Springboot.converter.LearnCourseConverter;
import tienganhmienphi.com.backend.Springboot.dto.ChapterReponse;
import tienganhmienphi.com.backend.Springboot.dto.LectureFinish;
import tienganhmienphi.com.backend.Springboot.entity.CourseEntity;
import tienganhmienphi.com.backend.Springboot.entity.LearnCourse;
import tienganhmienphi.com.backend.Springboot.entity.UserEntity;
import tienganhmienphi.com.backend.Springboot.repository.CourseRepository;
import tienganhmienphi.com.backend.Springboot.repository.LearnCourseReporitory;
import tienganhmienphi.com.backend.Springboot.repository.UserRepository;
import tienganhmienphi.com.backend.Springboot.service.ChapterService;
import tienganhmienphi.com.backend.Springboot.service.LectureFinishService;
import tienganhmienphi.com.backend.Springboot.utils.CovertToString;

import java.util.List;

@Service
public class LectureFinishServiceImpl implements LectureFinishService {
    @Autowired
    private LearnCourseReporitory learnCourseReporitory;

    @Autowired
    private LearnCourseConverter learncourseConverter;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CovertToString coverToString;

    @Override
    public LectureFinish insert(LectureFinish lectureFinish) {
        LearnCourse learnCourse = learncourseConverter.toLearnCourse(lectureFinish);
        return learncourseConverter.toLectureFinish(learnCourseReporitory.save(learnCourse));
    }

    @Override
    public List<LearnCourse> findAll() {
        return learnCourseReporitory.findAll();
    }

    @Override
    public boolean checkId(long id, Long userID) {
        UserEntity entity = userRepository.findById(userID).get();
        List<LearnCourse> learnCourses = learnCourseReporitory.findAll();
        for(LearnCourse learnCourse:learnCourses){
            if(learnCourse.getLectureID() == id && learnCourse.getUser().getId() == entity.getId())
                return true;
        }
        return false;
    }

    @Override
    public int count(long userID,long courseID) {
        UserEntity entity = userRepository.findById(userID).get();
        List<LearnCourse> learnCourses = learnCourseReporitory.findAllByUserAndCourseID(entity,courseID);
        if(learnCourses != null )
            return learnCourses.size();
        else return 0;
    }

    @Override
    public double progree(String courseName,String userid) {
        List<ChapterReponse> list = chapterService._findAllByCourse(courseName,userid);
        double countlecture = 0;
        for(ChapterReponse chapterReponse: list){
            countlecture += chapterReponse.getLectureDTOList().size();
        }
        List<CourseEntity> entities = courseRepository.findAll();
        long courseID = 0;
        for(CourseEntity entity: entities) {
            if (courseName.equals(coverToString.covertToStringUrl(entity.getCourseName()))){
                courseID = entity.getId();
                break;
            }
        }
        double progree = Math.round(count(Long.parseLong(userid),courseID)/ countlecture * 10000)/100;
        return progree;
    }
}
