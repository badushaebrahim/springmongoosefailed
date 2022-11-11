package training.acabes.mock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.acabes.mock.model.ResponceModel;
import training.acabes.mock.model.Student;
import training.acabes.mock.service.StudentService;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> postStudent(@RequestBody Student student){
        Student data= studentService.create(student);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Student> getStudent(@RequestParam String name,@RequestParam int age,@RequestParam Date dob
                                              ,@RequestParam Long id){
        Student data= studentService.get(name,age,dob,id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Student> putStudent(@RequestBody Student student){
        Student data= studentService.update(student);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ResponceModel> deleteStudent(@RequestParam Long id){
        ResponceModel responceModel = studentService.delete(id);
        return new ResponseEntity<>(responceModel, HttpStatus.OK);
    }




}
