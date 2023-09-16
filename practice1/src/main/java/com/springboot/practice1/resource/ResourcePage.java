package com.springboot.practice1.resource;

import com.springboot.practice1.Exceptions.InvalidStudentInfoException;
import com.springboot.practice1.controller.StudentManager;
import com.springboot.practice1.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("desk/pooja/documents")
public class ResourcePage {

    @GetMapping("/hello/{name}")
    public ResponseEntity<Object> getData(@PathVariable("name") String username){
        return new ResponseEntity<>("Hello " + username +" I am in the getData method", HttpStatus.ACCEPTED);
    }
    @GetMapping("/roll/{rnumber}")
    public ResponseEntity<Object> getRoll(@PathVariable("rnumber") int rollnumber){
        return new ResponseEntity<>("my roll number is "+rollnumber,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/both/{name}")
    public ResponseEntity<Object> getRoll2(@PathVariable("name") String username, @RequestParam int age){
        //One Generic way to handle the exception
//        try{
//            if(username.equals(" ") || age<18){
//                throw new InvalidStudentInfoException("Invalid Username or Age");
//            }
//        }
//        catch(InvalidStudentInfoException ex){
//            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
//        }
        if(username.equals(" ") || age<18){
                throw new InvalidStudentInfoException();
        }

        return new ResponseEntity<>("My name is "+username+" and roll number is "+age,HttpStatus.ACCEPTED);
    }

    @GetMapping("object/studentInfo")
    public Object getObject(@RequestBody StudentInfo studentInfo){
        studentInfo.setCity("Nagpur");
        return "My name is "+ studentInfo.getName()+" I am from "+ studentInfo.getCity()+" I am "+studentInfo.getAge()+" yrs old" ;
    }
    @GetMapping("/header")
    public String getHeaderValue(HttpServletRequest request){
        String _name=request.getHeader("name");
        String age=request.getHeader("age");
        return "Header Body: "+ _name +" "+age ;
    }
    @Autowired
    StudentManager studentManager;
    @GetMapping("/autowired/comp")
    public String getAutowired(){
        return studentManager.getInfo();
    }
}
