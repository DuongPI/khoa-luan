package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "postControllerOfWeb")
public class PostController {
	@GetMapping("/bai-viet")
	public String ShowPosts() {
		return "news";
	}
	
}
