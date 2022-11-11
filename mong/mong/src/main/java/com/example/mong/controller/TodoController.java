package com.example.mong.controller;

import com.example.mong.model.Todo;
import com.example.mong.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoController {
    public final TodoService TODO_SERVICE;
    @Autowired
    public TodoController(TodoService todo_service) {
        TODO_SERVICE = todo_service;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getALLTasks(){
        List<Todo> data = TODO_SERVICE.getAllTask();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTasksById(@PathVariable String id){
        try{
        Todo ts = TODO_SERVICE.getTaskByid(id);
        return new ResponseEntity<>(ts,HttpStatus.OK);}
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Todo tmp ){
//        System.out.println(tmp.getName());
        return new ResponseEntity<>(TODO_SERVICE.createTask(tmp),HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody Todo tmp){
        return new ResponseEntity<>(TODO_SERVICE.updateTask(tmp),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable String id){
        return TODO_SERVICE.deleteTask(id);
    }

    @GetMapping("/tell/{text}")
    public String ret(@PathVariable String text){
        return text;
    }

    @GetMapping("/mock")
    public ResponseEntity<Todo> mo(@RequestBody Todo todo){
        return new ResponseEntity<Todo>(todo,HttpStatus.OK);}


}
