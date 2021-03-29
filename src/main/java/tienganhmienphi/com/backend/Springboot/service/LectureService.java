package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.dto.LectureDTO;
import tienganhmienphi.com.backend.Springboot.dto.LectureFinish;

public interface LectureService {
	List<LectureDTO> findAll();
	LectureDTO insert(LectureDTO dto);
	LectureDTO update(LectureDTO dto);
	void delete(long id);
	LectureDTO findById(long id);
}
