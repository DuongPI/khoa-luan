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

import tienganhmienphi.com.backend.Springboot.dto.ChapterDTO;
import tienganhmienphi.com.backend.Springboot.service.ChapterService;

@RestController
public class ChapterAPI {
	
	@Autowired
	private ChapterService chapterService;
	
	@GetMapping("/api/v1/chapter")
	public ChapterDTO findAll() {
		ChapterDTO dto = new ChapterDTO();
		return dto;
	}
	
	@PostMapping("/api/v1/chapter")
	public ChapterDTO insert(@RequestBody ChapterDTO chapterDTO) {
		return chapterService.insert(chapterDTO);
	}
	
	@PutMapping("/api/v1/chapter")
	public ChapterDTO update(@RequestBody ChapterDTO chapterDTO) {
		return chapterService.update(chapterDTO);
	}
//	ResponseEntity
//	return ResponseEntity.ok().build();
	
	@DeleteMapping("/api/v1/chapter/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) String id) {
		chapterService.delete(Long.parseLong(id));
		return ResponseEntity.noContent().build();
	}
}
