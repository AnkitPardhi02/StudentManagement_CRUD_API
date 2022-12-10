package StudentManagementbackend.Controller;

import StudentManagementbackend.Model.StudentModel;
import StudentManagementbackend.Service.WebAppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppStudentController {
    @Autowired
    private WebAppServiceImpl webAppService;
    @PostMapping("/student/addSingleStudent")
    @ResponseBody
    void insertOneStudent(@RequestBody StudentModel studentModel){
        webAppService.insertOneStudent(studentModel);

    }
    @GetMapping("/student/fetchSingleStudent" )
    @ResponseBody
    StudentModel fetchOneStudent(@RequestParam int id ){
        return webAppService.fetchOneStudent(id);

    }
}
