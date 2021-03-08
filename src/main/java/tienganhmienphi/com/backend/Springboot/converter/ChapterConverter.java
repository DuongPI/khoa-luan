package tienganhmienphi.com.backend.Springboot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tienganhmienphi.com.backend.Springboot.dto.ChapterDTO;
import tienganhmienphi.com.backend.Springboot.entity.ChapterEntity;
import tienganhmienphi.com.backend.Springboot.entity.CourseEntity;
import tienganhmienphi.com.backend.Springboot.repository.CourseRepository;

@Component
public class ChapterConverter {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public ChapterDTO toDto(ChapterEntity entity) {
		ChapterDTO dto = new ChapterDTO();
		dto.setId(entity.getId());
		dto.setChapterName(entity.getChapterName());
		dto.setCourse(entity.getCourse().getCourseName());
		return dto;
	}
	
	public ChapterEntity toEntity(ChapterDTO dto) {
		CourseEntity course = courseRepository.findByCourseName(dto.getCourse());
		ChapterEntity entity = new ChapterEntity();
		entity.setCourse(course);
		entity.setChapterName(dto.getChapterName());
		return entity;
	}
	public ChapterEntity toEntity(ChapterDTO dto,ChapterEntity result) {
		CourseEntity course = courseRepository.findByCourseName(dto.getCourse());
		result.setChapterName(dto.getChapterName());
		result.setCourse(course);
		return result;
	}
}
