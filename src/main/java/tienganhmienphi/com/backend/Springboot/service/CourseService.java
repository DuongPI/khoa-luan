package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.dto.CourseDTO;
import tienganhmienphi.com.backend.Springboot.entity.CourseEntity;

public interface CourseService {
	List<CourseDTO> findAll();
	CourseDTO insert(CourseDTO dto);
	CourseDTO update(CourseDTO dto);
	void delete(long id);
	CourseEntity findByName(String name);
	List<CourseDTO> findByCategory(String category);
}
