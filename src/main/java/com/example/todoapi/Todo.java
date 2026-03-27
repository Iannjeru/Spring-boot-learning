package com.example.todoapi;

public class Todo {

    private Integer id;
    private String title;
    private Boolean completed;
    //No argument constructor 
    public Todo(){}
    //constructor
    public Todo(Integer id, String title, Boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }
}
