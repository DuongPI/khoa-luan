package tienganhmienphi.com.backend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tienganhmienphi.com.backend.Springboot.entity.CourseCategoryEntity;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategoryEntity, Long> {
	
}
