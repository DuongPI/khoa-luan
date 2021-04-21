package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.converter.LectureConverter;
import tienganhmienphi.com.backend.Springboot.dto.LectureDTO;
import tienganhmienphi.com.backend.Springboot.dto.LectureFinish;
import tienganhmienphi.com.backend.Springboot.entity.LectureEntity;
import tienganhmienphi.com.backend.Springboot.entity.UserEntity;
import tienganhmienphi.com.backend.Springboot.repository.LearnCourseReporitory;
import tienganhmienphi.com.backend.Springboot.repository.LectureRepository;
import tienganhmienphi.com.backend.Springboot.service.LectureService;

@Service
@Transactional
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureRepository lectureRepository;
	
	@Autowired
	private LectureConverter lectureConverter;
	@Autowired
	private LearnCourseReporitory learnCourseReporitory;
	
	@Override
	public List<LectureDTO> findAll() {
		List<LectureEntity> entities = lectureRepository.findAll();
		List<LectureDTO> dtos = new ArrayList<>();
		for( LectureEntity entity : entities) {
			LectureDTO dto = lectureConverter.toDTO(entity);
			dtos.add(dto);
		}
		return dtos;
	}
	@Override
	@Transactional
	public LectureDTO insert(LectureDTO dto) {
		// TODO Auto-generated method stub
		LectureEntity entity = lectureConverter.toEntity(dto);
		System.out.println("service");
		return lectureConverter.toDTO(lectureRepository.save(entity));
	}
	@Override
	@Transactional
	public LectureDTO update(LectureDTO dto) {
		LectureEntity odlEntity = lectureRepository.findById(dto.getId()).get();
		LectureEntity newEntity = lectureConverter.toEntity(dto, odlEntity);
		return lectureConverter.toDTO(lectureRepository.save(newEntity));
	}
	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
		lectureRepository.deleteById(id);
		
	}

	@Override
	public LectureDTO findById(long id) {
		LectureEntity entity = lectureRepository.findById(id).get();
		return lectureConverter.toDTO(entity);
	}


}
