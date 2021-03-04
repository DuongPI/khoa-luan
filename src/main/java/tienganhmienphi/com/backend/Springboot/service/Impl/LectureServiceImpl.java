package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.entity.LectureEntity;
import tienganhmienphi.com.backend.Springboot.repository.LectureRepository;
import tienganhmienphi.com.backend.Springboot.service.LectureService;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureRepository lectureRepository;
	@Override
	public List<LectureEntity> findAll() {
		// TODO Auto-generated method stub
		return lectureRepository.findAll();
	}

}
