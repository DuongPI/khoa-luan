package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.dto.CourseDTO;

public interface CourseService {
	List<CourseDTO> findAll();
	CourseDTO insert(CourseDTO dto);
	CourseDTO update(CourseDTO dto);
	void delete(long id);
}
