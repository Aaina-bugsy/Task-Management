package com.project.taskmanagement.repo;

import com.project.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    //Find a task by Status
    List<Task> findByStatus(String status);

    //Find a task by priority
    List<Task> findByPriority(String priority);

    //Sort tasks in ascending order of date
    List<Task> findAllByOrderByDateAsc();

    //Sort tasks in descending order of date
    List<Task> findAllByOrderByDateDesc();
}
