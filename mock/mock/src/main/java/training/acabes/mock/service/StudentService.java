package training.acabes.mock.service;

import org.springframework.stereotype.Service;
import training.acabes.mock.model.ResponceModel;
import training.acabes.mock.model.Student;

import java.time.LocalDateTime;
import java.util.Date;
@Service
public class StudentService {

    public Student create(Student student){
        Student newstudent = new Student();
        newstudent.setName(student.getName());
        newstudent.setAge(student.getAge());
        newstudent.setDob(student.getDob());
        newstudent.setId(student.getId());
        return newstudent;
    }

    public Student get(String name, int age, Date dob,Long id){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setDob(dob);
        student.setId(id);
        return student;
    }
    public Student update(Student student){
        Student newstudent = new Student();
        newstudent.setName(student.getName());
        newstudent.setAge(student.getAge());
        newstudent.setDob(student.getDob());
        newstudent.setId(student.getId());
        return newstudent;
    }
    public ResponceModel delete(Long id){
        ResponceModel responceModel = new ResponceModel("Student with id "+id+" has been deleted");
        return responceModel;
    }
}
