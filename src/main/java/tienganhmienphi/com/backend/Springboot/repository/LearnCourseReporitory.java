package tienganhmienphi.com.backend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tienganhmienphi.com.backend.Springboot.entity.LearnCourse;
import tienganhmienphi.com.backend.Springboot.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface LearnCourseReporitory extends JpaRepository<LearnCourse,Long> {
    LearnCourse findByLectureID(Long id);

    LearnCourse findByLectureIDAndUser(Long id, UserEntity user);

    List<LearnCourse> findAllByUserAndCourseID(UserEntity entity, long courseID);
}
