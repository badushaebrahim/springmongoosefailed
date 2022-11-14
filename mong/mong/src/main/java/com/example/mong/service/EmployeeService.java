package com.example.mong.service;

import com.example.mong.config.ModelMapperBean;
import com.example.mong.model.EmployeeDto;
import com.example.mong.model.ResponceModel;
import com.example.mong.model.entity.EmployeeEntity;
import com.example.mong.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ModelMapper modelMapper;


    public EmployeeEntity create(EmployeeDto employeeDto){
        try{
            log.info("employeedto for create "+employeeDto.toString());
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
            log.info("employee entity for create "+employeeEntity.toString());
        EmployeeEntity emp =employeeRepo.save(employeeEntity);
            log.info("employee entity saved to db "+emp.toString());
        log.info("employee saved to db");
       return emp ;

        }
        catch (Exception e){
            log.error("employee saved to db failed"+e.getMessage());
        throw new RuntimeException(e.getMessage());
        }

    }

    public List<EmployeeEntity> getAll(){
        List<EmployeeEntity> data = employeeRepo.findAll();
        log.info("all retived");
        return data;
    }

    public EmployeeEntity getemployeeById(String id){
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Task was not found"));
    }
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity){
        try{
            EmployeeEntity emp = employeeRepo.save(employeeEntity);
            log.error("employee update to db ");
            return emp;

        }
        catch (Exception e){
            log.error("employee update to db failed"+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    public ResponceModel deletebyid(String id){
        try{
            employeeRepo.delete(getemployeeById(id));
            log.error("employee deleted from db ");
            return new ResponceModel("User with id "+id+"deleted succesfully");

        }catch (Exception e){
            log.error("employee delete from db failed"+e.getMessage());
            return new ResponceModel(e.getMessage());


        }
    }
    public EmployeeEntity updateOnlyVals(EmployeeEntity emp){
        EmployeeEntity emps=new EmployeeEntity();
        EmployeeEntity data = getemployeeById(emp.getId());
        if (emp.getFiestname().isBlank()){
            log.info("blank fname");
            emp.setFiestname(data.getFiestname());
        }if (emp.getLastname().isBlank()){
            log.info("blank fname");
            emp.setLastname(data.getLastname());
        }if (!emp.getMonbilenumber().describeConstable().isPresent()){
            log.info("blank fname");
            emp.setMonbilenumber(data.getMonbilenumber());
        }

        return emp;

    }


}
