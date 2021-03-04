package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
	@GetMapping("/bai-viet")
	public String ShowNews() {
		return "news";
	}
}
