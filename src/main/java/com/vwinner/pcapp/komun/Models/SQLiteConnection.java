package com.vwinner.pcapp.komun.Models;

import java.sql.*;

public class SQLiteConnection{
    protected static Connection dbConnector(){
        try {
            Class.forName("org.sqlite.JDBC");
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:data\\data1.sqlite");
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
