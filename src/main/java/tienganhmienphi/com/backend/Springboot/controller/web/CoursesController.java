package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import tienganhmienphi.com.backend.Springboot.service.CourseService;

@Controller(value = "coursesControllerOfWeb")
public class CoursesController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/khoa-hoc")
	public String ShowCourse(ModelMap model){
		model.addAttribute("courses", courseService.findAll());
		return "course";
	}
}
