package com.htperez.conection;


import java.sql.*;

public class Database
{
    public String conection(String username, String password) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/login";
        String user = "hector_perez";
        String pass = "julian";
        String message = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users WHERE username LIKE '" + username + "'";
            ResultSet resultSet = statement.executeQuery(query);

            // Procesar los resultados
            if (resultSet.next()){
                String passwor = resultSet.getString("password");
                if (passwor.equals(password)){
                    message =  "Login successful! Welcome to your account " + username + ".";
                } else {
                    message = "The password is incorrect, try again.";
                }
            } else {
                message = "The user don't exist";
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

}
