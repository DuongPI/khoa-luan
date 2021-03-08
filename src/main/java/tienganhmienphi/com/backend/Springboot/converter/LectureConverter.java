package tienganhmienphi.com.backend.Springboot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tienganhmienphi.com.backend.Springboot.dto.LectureDTO;
import tienganhmienphi.com.backend.Springboot.entity.ChapterEntity;
import tienganhmienphi.com.backend.Springboot.entity.LectureEntity;
import tienganhmienphi.com.backend.Springboot.repository.ChapterRepository;

@Component
public class LectureConverter {
	
	@Autowired
	private ChapterRepository chapterRepository;
	
	public LectureDTO toDTO(LectureEntity entity) {
		LectureDTO dto = new LectureDTO();
		dto.setId(entity.getId());
		dto.setChapterID(entity.getChapter().getId());
		dto.setLectureVideo(entity.getLectureVideo());
		dto.setLectureName(entity.getLectureName());
		return dto;
	}
	public LectureEntity toEntity(LectureDTO dto) {
		ChapterEntity chapter = chapterRepository.findById(dto.getChapterID()).get();
		LectureEntity lecture = new LectureEntity();
		lecture.setLectureName(dto.getLectureName());
		lecture.setChapter(chapter);
		lecture.setLectureVideo(dto.getLectureVideo());
		System.out.println("converter");
		return lecture;
	}
	public LectureEntity toEntity(LectureDTO dto,LectureEntity lecture) {
		ChapterEntity chapter = chapterRepository.findById(dto.getChapterID()).get();
		lecture.setLectureName(dto.getLectureName());
		lecture.setChapter(chapter);
		lecture.setLectureVideo(dto.getLectureVideo());
		return lecture;
	}
}
