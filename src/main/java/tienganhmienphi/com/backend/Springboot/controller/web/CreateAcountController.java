package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateAcountController {
	@GetMapping("/dang-ky")
	public String ShowCreateAcount() {
		return "Create-Acount";
	}
}
