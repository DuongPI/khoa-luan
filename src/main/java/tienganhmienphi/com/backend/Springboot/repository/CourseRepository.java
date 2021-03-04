package tienganhmienphi.com.backend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tienganhmienphi.com.backend.Springboot.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

}
