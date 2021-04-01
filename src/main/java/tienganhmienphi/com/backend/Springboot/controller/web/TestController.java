package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import tienganhmienphi.com.backend.Springboot.service.TestService;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/kiem-tra")
    public String showTest(ModelMap model) {
        model.addAttribute("test", testService.findById(1));
        return "kiemtra";
    }
}
