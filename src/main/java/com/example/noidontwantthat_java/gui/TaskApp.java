package com.example.noidontwantthat_java.gui;

import com.example.noidontwantthat_java.controller.TaskController;
import org.jdatepicker.JDatePanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;

public class TaskApp {
    private TaskController taskController;

    public TaskApp() {
        this.taskController = new TaskController();
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Tätigkeiten Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);

        // Layout
        GridBagLayout layout = new GridBagLayout();
        frame.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;



        /*
        // DatePicker hinzufügen
        JLabel dateLabel = new JLabel("Datum:");
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Heute");
        properties.put("text.month", "Monat");
        properties.put("text.year", "Jahr");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        JLabel timeLabel = new JLabel("Beginn Uhrzeit (HH:mm):");
        JTextField timeField = new JTextField(5);
        frame.add(dateLabel);
        frame.add(datePicker);

        */


        // GUI-Komponenten
        JTextField descriptionField = new JTextField(20);
        JTextField hoursField = new JTextField(2);
        JTextField minutesField = new JTextField(2);
        SpinnerDateModel timeModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(timeModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(java.util.Date.from(LocalTime.now().atDate(java.time.LocalDate.now()).atZone(java.time.ZoneId.systemDefault()).toInstant()));
        timeSpinner.setValue(java.util.Date.from(LocalTime.now().atDate(java.time.LocalDate.now()).atZone(java.time.ZoneId.systemDefault()).toInstant()));
        timeSpinner.setModel(new SpinnerDateModel());
        JButton saveButton = new JButton("Speichern");

        // Layout
        JPanel panel = new JPanel(new GridLayout(5,2));
        JLabel descriptionLabel = new JLabel("Beschreibung:");
        JLabel hoursLabel = new JLabel("Stunden:");
        JLabel minutesLabel = new JLabel("Minuten:");
        JLabel timeLabel = new JLabel("Beginn:");

        // Hinzufügen von Komponenten zum Layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        //gbc.weightx = 0.5;
        layout.setConstraints(descriptionLabel, gbc);
        panel.add(descriptionLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        //gbc.weightx = 1.0;
        layout.setConstraints(descriptionField, gbc);
        panel.add(descriptionField);

        gbc.gridx = 0;
        gbc.gridy = 2;
        //gbc.weightx = 0.5;
        layout.setConstraints(timeLabel, gbc);
        panel.add(timeLabel);

        gbc.gridx = 1;
        gbc.gridy = 2;
        //gbc.weightx = 1.0;
        layout.setConstraints(timeSpinner, gbc);
        panel.add(timeSpinner);

        gbc.gridx = 0;
        gbc.gridy = 3;
        layout.setConstraints(hoursLabel, gbc);
        panel.add(hoursLabel);

        gbc.gridx = 1;
        gbc.gridy = 3;
        layout.setConstraints(hoursField, gbc);
        panel.add(hoursField);

        gbc.gridx = 0;
        gbc.gridy = 4;
        layout.setConstraints(minutesLabel, gbc);
        panel.add(minutesLabel);

        gbc.gridx = 1;
        gbc.gridy = 4;
        layout.setConstraints(minutesField, gbc);
        panel.add(minutesField);

        // ->
        JLabel emptyLabel = new JLabel("");
        gbc.gridx = 0;
        gbc.gridy = 5;
        layout.setConstraints(emptyLabel, gbc);
        panel.add(emptyLabel);
        // ->
        gbc.gridx = 1;
        gbc.gridy = 5;
        layout.setConstraints(saveButton, gbc);
        panel.add(saveButton);


        // Action Listener für den Speichern-Button
        saveButton.addActionListener(e -> {
            String description = descriptionField.getText();
            int hours = Integer.parseInt(hoursField.getText());
            int minutes = Integer.parseInt(minutesField.getText());
            LocalDate today = LocalDate.now();
            LocalTime timebegin = LocalTime.from(((java.util.Date) timeSpinner.getValue()).toInstant().atZone(java.time.ZoneId.systemDefault()));

            taskController.addTask(description, today, hours, minutes, timebegin); // Aufruf des Controllers
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskApp::new);
    }
}
