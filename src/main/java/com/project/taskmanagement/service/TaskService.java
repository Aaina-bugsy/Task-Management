package com.project.taskmanagement.service;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    @Autowired
    private TaskRepo repo;

    //Show all the task saved in the db
    public List<Task> getAllTasks(){
        return repo.findAll();
    }

    //Show the task by particular id
    public Task getTaskById(int id){
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Task not found with ID: " + id));
    }

    //Add a new task
    public Task createTask(Task task) {
        return repo.save(task);
    }


    public Task updateTask(int id, Task task) {
        Task tsk = repo.findById(id).orElseThrow(() -> new NoSuchElementException("Task not found with ID: " + id));

        tsk.setTitle(task.getTitle());
        tsk.setDate(task.getDate());
        tsk.setDescription(task.getDescription());
        tsk.setPriority(task.getPriority());
        tsk.setStatus(task.getStatus());
        return repo.save(tsk);
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
    }

    public List<Task> getTaskByStatus(String status) {
        return repo.findByStatus(status);
    }

    public List<Task> getTaskByPriority(String priority) {
        return repo.findByPriority(priority);
    }

    public List<Task> getTaskSortedByDateAsc() {
        return repo.findAllByOrderByDateAsc();
    }

    public List<Task> getTaskSortedByDateDesc() {
        return repo.findAllByOrderByDateDesc();
    }
}
