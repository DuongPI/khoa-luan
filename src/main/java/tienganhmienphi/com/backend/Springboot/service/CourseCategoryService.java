package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.dto.CourseCategoryDTO;
import tienganhmienphi.com.backend.Springboot.entity.CourseCategoryEntity;

public interface CourseCategoryService {
	List<CourseCategoryEntity> findAll();
	CourseCategoryDTO insert(CourseCategoryDTO dto);
	CourseCategoryDTO update(CourseCategoryDTO dto);
	void delete(long id);
}
