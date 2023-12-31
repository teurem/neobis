package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionJDBC {
    private static final String URL = "jdbc:postgresql://localhost:5432/CarsShop";
    private static final String login = "postgres";
    private static final String password = "pASSWORD123";

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded sucsesful;");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection;

        try {
            connection = DriverManager.getConnection(URL, login, password);

            if (!connection.isClosed()) {
                System.out.println("Correct connection to db!");
            }

            connection.close();

            if (connection.isClosed()) {
                System.out.println("ConnectionJDBC closed: (");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
