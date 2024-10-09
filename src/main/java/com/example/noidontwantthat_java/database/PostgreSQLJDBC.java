package com.example.noidontwantthat_java.database;

import java.sql.*;

public class PostgreSQLJDBC {
    private static final String URL = "jdbc:postgresql://localhost:5432/Betreuungskraft";
    private static final String USER = "postgres";
    private static final String PASSWORD = "rootpw";

    String pdfPath = "output.pdf";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void toPdf() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM taetigkeit";
            ResultSet resultSet = statement.executeQuery(query);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
