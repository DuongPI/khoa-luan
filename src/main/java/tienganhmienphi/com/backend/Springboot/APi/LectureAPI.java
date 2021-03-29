package tienganhmienphi.com.backend.Springboot.APi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tienganhmienphi.com.backend.Springboot.dto.LectureDTO;
import tienganhmienphi.com.backend.Springboot.dto.LectureFinish;
import tienganhmienphi.com.backend.Springboot.service.LectureFinishService;
import tienganhmienphi.com.backend.Springboot.service.LectureService;

@RestController
public class LectureAPI {
	@Autowired
	private LectureService lectureService;

	@Autowired
	private LectureFinishService lectureFinishService;

	@PostMapping("/api/v1/lecture")
	public LectureDTO insert(@RequestBody LectureDTO lectureDTO) {
		return lectureService.insert(lectureDTO);
	}
	
	@PutMapping("/api/v1/lecture")
	public LectureDTO update(@RequestBody LectureDTO lectureDTO) {
		return lectureService.update(lectureDTO);
	}
	
	@DeleteMapping("/api/v1/lecture/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) String id) {
		lectureService.delete(Long.parseLong(id));
		return ResponseEntity.noContent().build();
	}
	@PostMapping("/api/v1/lecture/finish")
	public LectureFinish finishLecture(@RequestBody LectureFinish lectureFinish){

		return lectureFinishService.insert(lectureFinish);
	}
}
