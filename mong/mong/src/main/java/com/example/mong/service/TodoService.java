package com.example.mong.service;

import com.example.mong.exception.TaskNotFound;
import com.example.mong.model.Todo;
import com.example.mong.repo.TodoRepo;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Todoservice {
    public  final TodoRepo TODO_REPO;

@Autowired
    public Todoservice(TodoRepo todo_repo) {
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
    public  String  deleteTask(Todo tmp){
//    Todo tmp = TODO_REPO.findById(id);
    TODO_REPO.delete(tmp);
    return "ok";
    }


}
