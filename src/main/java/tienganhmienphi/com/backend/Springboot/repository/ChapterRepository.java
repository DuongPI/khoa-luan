package tienganhmienphi.com.backend.Springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tienganhmienphi.com.backend.Springboot.entity.ChapterEntity;

@Repository
public interface ChapterRepository extends JpaRepository<ChapterEntity,Long> {
	@Query(value = "SELECT * FROM chapter WHERE chapter.course_id = ?1",nativeQuery = true)
	List<ChapterEntity> getALLByCourse(long id);
}
