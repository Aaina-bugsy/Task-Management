package com.project.taskmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id  // marks the variable as the primary key in db
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank(message = "Title should not be empty")
    private String title;
    private String description;

    @NotNull(message = "Status is required")
    @Pattern(regexp = "To Do|Pending|In-Progress|Completed", message = "Status should be To Do, Pending, In-Progress or Completed")
    private String status;

    //makes sure the date is always n future
    @Future(message ="Date should in future")
    private LocalDate date;

    @NotNull(message = "Priority is required")
    private String priority;
}
