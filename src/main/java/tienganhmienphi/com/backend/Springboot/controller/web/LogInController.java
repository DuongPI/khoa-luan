package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tienganhmienphi.com.backend.Springboot.service.CourseService;

@Controller
public class LogInController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/dang-nhap")
	public String ShowLogIn() {
		return "log-in";
	}
	@GetMapping("/tai-khoan/{id}")
	public String ShowAcount(ModelMap model, @PathVariable("id") String id) {
		model.addAttribute("courses", courseService.findByUserId(Long.parseLong(id)));
		return "Acount";
	}

}
