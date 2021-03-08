package tienganhmienphi.com.backend.Springboot.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import tienganhmienphi.com.backend.Springboot.service.CourseCategoryService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@Autowired
	private CourseCategoryService courseCategoryService;
	
	@GetMapping(value = {"/quan-tri/trang-chu","/quan-tri","/quan-tri/the-loai"})
	public String Show(ModelMap model) {
		model.addAttribute("courseCategories",courseCategoryService.findAll());
		return "admin/category_management";
	}
}
