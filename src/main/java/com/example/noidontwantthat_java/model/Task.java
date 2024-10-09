package com.example.noidontwantthat_java.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task {
    private String description;
    private LocalDate date;
    private int hours;
    private int minutes;
    private LocalTime timebegin;

    public Task(String description, LocalDate date, int hours, int minutes, LocalTime timebegin) {
        this.description = description;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
        this.timebegin = timebegin;
    }

    // Getter & Setter
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }

    public  int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public LocalTime getTimebegin() {
        return timebegin;
    }
    public void setTimebegin(LocalTime timebegin) {
        this.timebegin = timebegin;
    }

}
