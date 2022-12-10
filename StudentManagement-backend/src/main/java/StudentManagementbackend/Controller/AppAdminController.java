package StudentManagementbackend.Controller;

import StudentManagementbackend.Model.StudentModel;
import StudentManagementbackend.Service.WebAppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppAdminController {
    @Autowired
    private WebAppServiceImpl webAppService;



    //**************************************************************************************

    @PostMapping("/admin/addSingleStudent")
    @ResponseBody
    void insertOneStudent(@RequestBody StudentModel studentModel){
    webAppService.insertOneStudent(studentModel);

    }
    //***************************************************************************************
    @PostMapping("/admin/addStudentList")
    @ResponseBody
    void insertListStudent(@RequestBody List<StudentModel> studentModel){
        webAppService.insertListStudent(studentModel);

    }
    //***************************************************************************************
    @GetMapping ("/admin/fetchSingleStudent" )
    @ResponseBody
    StudentModel fetchOneStudent(@RequestParam int id ){
        return webAppService.fetchOneStudent(id);

    }
    //****************************************************************************************
    @GetMapping ("/admin/fetchStudentList" )
    @ResponseBody
    List<StudentModel> fetchStudentList(){
        return webAppService.fetchStudentList();

    }
    //******************************************************************************************

    @GetMapping ("/admin/deleteSingleStudent" )
    @ResponseBody
    List<StudentModel> deleteOneStudent(@RequestParam int id ){

              return webAppService.deleteStudentList(id);

    }
    //****************************************************************************************
    @GetMapping("/admin/deleteAllStudent")
    @ResponseBody
    void deleteAllStudent(){
        webAppService.deleteAllStudent();

    }
    //*******************************************************************************************

    @PutMapping("/admin/deleteAllStudent")
    @ResponseBody
    StudentModel updateOneStudent(@RequestBody StudentModel studentModel){
      return   webAppService.updateOneStudent(studentModel);

    }
}
