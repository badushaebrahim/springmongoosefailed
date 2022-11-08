package com.example.mongoss.repo;

public interface    TodoRepocustom  {
    void updateTaskStatusById(String taskid,String Status);
    void updateTaskStatusByName(String taskname,String Status);
}
