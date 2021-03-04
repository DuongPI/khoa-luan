package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.entity.LectureEntity;

public interface LectureService {
	List<LectureEntity> findAll();
}
