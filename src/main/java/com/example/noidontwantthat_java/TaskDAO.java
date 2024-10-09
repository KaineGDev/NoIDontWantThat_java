package com.example.noidontwantthat_java;

import com.example.noidontwantthat_java.database.PostgreSQLJDBC;
import com.example.noidontwantthat_java.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class TaskDAO {

    public void saveTask(Task task) throws SQLException {
        String query = "INSERT INTO taetigkeit (description, date, hours, minutes, timebegin) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = PostgreSQLJDBC.connect();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, task.getDescription());
            statement.setDate(2, java.sql.Date.valueOf(task.getDate()));
            statement.setInt(3, task.getHours());
            statement.setInt(4, task.getMinutes());
            statement.setTime(5, Time.valueOf(task.getTimebegin()));

            statement.executeUpdate(); // Führe das SQL-Insert-Statement aus
        }
    }

    // Weitere Methoden
}

