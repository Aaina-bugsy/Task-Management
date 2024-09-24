package com.project.taskmanagement.controller;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService service;

    //Show all the task in the db
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }

    //show the task with the given id
    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTask(@PathVariable int id){
        //Task task = service.getTaskById(id);
        return new ResponseEntity<>(service.getTaskById(id), HttpStatus.FOUND);
        /*if( task != null){
        }else{ return new ResponseEntity<>("Task not found",HttpStatus.NOT_FOUND);
        }*/
    }

    //Create a new Task
    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<>(service.createTask(task), HttpStatus.CREATED);
    }

    //Update a task
    @PutMapping("/tasks/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody Task task){
        Task tsk = service.updateTask(id, task);
        if( tsk != null){
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Product", HttpStatus.BAD_REQUEST);
        }
    }

    //Delete a task by Id
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id){
        Task deleteTask = service.getTaskById(id);

        if( deleteTask != null){
            service.deleteTask(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Not Found Task", HttpStatus.BAD_REQUEST);
        }
    }

    //Filter By status
    @GetMapping("/tasks/status/{status}")
    public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable String status){
        return new ResponseEntity<>(service.getTaskByStatus(status), HttpStatus.OK);
    }

    //Filter By Priority
    @GetMapping("/tasks/priority/{priority}")
    public ResponseEntity<List<Task>> getTaskByPriority(@PathVariable String priority){
        return new ResponseEntity<>(service.getTaskByPriority(priority), HttpStatus.OK);
    }

    //sort the list of task by date ascending order
    @GetMapping("/tasks/date/asc")
    public ResponseEntity<List<Task>> getTasksSortedByDateAsc(){
        return new ResponseEntity<>(service.getTaskSortedByDateAsc(), HttpStatus.OK);
    }

    //sort the list of task by date descending order
    @GetMapping("/tasks/date/desc")
    public ResponseEntity<List<Task>> getTaskSortedByDateDesc(){
        return new ResponseEntity<>(service.getTaskSortedByDateDesc(), HttpStatus.OK);
    }
}
