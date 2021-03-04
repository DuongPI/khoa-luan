package tienganhmienphi.com.backend.Springboot.converter;

import org.springframework.stereotype.Component;

import tienganhmienphi.com.backend.Springboot.dto.CourseCategoryDTO;
import tienganhmienphi.com.backend.Springboot.entity.CourseCategoryEntity;

@Component
public class CategoryConverter {
	public CourseCategoryDTO toDto(CourseCategoryEntity entity) {
		CourseCategoryDTO result = new CourseCategoryDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		return result;
	}
	
	public CourseCategoryEntity toEntity(CourseCategoryDTO dto) {
		CourseCategoryEntity result = new CourseCategoryEntity();
		result.setDescription(dto.getDescription());
		result.setName(dto.getName());
		return result;
	}
	public CourseCategoryEntity toEntity(CourseCategoryDTO dto,CourseCategoryEntity result) {
		result.setDescription(dto.getDescription());
		result.setName(dto.getName());
		return result;
	}
}
