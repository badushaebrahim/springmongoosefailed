package com.example.mong.controller;

import com.example.mong.model.EmployeeDto;
import com.example.mong.model.EmployeeReq;
import com.example.mong.model.ResponceModel;
import com.example.mong.model.entity.EmployeeEntity;
import com.example.mong.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestHeader("calltype") String type, @RequestBody EmployeeReq employeeDto){
        try{
            EmployeeEntity employee =employeeService.create(employeeDto);
            return  new ResponseEntity<>(employee, HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> AllEmployees(){
//        log.info(type);
        return new ResponseEntity<>(employeeService.getAllD(),HttpStatus.OK);

//        return new ResponseEntity<>(employeeService.getAllc(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> EmployeeByIds(@PathVariable String id){
        try{
            EmployeeDto employee = employeeService.getemployeeByIdDto(id);
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }catch (Exception e){
            ResponceModel rsp = new ResponceModel(e.getMessage());
            return  new ResponseEntity<>(rsp, HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeEntity){
        try{
//            EmployeeEntity employee =employeeService.updateEmployee(employeeEntity);
                EmployeeEntity employee =employeeService.updateOnlyVals(employeeEntity);
            return  new ResponseEntity<>(employee, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping
    public ResponseEntity<?> deleteEmployee(@RequestParam String id){
        return new ResponseEntity<>(employeeService.deletebyid(id),HttpStatus.OK);
    }

//    @PutMapping("/test")
//    public ResponseEntity<?> updatedsel(@RequestBody EmployeeDto emps){
//        return new ResponseEntity<>(employeeService.updateOnlyVals(emps),HttpStatus.OK);
////        return new ResponseEntity<>(employeeService.updateOnlyChanged(emps),HttpStatus.OK);
//    }
}
