package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import tienganhmienphi.com.backend.Springboot.service.TestService;

@Controller(value = "testControllerOfWeb")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/kiem-tra-online")
    public String showAllTest(ModelMap model) {
        model.addAttribute("tests", testService.findAll());
        return "TestPage";
    }
    @GetMapping("/kiem-tra/{id}")
    public String showTestHasId(ModelMap model) {
        model.addAttribute("test", testService.findById(1));
        return "kiemtra";
    }
    @GetMapping("/ket-qua-thi")
    public String showResult() {
        return "ResultTestPage";
    }
}
