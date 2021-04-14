package tienganhmienphi.com.backend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tienganhmienphi.com.backend.Springboot.entity.LearnCourse;
import tienganhmienphi.com.backend.Springboot.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface LearnCourseReporitory extends JpaRepository<LearnCourse,Long> {
    LearnCourse findByLectureID(Long id);

    LearnCourse findByLectureIDAndUser(Long id, UserEntity user);

    List<LearnCourse> findAllByUserAndCourseID(UserEntity entity, long courseID);

    @Query(value = "SELECT * FROM user_learn WHERE user_id = ?1 GROUP BY courseid",nativeQuery = true)
    List<LearnCourse> findAllCourseByUser(Long id);
}
