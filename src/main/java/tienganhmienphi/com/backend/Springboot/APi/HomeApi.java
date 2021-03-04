package tienganhmienphi.com.backend.Springboot.APi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tienganhmienphi.com.backend.Springboot.dto.CourseCategoryDTO;
import tienganhmienphi.com.backend.Springboot.service.CourseCategoryService;

@RestController
public class HomeApi {
	@Autowired
	private CourseCategoryService courseCategoryService;
	
	@GetMapping("/api/v1/category")
	public CourseCategoryDTO findAll() {
		CourseCategoryDTO dto = new CourseCategoryDTO();
		return dto;
	}
	
	@PostMapping("/api/v1/category")
	public CourseCategoryDTO insert(@RequestBody CourseCategoryDTO courseCategoryDTO) {
		return courseCategoryService.insert(courseCategoryDTO);
	}
	
	@PutMapping("/api/v1/category")
	public CourseCategoryDTO update(@RequestBody CourseCategoryDTO courseCategoryDTO) {
		return courseCategoryService.update(courseCategoryDTO);
	}
//	ResponseEntity
//	return ResponseEntity.ok().build();
	
	@DeleteMapping("/api/v1/category/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) String id) {
		courseCategoryService.delete(Long.parseLong(id));
		return ResponseEntity.noContent().build();
	}
}
