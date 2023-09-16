package com.springboot.mysql.datastore;

import com.springboot.mysql.database_connector.ConnectionManager;
import com.springboot.mysql.model.Student;
import com.springboot.practice1.model.StudentInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemDataStore {
    private static final String INSERT_STUDENT= "insert into student (studentID,LastName,FirstNameStudent,City) values(?,?,?,?)";
    private static final String GET_STUDENT_DATA="select * from student where FirstNameStudent =?";
    private static final String GET_STUDENT="select * from student where studentId =?";
    private static final String DELETE_STUDENT="delete from student where studentId =?";
    private static final String UPDATE_STUDENT="Update student set firstnamestudent=?,lastname=?,city=? where studentId=?";
    private static final String GET_ALL_STUDENT="select * from student";

    private Connection  con = ConnectionManager.getConnection();

    public Student addNewStudent(Student student) {
        try{
            PreparedStatement ps = con.prepareStatement(INSERT_STUDENT);
            ps.setInt(1,student.getStudentId());
            ps.setString(2, student.getLastname());
            ps.setString(3,student.getFirstname());
            ps.setString(4,student.getCity());
            int result =ps.executeUpdate();
            if(result==1){
                System.out.println("Inserted Successfully");
                PreparedStatement ps2 = con.prepareStatement(GET_STUDENT_DATA);
                ps2.setString(1,student.getFirstname());
                ResultSet rs = ps2.executeQuery();
                while(rs.next()){
                    return Student.builder()
                            .studentId(rs.getInt("studentId"))
                            .city(rs.getString("city"))
                            .firstname(rs.getString("firstnamestudent"))
                            .lastname(rs.getString("lastname")).build();
                }
            }
        }
        catch (Exception e){
            System.out.println("Error while inserting: "+ e);
        }
        return Student.builder().build();
    }

    public List<Student> fetchAllStudents(){
        List<Student> ls = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(GET_ALL_STUDENT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student s= Student.builder()
                        .lastname(rs.getString("lastname"))
                        .firstname(rs.getString("firstnameStudent"))
                        .studentId(rs.getInt("studentId"))
                        .city(rs.getString("city")).build();
                System.out.println(s);
                ls.add(s);
            }
            return  ls;
        }
        catch (Exception e){}
        return null;
    }

    public Student getStudentInfo(int id){
        try{
            PreparedStatement ps = con.prepareStatement(GET_STUDENT);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            return Student.builder()
                    .city(rs.getString("city"))
                    .firstname(rs.getString("firstnamestudent"))
                    .lastname(rs.getString("lastname"))
                    .studentId(rs.getInt("studentId")).build();
            }
        }
        catch(Exception e){}
        return null;
    }
    public List<Student> deleteStudent(int id){
        try{
            PreparedStatement ps = con.prepareStatement(DELETE_STUDENT);
            ps.setInt(1,id);
            ps.executeUpdate();
            return fetchAllStudents();
        }
        catch(Exception e){}
        return null;
    }

    public Student updateStudent(int id,String fname,String lname, String CT){
        try{
            PreparedStatement ps = con.prepareStatement(UPDATE_STUDENT);
            ps.setString(1,fname);
            ps.setString(2,lname);
            ps.setString(3,CT);
            ps.setInt(4,id);
            int rs= ps.executeUpdate();
            if(rs>0) {
                System.out.println("Updated Successfully");
                return getStudentInfo(id);
            }
        }
        catch(Exception e){}
        return Student.builder().build();
    }


//    public static void main(String[] args) {
//        addNewStudent(Student.builder()
//                .city("Nagpur")
//                .lastname("Khobragade")
//                .firstname("Pooja")
//                .studentId(100).build());
//    }
}
