package com.example.mongoss.repo;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.mongoss.model.Todo;
import com.mongodb.client.result.UpdateResult;

@Component
public class TodoRepoImplementation implements TodoRepocustom {
    @Autowired
	MongoTemplate mongoTemplate;

    @Override
    public void updateTaskStatusById(String taskid, String Status) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateTaskStatusByName(String taskname, String Status) {
        // TODO Auto-generated method stub
        // Query query = new Query(Criteria.where("taskname").is(taskname));
        Query query = new Query(Criteria.where("task").is(taskname));
        Update update = new Update();
        update.set("status", Status);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Todo.class);
        
        if(result== null){
            System.out.println("No documents updated");
        }else{
            System.out.println(result.getModifiedCount() + " document(s) updated..");
        }

        
    }
    
}
