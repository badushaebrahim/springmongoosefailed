package com.example.mong.service;

import com.example.mong.model.EmployeeDto;
import com.example.mong.model.EmployeeReq;
import com.example.mong.model.ResponceModel;
import com.example.mong.model.entity.EmployeeEntity;
import com.example.mong.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ModelMapper modelMapper;


    public EmployeeEntity create(EmployeeReq employeeDto) {
        try {
            log.info("employeedto {} , interactionId : {} for create ", employeeDto.toString());
            EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
            log.info("employee entity for create {} ", employeeEntity.toString());
            EmployeeEntity emp = employeeRepo.save(employeeEntity);
            log.info("employee entity saved to db {}", emp.toString());
            log.info("employee saved to db");
            return emp;

        } catch (Exception e) {
            log.error("employee saved to db failed" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }

    public List<EmployeeDto> getAll() {
        List<EmployeeEntity> datas = employeeRepo.findAll();
        List<EmployeeDto> Responces = new ArrayList<EmployeeDto>();
        for (EmployeeEntity data: datas) {
            EmployeeDto temp = modelMapper.map(data,EmployeeDto.class);
            Responces.add(temp);
        }
        log.info("all retived");
        return Responces;
    }

    public EmployeeEntity getemployeeById(String id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee was not found"));
    }
    public EmployeeDto getemployeeByIdDto(String id) {
        EmployeeEntity employeeEntity =employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee was not found"));
        EmployeeDto employeeDto = modelMapper.map(employeeEntity,EmployeeDto.class);
        return employeeDto;
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        try {
            EmployeeEntity emp = employeeRepo.save(employeeEntity);
            log.error("employee update to db ");
            return emp;

        } catch (Exception e) {
            log.error("employee update to db failed" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public ResponceModel deletebyid(String id) {
        try {
            employeeRepo.delete(getemployeeById(id));
            log.error("employee deleted from db ");
            return new ResponceModel("User with id " + id + "deleted succesfully");

        } catch (Exception e) {
            log.error("employee delete from db failed" + e.getMessage());
            return new ResponceModel(e.getMessage());


        }
    }

    public EmployeeEntity updateOnlyVals(EmployeeDto emp) {

          EmployeeEntity data = getemployeeById(emp.getId());


        String firstName =StringUtils.isBlank( emp.getFiestname() ) ? data.getFiestname() : emp.getFiestname();
        data.setFiestname(firstName);

        String lastName = StringUtils.isBlank(emp.getLastname()) ? data.getLastname() : emp.getLastname();
        data.setLastname(lastName);
        Long mobileNumber = StringUtils.isBlank(String.valueOf(emp.getMonbilenumber())) ? data.getMonbilenumber() : emp.getMonbilenumber();
        data.setMonbilenumber(mobileNumber);
        LocalDate dob = StringUtils.isBlank(String.valueOf(emp.getMonbilenumber())) ? data.getDob() : emp.getDob();
        data.setDob(dob);
        String post = StringUtils.isBlank(emp.getPost()) ? data.getPost() : emp.getPost();
        data.setPost(post);
        String employementStatus = StringUtils.isBlank(emp.getEmployeestatus()) ? data.getEmployeestatus() : emp.getEmployeestatus();
        data.setEmployeestatus(employementStatus);
        Date timestamp = StringUtils.isBlank(emp.getCreatedat().toString()) ? data.getCreatedat() : emp.getCreatedat();
        data.setCreatedat(timestamp);
        String contact = StringUtils.isBlank(emp.getEmergencycontact()) ? data.getEmergencycontact() : emp.getEmergencycontact();
        data.setEmergencycontact(contact);
        return employeeRepo.save(data);
    }

    public EmployeeEntity updateOnlyChanged(EmployeeDto dto) {
        EmployeeEntity emp = getemployeeById(dto.getId());
////        modelMapper.map(dto,emp);
//        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        log.info("mapped val {}", dto.toString());
        modelMapper.map(dto, emp);
        return emp;

    }


}
