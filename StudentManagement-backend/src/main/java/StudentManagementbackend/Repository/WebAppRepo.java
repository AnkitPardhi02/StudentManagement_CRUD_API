package StudentManagementbackend.Repository;
import StudentManagementbackend.Model.StudentModel;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class WebAppRepo implements WebAppRepoImpl{
    String url = "jdbc:mysql://localhost:3306/studentdata";
    String username = "root";
    String password ="";
    //******************************************************************************************************************
    @Override
    public StudentModel fetchOneStudent(int id) {
        String query="select * from student where s_id='"+id+"'";
        StudentModel sm=new StudentModel();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next())
            {
                sm.setId(rs.getInt(1));
                sm.setName(rs.getString(2));
                sm.setLastname(rs.getString(3));
                sm.setAge(rs.getInt(4));
                sm.setUsername(rs.getString(5));
                sm.setAddress(rs.getString(6));
                sm.setEmail(rs.getString(7));
                sm.setStream(rs.getString(8));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return sm;
    }
    //******************************************************************************************************************
    @Override
    public void insertListStudent(List<StudentModel> studentModel) {
        int size=studentModel.size();
        String[] query=new String[size];
        for (int i=0;i<size;i++){
            query[i]="insert into student values ('"+studentModel.get(i).getId()+"'," +
                    "'"+studentModel.get(i).getName()+"','"+studentModel.get(i).getLastname()+"','"+studentModel.get(i).getAge()+"'," +
                    "'"+studentModel.get(i).getUsername()+"','"+studentModel.get(i).getAddress()+"','"+studentModel.get(i).getEmail()+"'," +
                    "'"+studentModel.get(i).getStream()+"')";
        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            for (int i=0;i<size;i++) {
                st.executeUpdate(query[i]);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //******************************************************************************************************************
    @Override
    public void insertOneStudent(StudentModel studentModel) {
        String query="insert into student values ('"+studentModel.getId()+"'," +
                "'"+studentModel.getName()+"','"+studentModel.getLastname()+"','"+studentModel.getAge()+"'," +
                "'"+studentModel.getUsername()+"','"+studentModel.getAddress()+"','"+studentModel.getEmail()+"'," +
                "'"+studentModel.getStream()+"')";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
           int rs= st.executeUpdate(query);
            System.out.println(rs+"execution done");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //*****************************************************************************************************************
    @Override
    public List<StudentModel> fetchStudentList() {
        String query="select * from student";
        List<StudentModel> studentModels=new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                StudentModel sm=new StudentModel();
                sm.setId(rs.getInt(1));
                sm.setName(rs.getString(2));
                sm.setLastname(rs.getString(3));
                sm.setAge(rs.getInt(4));
                sm.setUsername(rs.getString(5));
                sm.setAddress(rs.getString(6));
                sm.setEmail(rs.getString(7));
                sm.setStream(rs.getString(8));
                studentModels.add(sm);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return  studentModels;
    }
    //******************************************************************************************************************

    @Override
    public List<StudentModel> deleteStudentList(int id) {
        String query="delete from student where s_id='"+id+"'";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            int result=  st.executeUpdate(query);
            if (result==0){
                System.out.println("not deleted try again");
            }else {
                System.out.println("data  deleted");
            }
        }catch (Exception exception){
            System.out.println(exception);
        }
        return fetchStudentList();
    }
    //******************************************************************************************************************


    @Override
    public void deleteAllStudent() {
        String query="delete from student";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //***************************************************************************************

    @Override
    public StudentModel updateOneStudent(StudentModel studentModel) {
        int id=9325;
        String query="update data set s_name='"+studentModel.getName()+"',s_lastname='"+studentModel.getLastname()+"'," +
                "s_age='"+studentModel.getAge()+"',s_username='"+studentModel.getUsername()+"'," +
                "s_address='"+studentModel.getAddress()+"',s_email='"+studentModel.getEmail()+"'," +
                "s_stream='"+studentModel.getStream()+"' where id='"+id+"' ";
        String query1="select * from data where id ='"+id+"' ";
        StudentModel sm=new StudentModel();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            st.executeUpdate(query);
            ResultSet rs=st.executeQuery(query1);
            while (rs.next()){
                sm.setId(rs.getInt(1));
                sm.setName(rs.getString(2));
                sm.setLastname(rs.getString(3));
                sm.setAge(rs.getInt(4));
                sm.setUsername(rs.getString(5));
                sm.setAddress(rs.getString(6));
                sm.setEmail(rs.getString(7));
                sm.setStream(rs.getString(8));

            }

        }catch (Exception exception){
            System.out.println(exception);
        }
        return sm;
    }
}







