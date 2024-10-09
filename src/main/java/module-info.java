module com.example.noidontwantthat_java {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;
    requires jdatepicker;

    opens com.example.noidontwantthat_java to javafx.fxml;
    exports com.example.noidontwantthat_java;
    exports com.example.noidontwantthat_java.model;
    opens com.example.noidontwantthat_java.model to javafx.fxml;
    exports com.example.noidontwantthat_java.controller;
    opens com.example.noidontwantthat_java.controller to javafx.fxml;
}