package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.dto.PostCategoryDTO;

public interface PostCategoryService {
	public List<PostCategoryDTO> findAll();
	public PostCategoryDTO insert(PostCategoryDTO dto);
	public PostCategoryDTO update(PostCategoryDTO dto);
	void delete(long id);
}
