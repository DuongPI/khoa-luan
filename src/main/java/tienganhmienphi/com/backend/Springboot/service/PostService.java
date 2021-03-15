package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.dto.PostDTO;

public interface PostService {
	public List<PostDTO> findAll();
	public PostDTO insert(PostDTO dto);
	public PostDTO update(PostDTO dto);
	void delete(long id);
}
