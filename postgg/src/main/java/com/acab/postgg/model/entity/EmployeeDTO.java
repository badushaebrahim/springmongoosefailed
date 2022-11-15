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
    private String fiestname;
    private String lastname;
    private String Emergencycontact;
    private Long monbilenumber;
    private LocalDate dob;
    private String post ;
    private  String employeestatus;
    private boolean active;
    private Date createdat;
}
