package tienganhmienphi.com.backend.Springboot.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tienganhmienphi.com.backend.Springboot.service.CourseService;
import tienganhmienphi.com.backend.Springboot.service.Impl.UserServiceImpl;
import tienganhmienphi.com.backend.Springboot.service.UserService;

@Controller
public class AcountController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/tai-khoan/{id}")
    public String updateAcount(ModelMap model, @PathVariable("id") String id,
                               @RequestParam("password") String password,
                               @RequestParam("prepassword") String prepassword,
                               @RequestParam("confirmPassword") String confirmPassword) {
        System.out.println(password);
        System.out.println(prepassword);
        System.out.println(confirmPassword);
        model.addAttribute("courses", courseService.findByUserId(Long.parseLong(id)));
        model.addAttribute("alert", userService.changePass(Long.parseLong(id),prepassword,password));
        return "Acount";
    }
}
