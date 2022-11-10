package com.example.mong.exception;

public class TaskNotFound extends RuntimeException{
    public TaskNotFound(String msg){
        super(msg);
    }
}
