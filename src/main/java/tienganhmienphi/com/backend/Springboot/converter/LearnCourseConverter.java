package tienganhmienphi.com.backend.Springboot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tienganhmienphi.com.backend.Springboot.dto.LectureFinish;
import tienganhmienphi.com.backend.Springboot.entity.LearnCourse;
import tienganhmienphi.com.backend.Springboot.entity.UserEntity;
import tienganhmienphi.com.backend.Springboot.repository.UserRepository;

@Component
public class LearnCourseConverter {
    @Autowired
    private UserRepository userRepository;

    public LectureFinish toLectureFinish(LearnCourse learnCourse){
        LectureFinish lectureFinish = new LectureFinish();
        lectureFinish.setLectureID(learnCourse.getLectureID());
        lectureFinish.setCourseID(learnCourse.getCourseID());
        lectureFinish.setUsername(learnCourse.getUser().getUserName());
        return lectureFinish;
    }
    public LearnCourse toLearnCourse(LectureFinish lectureFinish){
        UserEntity userEntity = userRepository.findOneByUserName(lectureFinish.getUsername());
        LearnCourse learnCourse = new LearnCourse();
        learnCourse.setCourseID(lectureFinish.getCourseID());
        learnCourse.setUser(userEntity);
        learnCourse.setLectureID(lectureFinish.getLectureID());
        return learnCourse;

    }
}
