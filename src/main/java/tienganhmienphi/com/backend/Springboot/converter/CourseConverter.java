package tienganhmienphi.com.backend.Springboot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tienganhmienphi.com.backend.Springboot.dto.CourseDTO;
import tienganhmienphi.com.backend.Springboot.entity.CourseCategoryEntity;
import tienganhmienphi.com.backend.Springboot.entity.CourseEntity;
import tienganhmienphi.com.backend.Springboot.repository.CourseCategoryRepository;

@Component
public class CourseConverter {
	@Autowired
	private CourseCategoryRepository courseCategoryRepository;
    
	public CourseDTO toDto(CourseEntity entity) {
		CourseDTO result = new CourseDTO();
		result.setId(entity.getId());
		result.setCourseName(entity.getCourseName());
		result.setDescription(entity.getDescription());
		result.setCategory(entity.getCategory().getId());
		result.setShortDescription(entity.getShortDescription());
		result.setImageName(entity.getImage());
		return result;
	}
	
	public CourseEntity toEntity(CourseDTO dto) {
		CourseCategoryEntity category = courseCategoryRepository.findById(dto.getCategory()).get();
		CourseEntity result = new CourseEntity();
		result.setCourseName(dto.getCourseName());
		result.setDescription(dto.getDescription());
		result.setCategory(category);
		result.setShortDescription(dto.getShortDescription());
		result.setImage(dto.getImageName());
		return result;
	}
	
	public CourseEntity toEntity(CourseDTO dto, CourseEntity result) {
		CourseCategoryEntity category = courseCategoryRepository.findById(dto.getCategory()).get();
		result.setCourseName(dto.getCourseName());
		result.setDescription(dto.getDescription());
		result.setCategory(category);
		result.setShortDescription(dto.getShortDescription());
		result.setImage(dto.getImageName());
		return result;
	}
	
}
