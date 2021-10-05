package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tienganhmienphi.com.backend.Springboot.dto.RegisterForm;
import tienganhmienphi.com.backend.Springboot.service.UserService;

import javax.validation.Valid;

@Controller
public class CreateAcountController {
	@Autowired
	private UserService userService;

	@GetMapping("/dang-ky")
	public String ShowCreateAcount(@ModelAttribute("form") RegisterForm form) {
		return "Create-Acount";
	}

	@PostMapping("/dang-ky")
	public String submit(@ModelAttribute("form") @Valid RegisterForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "Create-Acount";
		}
		if(userService.insert(form)) {
			//userService.sendMail(form.getEmail(), form.getUsername());
			return "redirect:/";
		}
		else return "redirect:/dang-ky?error";
	}
}
