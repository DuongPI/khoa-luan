package tienganhmienphi.com.backend.Springboot.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import tienganhmienphi.com.backend.Springboot.service.ChapterService;
import tienganhmienphi.com.backend.Springboot.service.CourseService;
import tienganhmienphi.com.backend.Springboot.service.LectureService;

@Controller(value = "lectureControllerOfAdmin")
public class LectureController {
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/quan-tri/bai-giang")
	public String Show(ModelMap model) {
		model.addAttribute("chapters",chapterService.findAll());
		model.addAttribute("lectures",lectureService.findAll());
		model.addAttribute("courses",courseService.findAll());
		return "admin/lecture_management";
	}
}
