package com.example.mong.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees")
public class EmployeeEntity {
    @Id
    private String id;
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
