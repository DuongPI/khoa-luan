package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutusController {
	@GetMapping("/ve-chung-toi")
	public String ShowAboutUs() {
		return "about-us";
	}
	@GetMapping("/lien-he")
	public String ShowLienHe() {
		return "Lienhe";
	}
}
