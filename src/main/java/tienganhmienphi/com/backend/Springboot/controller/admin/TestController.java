package tienganhmienphi.com.backend.Springboot.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tienganhmienphi.com.backend.Springboot.service.TestService;

@Controller(value = "testControllerOfAdmin")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/quan-tri/kiem-tra/{id}")
    public String showTestHasId(ModelMap model) {
        model.addAttribute("test", testService.findById(1));
        return "TestPageOfAdmin";
    }
    @GetMapping("/quan-tri/kiem-tra")
    public String showTest(ModelMap model) {
        model.addAttribute("tests", testService.findAll());
        return "admin/test_management";
    }
    @GetMapping("/quan-tri/kiem-tra/them")
    public String showAddTest(ModelMap model) {
        return "admin/addTest_management";
    }

    @GetMapping("/quan-tri/kiem-tra/sua/{id}")
    public String showupdateTest(ModelMap model,@PathVariable("id") Long id) {
        model.addAttribute("test", testService.findById(id));
        return "admin/updateTest_management";
    }
}
