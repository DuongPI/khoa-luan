package tienganhmienphi.com.backend.Springboot.APi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tienganhmienphi.com.backend.Springboot.dto.PostDTO;
import tienganhmienphi.com.backend.Springboot.service.PostService;

@RestController
public class PostAPI {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/api/v1/post")
	public PostDTO insert(@RequestBody PostDTO dto) {
		return postService.insert(dto);
	}
	
	@PutMapping("/api/v1/post")
	public PostDTO update(@RequestBody PostDTO dto) {
		return postService.update(dto);
	}
	@DeleteMapping("/api/v1/post/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) String id) {
		return ResponseEntity.noContent().build();
	}
}
