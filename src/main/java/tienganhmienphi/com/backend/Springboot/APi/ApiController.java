package tienganhmienphi.com.backend.Springboot.APi;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tienganhmienphi.com.backend.Springboot.dto.CourseDTO;
import tienganhmienphi.com.backend.Springboot.dto.UploadFileDTO;
import tienganhmienphi.com.backend.Springboot.utils.UploadFileUtils;

@RestController
public class ApiController {
	@Autowired
	private UploadFileUtils uploadFileUtlis;
	
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
}
