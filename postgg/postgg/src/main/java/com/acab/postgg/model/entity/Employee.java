package com.acab.postgg.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable=false)
//    private Long id;
//    private String lastName;
//    private String firstNaString;
//    private Long contact;
//    private int departmentId;
    private Long id;
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
