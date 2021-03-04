package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.converter.CategoryConverter;
import tienganhmienphi.com.backend.Springboot.dto.CourseCategoryDTO;
import tienganhmienphi.com.backend.Springboot.entity.CourseCategoryEntity;
import tienganhmienphi.com.backend.Springboot.repository.CourseCategoryRepository;
import tienganhmienphi.com.backend.Springboot.service.CourseCategoryService;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

	@Autowired
	private CourseCategoryRepository courseCategoryRepository;
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public List<CourseCategoryEntity> findAll() {
		// TODO Auto-generated method stub
		return courseCategoryRepository.findAll();
		
	}

	@Override
	@Transactional
	public CourseCategoryDTO insert(CourseCategoryDTO dto) {
		// TODO Auto-generated method stub
		CourseCategoryEntity entity = categoryConverter.toEntity(dto);
		return categoryConverter.toDto(courseCategoryRepository.save(entity));
	}

	@Override
	@Transactional
	public CourseCategoryDTO update(CourseCategoryDTO dto) {
		// TODO Auto-generated method stub
		CourseCategoryEntity oldCategory =  courseCategoryRepository.findById(dto.getId()).get();
		CourseCategoryEntity newCategory = categoryConverter.toEntity(dto, oldCategory);
		return categoryConverter.toDto(courseCategoryRepository.save(newCategory));
	}

	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
			courseCategoryRepository.deleteById(id);
	
	}
	
	
}
