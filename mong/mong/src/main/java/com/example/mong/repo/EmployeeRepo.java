package com.example.mong.repo;

import com.example.mong.model.entity.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface  EmployeeRepo extends MongoRepository<EmployeeEntity,String> {

}
