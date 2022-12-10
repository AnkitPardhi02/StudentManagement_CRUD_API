package StudentManagementbackend.Repository;

import StudentManagementbackend.Model.StudentModel;

import java.util.List;

public interface WebAppRepoImpl {
    void insertOneStudent(StudentModel studentModel);
    StudentModel fetchOneStudent(int id);
    void insertListStudent(List<StudentModel> studentModel);

    List<StudentModel> fetchStudentList();
    List<StudentModel> deleteStudentList(int id);
    void deleteAllStudent();
    StudentModel updateOneStudent(StudentModel studentModel);


}
