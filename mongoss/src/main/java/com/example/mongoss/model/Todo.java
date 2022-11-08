package com.example.mongoss.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Todo")
public class Todo  {
    
    @Id
   private String id;

    private String name;

    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //constructor
    public Todo(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }


}
