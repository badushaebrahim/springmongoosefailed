package com.example.mong.controller;

import com.example.mong.model.Todo;
import com.example.mong.service.Todoservice;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
