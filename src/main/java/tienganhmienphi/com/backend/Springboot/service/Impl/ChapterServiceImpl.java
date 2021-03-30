package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.converter.ChapterConverter;
import tienganhmienphi.com.backend.Springboot.converter.LectureConverter;
import tienganhmienphi.com.backend.Springboot.dto.ChapterDTO;
import tienganhmienphi.com.backend.Springboot.dto.ChapterReponse;
import tienganhmienphi.com.backend.Springboot.dto.LectureDTO;
import tienganhmienphi.com.backend.Springboot.entity.*;
import tienganhmienphi.com.backend.Springboot.repository.ChapterRepository;
import tienganhmienphi.com.backend.Springboot.repository.CourseRepository;
import tienganhmienphi.com.backend.Springboot.repository.LearnCourseReporitory;
import tienganhmienphi.com.backend.Springboot.repository.UserRepository;
import tienganhmienphi.com.backend.Springboot.service.ChapterService;
import tienganhmienphi.com.backend.Springboot.utils.CovertToString;

@Service
public class ChapterServiceImpl implements ChapterService{
	@Autowired
	private ChapterRepository chapterRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private CovertToString coverToString;
	@Autowired
	private ChapterConverter chapterConverter;
	@Autowired
	private LectureConverter lectureConverter;
	@Autowired
	private LearnCourseReporitory learnCourseReporitory;
	@Autowired
	private UserRepository userReporitory;

	@Override
	public List<ChapterDTO> findAll() {
		List<ChapterEntity> entities = chapterRepository.findAll();
		List<ChapterDTO> dtos = new ArrayList<>();
		for(ChapterEntity entity : entities) {
			ChapterDTO dto = chapterConverter.toDto(entity);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	@Transactional
	public ChapterDTO insert(ChapterDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("insert");
		ChapterEntity entity = chapterConverter.toEntity(dto);
		return chapterConverter.toDto(chapterRepository.save(entity));
	}

	@Override
	@Transactional
	public ChapterDTO update(ChapterDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("update");
		ChapterEntity oldentity = chapterRepository.findById(dto.getId()).get();
		ChapterEntity newentity = chapterConverter.toEntity(dto, oldentity);
		return chapterConverter.toDto(chapterRepository.save(newentity));
	}

	@Override
	@Transactional
	public void delete(long id) {
		chapterRepository.deleteById(id);
		
	}

	@Override
	public List<ChapterEntity> findAllByCourse(String name) {
		List<CourseEntity> entities = courseRepository.findAll();
		long id = 0;
		for(CourseEntity entity: entities) {
			if (name.equals(coverToString.covertToStringUrl(entity.getCourseName()))) {
				id = entity.getId();
				break;
			}
		}
		List<ChapterEntity> _entities = chapterRepository.getALLByCourse(id);
		return _entities;
	}

	@Override
	public List<ChapterReponse> _findAllByCourse(String name,String userID) {
		List<CourseEntity> entities = courseRepository.findAll();
		long id = 0;
		for(CourseEntity entity: entities) {
			if (name.equals(coverToString.covertToStringUrl(entity.getCourseName()))) {
				id = entity.getId();
				break;
			}
		}
		List<ChapterEntity> _entities = chapterRepository.getALLByCourse(id);
		List<ChapterReponse> chapterReponseList = new ArrayList<>();
		for(ChapterEntity entity: _entities){
			ChapterReponse chapterReponse = new ChapterReponse();
			chapterReponse.setCourse(entity.getCourse().getCourseName());
			chapterReponse.setChapterName(entity.getChapterName());
			chapterReponse.setId(entity.getId());
			List<LectureDTO> lectureDTOS = new ArrayList<>();
			for(LectureEntity entity1: entity.getLectures()){
				LectureDTO dto = lectureConverter.toDTO(entity1);
				UserEntity userEntity = userReporitory.findById(Long.parseLong(userID)).get();
				LearnCourse optional = learnCourseReporitory.findByLectureIDAndUser(entity1.getId(),userEntity);
				if(null!= optional){
					dto.setIstrue(true);
				}else dto.setIstrue(false);
				lectureDTOS.add(dto);
			}
			chapterReponse.setLectureDTOList(lectureDTOS);
			chapterReponseList.add(chapterReponse);
		}
		return chapterReponseList;
	}


}
