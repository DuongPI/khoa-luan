package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.dto.PostCategoryDTO;
import tienganhmienphi.com.backend.Springboot.entity.PostCategoryEntity;
import tienganhmienphi.com.backend.Springboot.repository.PostCategoryRepository;
import tienganhmienphi.com.backend.Springboot.service.PostCategoryService;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostCategoryServiceImpl implements PostCategoryService {
	@Autowired
	private PostCategoryRepository postCategoryRepository;
	
	
	@Override
	public List<PostCategoryDTO> findAll() {
		List<PostCategoryEntity> categories = postCategoryRepository.findAll();
		List<PostCategoryDTO> dtos = new ArrayList<>();
		for(PostCategoryEntity category : categories) {
			PostCategoryDTO dto = new PostCategoryDTO();
			dto.setId(category.getId());
			dto.setName(category.getName());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public PostCategoryDTO insert(PostCategoryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostCategoryDTO update(PostCategoryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
