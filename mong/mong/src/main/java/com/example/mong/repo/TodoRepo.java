package com.example.mong.repo;

import com.example.mong.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TodoRepo extends MongoRepository<Todo,String> {
//    Optional<Todo> findbyId(String id);
}
