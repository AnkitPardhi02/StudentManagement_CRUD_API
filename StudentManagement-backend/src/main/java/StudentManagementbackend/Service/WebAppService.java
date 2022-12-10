package StudentManagementbackend.Service;

import StudentManagementbackend.Model.StudentModel;
import StudentManagementbackend.Repository.WebAppRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebAppService implements WebAppServiceImpl{
    @Autowired
    private WebAppRepoImpl webAppRepo;

    @Override
    public void insertOneStudent(StudentModel studentModel) {
        webAppRepo.insertOneStudent(studentModel);
    }

    @Override
    public StudentModel fetchOneStudent(int id) {
        return webAppRepo.fetchOneStudent(id);
    }

    @Override
    public void insertListStudent(List<StudentModel> studentModel) {
        webAppRepo.insertListStudent(studentModel);

    }

    @Override
    public List<StudentModel> fetchStudentList() {
        return webAppRepo.fetchStudentList();
    }

    @Override
    public List<StudentModel> deleteStudentList(int id) {
        webAppRepo.deleteStudentList(id);

        return webAppRepo.fetchStudentList();
    }

    @Override
    public void deleteAllStudent() {
        webAppRepo.deleteAllStudent();
    }

    @Override
    public StudentModel updateOneStudent(StudentModel studentModel) {
        return webAppRepo.updateOneStudent(studentModel);
    }
}
