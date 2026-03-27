package com.example.todoapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("todos")
public class Todocontroller {

    private List<Todo> todos = new ArrayList<>();
    private int nextId =1;
//Gets the Response from localhost 
    @GetMapping
    public List<Todo>getAllTodos(){
        return todos;
    }
// Sends  a post Requst to http://localhost:8080/todos
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        todo.setId(nextId++);
        todos.add(todo);
        return todo;
    }

    //PUT /todos/{id} - update a todo
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo updatedTodo) {
    for (Todo todo : todos) {
        if (todo.getId().equals(id)) {
            todo.setTitle(updatedTodo.getTitle());
            todo.setCompleted(updatedTodo.isCompleted());
            return todo;
        }
    }
    return null;
}

    //DELETE /todos{id} - delete to todo
    @DeleteMapping("{id}")
    public String deleteTodo(@PathVariable Integer id){
        todos.removeIf(todo -> todo.getId().equals(id));
        return "Todo " + id + "deleted";
    }

}