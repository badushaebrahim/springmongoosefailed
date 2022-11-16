package com.acab.postgg.controller;

import java.util.List;

import com.acab.postgg.model.entity.Employee;
import com.acab.postgg.model.entity.EmployeeDTO;
import com.acab.postgg.model.entity.responce.ResponceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.acab.postgg.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    public final EmployeeService EMPLOYEE_SERVICE;
    
    @Autowired
    public EmployeeController(EmployeeService eMPLOYEE_SERVICE) {
        this.EMPLOYEE_SERVICE = eMPLOYEE_SERVICE;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getall(){
        List<Employee> data = EMPLOYEE_SERVICE.getAllEmployee();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getbyid(@PathVariable Long id){
        try{
            return new ResponseEntity<>(EMPLOYEE_SERVICE.getEmployeebyId(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ResponceModel(e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("/{lastName}")
//    public ResponseEntity<?> getbyid(@PathVariable String lastName){
//        try{
//            return new ResponseEntity<>(EMPLOYEE_SERVICE.getByLastName(lastName),HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(new ResponceModel(e.getMessage()),HttpStatus.NOT_FOUND);
//        }
//    }
    @PostMapping
    public ResponseEntity<?>addnew(@RequestBody EmployeeDTO employee){
        
        return new ResponseEntity<>(EMPLOYEE_SERVICE.createEmployee(employee),HttpStatus.CREATED) ;
        
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(EMPLOYEE_SERVICE.update(employee),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable Long id){
        try {
            return new ResponseEntity<>(EMPLOYEE_SERVICE.deletebyid(id),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(new ResponceModel(e.getMessage()),HttpStatus.NOT_FOUND);
        }

    }

    
}
