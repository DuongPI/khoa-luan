package tienganhmienphi.com.backend.Springboot.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import tienganhmienphi.com.backend.Springboot.service.ChapterService;
import tienganhmienphi.com.backend.Springboot.service.CourseService;

@Controller(value = "chapterControllerOfAdmin")
public class ChapterController {
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/quan-tri/cac-chuong")
	public String Show(ModelMap model) {
		model.addAttribute("chapters",chapterService.findAll());
		model.addAttribute("courses",courseService.findAll());
		return "admin/chapter_management";
	}
}
