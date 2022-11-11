package com.example.mong.controller;

import com.example.mong.model.Todo;
import com.example.mong.service.Todoservice;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoController {
    public final Todoservice TODO_SERVICE;
    @Autowired
    public TodoController(Todoservice todo_service) {
        TODO_SERVICE = todo_service;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getALLTasks(){
        List<Todo> data = TODO_SERVICE.getAllTask();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTasksById(@PathVariable String id){
        Todo ts = TODO_SERVICE.getTaskByid(id);
        return new ResponseEntity<>(ts,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Todo tmp ){
        return new ResponseEntity<>(TODO_SERVICE.createTask(tmp),HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody Todo tmp){
        return new ResponseEntity<>(TODO_SERVICE.updateTask(tmp),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@RequestBody String id){
        try{
            Todo obj = TODO_SERVICE.getTaskByid(id);
            TODO_SERVICE.deleteTask(obj);
            return new ResponseEntity<>("deleted :"+id,HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);


        }
    }
}
