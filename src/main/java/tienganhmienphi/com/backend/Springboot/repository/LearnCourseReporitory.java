package tienganhmienphi.com.backend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tienganhmienphi.com.backend.Springboot.entity.LearnCourse;

public interface LearnCourseReporitory extends JpaRepository<LearnCourse,Long> {
}
