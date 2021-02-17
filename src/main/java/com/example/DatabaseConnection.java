package com.example;

import java.sql.*;

public class DatabaseConnection {
    public DatabaseConnection() throws SQLException {}

    String URL = "jdbc:postgresql://localhost:5432/Customer";
    String USERNAME = "postgres";
    String PASSWORD = "qweasz11";
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public void myInit() throws SQLException {
        System.out.println("Doing my initialization");
        System.out.println("Connecting to the database");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "SELECT * FROM \"Users\"";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
    }
    public void myDestroy() throws SQLException {
        System.out.println("Doing my destruction");
        System.out.println("Closing the database");
        connection.close();
    }
    public void updateBalance(int balance, String name) throws SQLException {
        String sql = "UPDATE \"Users\"" +
                "SET user_balance = " + balance +
                "WHERE user_name = '" + name + "';";
        int r = statement.executeUpdate(sql);
        if (r > 0) {
            System.out.println("Balance updated");
        } else {
            System.out.println("Balance is not updated");
        }
    }
    public ResultSet getResultSet() {
        return resultSet;
    }

    public static DatabaseConnection getDatabaseConnection() throws SQLException {
        return new DatabaseConnection();
    }
}
