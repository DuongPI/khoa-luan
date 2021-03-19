package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;
import tienganhmienphi.com.backend.Springboot.service.ChapterService;
import tienganhmienphi.com.backend.Springboot.service.CourseCategoryService;
import tienganhmienphi.com.backend.Springboot.service.CourseService;

@Controller(value = "coursesControllerOfWeb")
public class CoursesController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseCategoryService courseCategoryService;
	@Autowired
	private ChapterService chapterService;
	
	@GetMapping("/khoa-hoc")
	public String ShowCourse(ModelMap model){
		model.addAttribute("courses", courseService.findAll());
		model.addAttribute("id", -1);
		model.addAttribute("categories", courseCategoryService.findAll());
		return "course";
	}

	@GetMapping("/khoa-hoc/the-loai/{category}")
	public String _ShowCourse(ModelMap model, @PathVariable(required = true) String category){
		model.addAttribute("categories", courseCategoryService.findAll());
		model.addAttribute("id", Integer.parseInt(category));
		model.addAttribute("courses",
				courseService.findByCategory(category));
		return "course";
	}

	@GetMapping("/khoa-hoc/{name}")
	public String ShowLecture(ModelMap model,@PathVariable(required = true) String name){
		model.addAttribute("name", name);
		model.addAttribute("course", courseService.findByName(name));
		model.addAttribute("chapters", chapterService.findAllByCourse(name));
		return "introduce-course";
	}
}
