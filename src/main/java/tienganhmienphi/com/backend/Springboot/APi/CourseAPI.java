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

import tienganhmienphi.com.backend.Springboot.dto.CourseDTO;
import tienganhmienphi.com.backend.Springboot.service.CourseService;

@RestController
public class CourseAPI {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/api/v1/course")
	public CourseDTO findAll() {
		CourseDTO dto = new CourseDTO();
		return dto;
	}
	
	@PostMapping("/api/v1/course")
	public CourseDTO insert(@RequestBody CourseDTO courseDTO) {
		return courseService.insert(courseDTO);
	}
	
	@PutMapping("/api/v1/course")
	public CourseDTO update(@RequestBody CourseDTO courseDTO) {
		return courseService.update(courseDTO);
	}
	
	@DeleteMapping("/api/v1/course/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) String id) {
		courseService.delete(Long.parseLong(id));
		return ResponseEntity.noContent().build();
	}
}
