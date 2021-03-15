package tienganhmienphi.com.backend.Springboot.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import tienganhmienphi.com.backend.Springboot.service.PostCategoryService;
import tienganhmienphi.com.backend.Springboot.service.PostService;

@Controller(value = "postControllerOfAdmin")
public class PostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private PostCategoryService postCategoryService;
	
	@GetMapping("/quan-tri/bai-viet")
	public String ShowPosts(ModelMap model) {
		model.addAttribute("categories",postCategoryService.findAll());
		model.addAttribute("posts",postService.findAll());
		return "admin/post_management";
	}
}
