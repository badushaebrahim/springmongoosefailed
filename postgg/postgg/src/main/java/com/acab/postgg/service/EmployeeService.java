package com.acab.postgg.service;

import java.util.List;

import com.acab.postgg.model.entity.Employee;
import com.acab.postgg.model.entity.EmployeeDTO;
import com.acab.postgg.model.entity.responce.ResponceModel;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acab.postgg.repo.EmployeeRepo;

@Slf4j
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

        //login to remove null
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        Employee data2 = getEmployeebyId(emp.getId());
//        EmployeeEntity data = new EmployeeEntity(data2);
        modelMapper.map(emp,data2);

        //login to remove blanks
        Employee data = getEmployeebyId(emp.getId());
        if (data2.getFirstName().isBlank()){
            log.info("1blank fname");
            data2.setFirstName(data.getFirstName());
        }if (data2.getLastname().isBlank()){
            log.info("not up {}"+data2.getLastname());
            log.info("blank lname new {}",data.getLastname());
            data2.setLastname(data.getLastname());
            log.info(" up {}",data2.toString());
        }if (!data2.getMobileNumber().describeConstable().isPresent()){
//            log.info(data2.getMonbilenumber().describeConstable().isPresent());
//            emp.setMonbilenumber(emps.getMonbilenumber());
            log.info("blank mob");
            data2.setMobileNumber(data.getMobileNumber());
        }if (data2.getDob().toString().isBlank()){
            log.info("blank dob");
            data2.setDob(data.getDob());
        }
        if (data2.getPost().isBlank()){
            log.info("blank post");
            data2.setPost(data.getPost());
        }
        if (data2.getEmployeeStatus().isBlank()){
            log.info("blank status");
            data2.setEmployeeStatus(data.getEmployeeStatus());
        }if(data2.getCreatedDate().toString().isBlank()){
            log.info("blank createdate");
            data2.setCreatedDate(data.getCreatedDate());
        }if(data2.getEmergencyContact().isBlank()){
            log.info("blank econtact");
            data2.setEmergencyContact(data.getEmergencyContact());
        }

//        return data2;

        return EMPLOYEE_REPO.save(data2);
    }

    public ResponceModel deletebyid(Long id){
        try{
            EMPLOYEE_REPO.delete(getEmployeebyId(id));

            return new ResponceModel("deleted employee " + id);
        }
        catch (Exception e){
            return new ResponceModel(e.getMessage());
        }
    }

//    public Employee getByLastName(String lastName){
//        return EMPLOYEE_REPO.findByLastName(lastName);
//    }
    
}
