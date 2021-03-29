package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.converter.ChapterConverter;
import tienganhmienphi.com.backend.Springboot.dto.ChapterDTO;
import tienganhmienphi.com.backend.Springboot.entity.ChapterEntity;
import tienganhmienphi.com.backend.Springboot.entity.CourseEntity;
import tienganhmienphi.com.backend.Springboot.repository.ChapterRepository;
import tienganhmienphi.com.backend.Springboot.repository.CourseRepository;
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


}
