package tienganhmienphi.com.backend.Springboot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tienganhmienphi.com.backend.Springboot.dto.PostDTO;
import tienganhmienphi.com.backend.Springboot.entity.PostCategoryEntity;
import tienganhmienphi.com.backend.Springboot.entity.PostEntity;
import tienganhmienphi.com.backend.Springboot.repository.PostCategoryRepository;
import tienganhmienphi.com.backend.Springboot.utils.CovertToString;

@Component
public class PostConverter {
	@Autowired
	private PostCategoryRepository postCategoryRepository;
	@Autowired
	private CovertToString cover;
	
	public PostDTO toDTO(PostEntity entity) {
		PostDTO dto = new PostDTO();
		dto.setId(entity.getId());
		dto.setCategory(entity.getPostcategory().getId());
		dto.setContent(entity.getContent());
		dto.setName(entity.getName());
		dto.setImage(entity.getImage());
		dto.setUrlname(cover.covertToStringUrl(entity.getName()));
		dto.setShortDecripsion(entity.getShortDecripsion());
		return dto;
	}
	public PostEntity toEntity(PostDTO dto) {
		PostCategoryEntity category = postCategoryRepository.findById(dto.getCategory()).get();
		PostEntity entity = new PostEntity();
		entity.setContent(dto.getContent());
		entity.setName(dto.getName());
		entity.setImage(dto.getImage());
		entity.setShortDecripsion(dto.getShortDecripsion());
		entity.setPostcategory(category);
		return entity;
	}
	public PostEntity toEntity(PostDTO dto,PostEntity entity) {
		PostCategoryEntity category = postCategoryRepository.findById(dto.getCategory()).get();
		entity.setContent(dto.getContent());
		entity.setName(dto.getName());
		entity.setImage(dto.getImage());
		entity.setShortDecripsion(dto.getShortDecripsion());
		entity.setPostcategory(category);
		return entity;
	}
}
