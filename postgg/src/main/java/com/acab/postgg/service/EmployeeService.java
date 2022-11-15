package com.acab.postgg.service;

import java.util.List;

import com.acab.postgg.model.entity.Employee;
import com.acab.postgg.model.entity.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acab.postgg.repo.EmployeeRepo;


@Service
public class EmployeeService  {
    @Autowired
    public  EmployeeRepo EMPLOYEE_REPO;
    @Autowired
    ModelMapper modelMapper;



    public List<Employee> getAllEmployee(){
        return EMPLOYEE_REPO.findAll();
    }

    public Employee getEmployeebyId(Long id){
        return EMPLOYEE_REPO.findById(id).orElseThrow(() ->new RuntimeException("Employee not found"));
    }

    public Employee createEmployee(EmployeeDTO emp){
        Employee data = modelMapper.map(emp,Employee.class);
      return    EMPLOYEE_REPO.save(data);
      
    }

    public Employee update(Employee emp){

        return  emp;
    }

    public String deletebyid(Long id){
        try{
            EMPLOYEE_REPO.delete(getEmployeebyId(id));

            return  ("deleted employee " + id);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    
}
