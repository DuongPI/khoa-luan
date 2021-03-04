package tienganhmienphi.com.backend.Springboot.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import tienganhmienphi.com.backend.Springboot.service.CourseCategoryService;
import tienganhmienphi.com.backend.Springboot.service.CourseService;

@Controller(value = "coursesControllerOfAdmin")
public class CoursesController {
	@Autowired
	private CourseCategoryService courseCategoryService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/quan-tri/khoa-hoc")
	public String Show(ModelMap model) {
		model.addAttribute("courses",courseService.findAll());
		model.addAttribute("categories",courseCategoryService.findAll());
		return "admin/course_management";
	}
}
