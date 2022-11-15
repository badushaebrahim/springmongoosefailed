package com.acab.postgg.repo;

import com.acab.postgg.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{
  
    
}
