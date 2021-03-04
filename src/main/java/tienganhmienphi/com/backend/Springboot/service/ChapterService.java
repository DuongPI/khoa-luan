package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.dto.ChapterDTO;
import tienganhmienphi.com.backend.Springboot.entity.ChapterEntity;

public interface ChapterService {
	List<ChapterEntity> findAll();
	ChapterDTO insert(ChapterDTO dto);
	ChapterDTO update(ChapterDTO dto);
	void delete(long[] ids);
}
