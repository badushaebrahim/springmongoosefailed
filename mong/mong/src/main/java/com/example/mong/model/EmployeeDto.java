package com.example.mong.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String id;
    private String firstName;
    private String lastName;
    private String EmergencyContact;
    private Long mobileNumber;
    private LocalDate dob;
    private String post ;
    private  String employeeStatus;
    private boolean active;
    private Date createDate;
}
