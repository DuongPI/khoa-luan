package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.dto.ChapterDTO;
import tienganhmienphi.com.backend.Springboot.dto.ChapterReponse;
import tienganhmienphi.com.backend.Springboot.entity.ChapterEntity;

public interface ChapterService {
	public List<ChapterDTO> findAll();
	public ChapterDTO insert(ChapterDTO dto);
	public ChapterDTO update(ChapterDTO dto);
	void delete(long id);
	public List<ChapterEntity> findAllByCourse(String name);
	public List<ChapterReponse> _findAllByCourse(String name,String userId);
}
