package com.example.mong.service;

import com.example.mong.model.EmployeeDto;
import com.example.mong.model.ResponceModel;
import com.example.mong.model.entity.EmployeeEntity;
import com.example.mong.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.modelmapper.Conditions;
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
            log.info("employeedto {} , interactionId : {} for create ",employeeDto.toString(),employeeDto.getId());
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
            log.info("employee entity for create {} ",employeeEntity.toString());
        EmployeeEntity emp =employeeRepo.save(employeeEntity);
            log.info("employee entity saved to db {}",emp.toString());
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
    public EmployeeEntity updateOnlyVals(EmployeeDto emp)
    {
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        EmployeeEntity data2 = getemployeeById(emp.getId());
        modelMapper.map(emp,data2);

        EmployeeEntity data = getemployeeById(emp.getId());
        if (data2.getFiestname().isBlank()){
            log.info("1blank fname");
            data2.setFiestname(data.getFiestname());
        }if (data2.getLastname().isBlank()){
            log.info("not up {}",data2.getLastname());
            log.info("blank fname");
            data2.setLastname(data.getLastname());
        log.info(" up {}",data2.getLastname());
        }if (data2.getMonbilenumber().describeConstable().isPresent()){
//            emp.setMonbilenumber(emps.getMonbilenumber());
            log.info("blank fname");
            data2.setMonbilenumber(data.getMonbilenumber());
        }if (data2.getMonbilenumber().describeConstable().isPresent()){
            log.info("blank fname");
            data2.setMonbilenumber(data.getMonbilenumber());
        }if (data2.getDob().toString().isBlank()){
            data2.setDob(data.getDob());
        }
        if (data2.getPost().isBlank()){
            data2.setPost(data.getPost());
        }
        if (data2.getEmployeestatus().isBlank()){
                data2.setEmployeestatus(data.getEmployeestatus());
        }if(data2.getCreatedat().toString().isBlank()){
            data2.setCreatedat(data.getCreatedat());
        }if(data2.getEmergencycontact().isBlank()){
            data2.setEmergencycontact(data.getEmergencycontact());
        }

//        return data2;

        return employeeRepo.save(data2);
    }

    public EmployeeEntity updateOnlyChanged (EmployeeDto dto){
        EmployeeEntity emp = getemployeeById(dto.getId());
////        modelMapper.map(dto,emp);
//        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        log.info("mapped val {}",dto.toString());
        modelMapper.map(dto,emp);
        return emp;

    }


}
