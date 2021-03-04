package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.dto.ChapterDTO;
import tienganhmienphi.com.backend.Springboot.entity.ChapterEntity;
import tienganhmienphi.com.backend.Springboot.repository.ChapterRepository;
import tienganhmienphi.com.backend.Springboot.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService{
	@Autowired
	private ChapterRepository chapterRepository;
	
	@Override
	public List<ChapterEntity> findAll() {
		// TODO Auto-generated method stub
		return chapterRepository.findAll();
	}

	@Override
	public ChapterDTO insert(ChapterDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChapterDTO update(ChapterDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}

}
