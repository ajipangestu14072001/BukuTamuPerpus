package com.example.bukutamuperpustakaan.network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        final String URL = "jdbc:mysql://103.55.39.181:3306/bktmmyid_bukutamuperpus";
        final String USER = "bktmmyid_bukutamuperpus";
        final String PASSWORD = "bukutamuperpus";

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}