package com.project.taskmanagement.repo;

import com.project.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    List<Task> findByStatus(String status);

    List<Task> findByPriority(String priority);

    List<Task> findAllByOrderByDateAsc();

    List<Task> findAllByOrderByDateDesc();
}
