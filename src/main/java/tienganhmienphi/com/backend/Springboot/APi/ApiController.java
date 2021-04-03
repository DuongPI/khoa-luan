package tienganhmienphi.com.backend.Springboot.APi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tienganhmienphi.com.backend.Springboot.dto.CourseDTO;
import tienganhmienphi.com.backend.Springboot.dto.UploadFileDTO;
import tienganhmienphi.com.backend.Springboot.dto.UserDTO;
import tienganhmienphi.com.backend.Springboot.entity.TestEntity;
import tienganhmienphi.com.backend.Springboot.entity.UserEntity;
import tienganhmienphi.com.backend.Springboot.repository.UserRepository;
import tienganhmienphi.com.backend.Springboot.service.ChapterService;
import tienganhmienphi.com.backend.Springboot.service.TestService;
import tienganhmienphi.com.backend.Springboot.utils.UploadFileUtils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
public class ApiController {
	@Autowired
	private UploadFileUtils uploadFileUtlis;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private TestService testService;
	@PostMapping("/testbase64")
	public ResponseEntity<Void> ApiLecture(@RequestBody UploadFileDTO uploadFileDTO) {
		byte[] decodeBase64 = Base64.getDecoder().decode(uploadFileDTO.getBase64().split(",")[1]);
		uploadFileUtlis.writeOrUpdate(decodeBase64, "/thumbnail/"+uploadFileDTO.getName());
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/test/base64")
	public CourseDTO ApiBase(){
		//uploadFileUtlis.read();
		CourseDTO dto = new CourseDTO();
		dto.setImagetobase64(uploadFileUtlis.read("/thumbnail/hello.png"));
		dto.setImageName("hello.png");
		return dto;
	}
	@PostMapping("/api/v1/user")
	public ResponseEntity<?> ApiUser(@RequestBody List<Long> list) {
//		List<Long> list = new ArrayList<>();
//		list.add(1l);
//		list.add(2l);
//		list.add(null);
//		list.add(null);
//		float _a =  (float)testService.CountNumberOfDuplicate(list,1l);
		float a = (((float)testService.CountNumberOfDuplicate(list,1l))/(int)4 *1000)/100;
		return ResponseEntity.ok(a);
	}
}
