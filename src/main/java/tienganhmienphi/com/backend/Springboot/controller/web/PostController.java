package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tienganhmienphi.com.backend.Springboot.service.PostService;

@Controller(value = "postControllerOfWeb")
public class PostController {
	@Autowired
	private PostService postService;


	@GetMapping("/bai-viet")
	public String Show(ModelMap model) {
		model.addAttribute("posts",postService.findAll());
		return "post";
	}
	
	@GetMapping("/bai-viet/{name}")
	public String ShowPosts(@PathVariable(required = true) String name,ModelMap model) {
		model.addAttribute("post",postService.findByName(name));
		return "post-detail";
	}
	
}
