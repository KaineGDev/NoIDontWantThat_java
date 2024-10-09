package com.example.noidontwantthat_java.controller;

import com.example.noidontwantthat_java.TaskDAO;
import com.example.noidontwantthat_java.model.Task;

import java.sql.SQLException;
import java.time.LocalTime;

public class TaskController {

    private TaskDAO taskDAO;

    public TaskController() {
        this.taskDAO = new TaskDAO();
    }

    public void addTask(String description, java.time.LocalDate date, int hours, int minutes, LocalTime timebegin) {
        Task task = new Task(description, date, hours, minutes, timebegin);
        try {
            taskDAO.saveTask(task);
            System.out.println("Tätigkeit erfolgreich gespeichert!");
        } catch (SQLException e) {
            System.err.println("Fehler beim Speichern der Tätigkeit: " + e.getMessage());
        }
    }

    // Weitere Methoden (CRUD)
}
