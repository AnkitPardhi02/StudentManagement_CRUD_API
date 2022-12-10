package StudentManagementbackend.Service;

import StudentManagementbackend.Model.StudentModel;

import java.util.List;

public interface WebAppServiceImpl {
    void insertOneStudent(StudentModel studentModel);
    StudentModel fetchOneStudent(int id);
    void  insertListStudent(List<StudentModel> studentModels);
    List<StudentModel> fetchStudentList();
    List<StudentModel> deleteStudentList(int id);
    void deleteAllStudent();
    StudentModel updateOneStudent(StudentModel studentModel);

}
