package com.acab.postgg.repo;

import com.acab.postgg.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{
  
}
