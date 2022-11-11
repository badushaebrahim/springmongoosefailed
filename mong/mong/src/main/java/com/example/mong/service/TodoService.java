package com.example.mong.service;

import com.example.mong.exception.TaskNotFound;
import com.example.mong.model.Todo;
import com.example.mong.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    public   TodoRepo TODO_REPO;




    //get all records
    public List<Todo> getAllTask(){
        return TODO_REPO.findAll();
    }
    //get tsak by id
    public Todo getTaskByid(String id){
//        return TODO_REPO.findById(id).orElseThrow(() -> new TaskNotFound("Task was not found"));
        return TODO_REPO.findById(id).orElseThrow(() -> new RuntimeException("Task was not found"));
}


    //update todo
    public Todo updateTask(Todo task){
    return  TODO_REPO.save(task);
    }

    //create task
    public Todo createTask(Todo tmp) {
    return TODO_REPO.save(tmp);
    }

    //delete per id
    public ResponseEntity<?> deleteTask(String id){

        try{
            TODO_REPO.delete(getTaskByid(id));
            return new ResponseEntity<>("deleted :"+id, HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);


        }

    }



}
