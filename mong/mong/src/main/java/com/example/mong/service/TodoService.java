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
    public  final TodoRepo TODO_REPO;

@Autowired
    public TodoService(TodoRepo todo_repo) {
        TODO_REPO = todo_repo;
    }
    //get all records
    public List<Todo> getAllTask(){
        return TODO_REPO.findAll();
    }
    //get tsak by id
    public Todo getTaskByid(String id){
        return TODO_REPO.findById(id).orElseThrow(() -> new TaskNotFound("Task was not found"));

}

    //update todo
    public Todo updateTask(Todo task){
    return  TODO_REPO.save(task);
    }

    public Todo createTask(Todo tmp) {
    return TODO_REPO.save(tmp);
    }

    //delete per id
    public ResponseEntity<?> deleteTask(String id){
//    Todo tmp = TODO_REPO.findById(id);
        System.out.println("43");
        System.out.println(id);

        try{
            Todo obj = getTaskByid(id);
         System.out.println("46");
            System.out.println(obj.toString());
         TODO_REPO.delete(obj);
            return new ResponseEntity<>("deleted :"+id, HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);


        }

    }



}
