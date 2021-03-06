package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import tienganhmienphi.com.backend.Springboot.service.CourseCategoryService;
import tienganhmienphi.com.backend.Springboot.service.CourseService;
import tienganhmienphi.com.backend.Springboot.service.PostService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private CourseCategoryService courseCategoryService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public String ShowHome() {
		
		return "redirect:trang-chu";
	}
	
	@GetMapping("/trang-chu")
	public String ShowHome(ModelMap model) {
		model.addAttribute("courseCategories",courseCategoryService.findAll());
		model.addAttribute("courses", courseService.findAll());
		model.addAttribute("posts", postService.findAll());
		return "index";
	}
	
}
