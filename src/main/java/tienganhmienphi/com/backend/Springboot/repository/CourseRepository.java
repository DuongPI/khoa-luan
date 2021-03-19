package tienganhmienphi.com.backend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tienganhmienphi.com.backend.Springboot.entity.CourseEntity;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

	CourseEntity findByCourseName(String course);

	@Query(value = "SELECT * FROM course WHERE category_id = ?1",nativeQuery = true)
	List<CourseEntity> findByCategory(int category_id);
}
