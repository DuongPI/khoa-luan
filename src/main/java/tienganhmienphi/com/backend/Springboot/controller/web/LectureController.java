package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tienganhmienphi.com.backend.Springboot.dto.ChapterReponse;
import tienganhmienphi.com.backend.Springboot.service.ChapterService;
import tienganhmienphi.com.backend.Springboot.service.CourseService;
import tienganhmienphi.com.backend.Springboot.service.LectureFinishService;
import tienganhmienphi.com.backend.Springboot.service.LectureService;

import java.util.List;

@Controller(value = "lectureControllerOfWeb")
public class LectureController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private LectureService lectureService;
    @Autowired
    private LectureFinishService lectureFinishService;

    @GetMapping("/learn/{courseName}/{userid}/{id}")
    public String ShowCourse(ModelMap model, @PathVariable(required = true) String courseName
            , @PathVariable(required = true) String id, @PathVariable(required = true) String userid) {
        model.addAttribute("course", courseService.findByName(courseName));
        model.addAttribute("coursename", courseName);
        model.addAttribute("chapters", chapterService._findAllByCourse(courseName, userid));
        model.addAttribute("id", id);
        model.addAttribute("progree", lectureFinishService.progree(courseName, userid));
        model.addAttribute("learns", lectureFinishService.findAll());
        model.addAttribute("ischeck", lectureFinishService.checkId(Long.parseLong(id), Long.parseLong(userid)));
        model.addAttribute("lecture", lectureService.findById(Long.parseLong(id)));
        return "learn-course";

    }
}
