package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.dto.ChapterDTO;

public interface ChapterService {
	public List<ChapterDTO> findAll();
	public ChapterDTO insert(ChapterDTO dto);
	public ChapterDTO update(ChapterDTO dto);
	void delete(long id);
}
