package com.example.mongoss.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mongoss.model.Todo;

public interface TodoRepo extends MongoRepository<Todo,String> {
    @Query("{name:'?0'}")
    Todo findItemByList(String name);

    @Query()
    List<Todo> findAll();

    public long count();
    
}
