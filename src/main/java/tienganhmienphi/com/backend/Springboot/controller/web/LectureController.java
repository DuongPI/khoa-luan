package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tienganhmienphi.com.backend.Springboot.service.CourseService;

@Controller(value = "lectureControllerOfWeb")
public class LectureController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/learn/{courseName}/{id}")
    public String ShowCourse(ModelMap model, @PathVariable(required = true) String courseName
    ,@PathVariable(required = true) String id){
        model.addAttribute("courses", courseService.findByName(courseName));
        model.addAttribute("id", id);
        return "learn-course";
    }
}
