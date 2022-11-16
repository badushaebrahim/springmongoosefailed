package com.acab.postgg.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastname;
    private String emergencyContact;
    private Long mobileNumber;
    private LocalDate dob;
    private String post ;
    private  String employeeStatus;
    private boolean active;
    private Date createdDate;
}
