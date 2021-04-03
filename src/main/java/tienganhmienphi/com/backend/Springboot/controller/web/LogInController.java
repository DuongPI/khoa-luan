package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {
	@GetMapping("/dang-nhap")
	public String ShowLogIn() {
		return "log-in";
	}
	@GetMapping("/tai-khoan")
	public String ShowAcount() {
		return "Acount";
	}
}
