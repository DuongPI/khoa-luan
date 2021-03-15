package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.converter.PostConverter;
import tienganhmienphi.com.backend.Springboot.dto.PostDTO;
import tienganhmienphi.com.backend.Springboot.entity.PostEntity;
import tienganhmienphi.com.backend.Springboot.repository.PostRepository;
import tienganhmienphi.com.backend.Springboot.service.PostService;
@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepository;
//	@Autowired
//	private PostCategoryRepository postCategoryRepository;
	@Autowired
	private PostConverter postConverter;
	@Override
	public List<PostDTO> findAll() {
		List<PostEntity> entities = postRepository.findAll();
		List<PostDTO> dtos = new ArrayList<>();
		for(PostEntity entity: entities) {
			PostDTO dto = postConverter.toDTO(entity);
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public PostDTO insert(PostDTO dto) {
		PostEntity entity = postConverter.toEntity(dto);
		return postConverter.toDTO(postRepository.save(entity));
	}

	@Override
	public PostDTO update(PostDTO dto) {
		PostEntity oldentity = postRepository.findById(dto.getId()).get();
		PostEntity newentity = postConverter.toEntity(dto,oldentity);
		return postConverter.toDTO(postRepository.save(newentity));
	}

	@Override
	public void delete(long id) {
		postRepository.deleteById(id);
		
	}

}
