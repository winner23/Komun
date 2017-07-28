package com.vwinner.pcapp.komun.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBService {
    private Connection connection;

    public DBService(){
        connection = SQLiteConnection.dbConnector();
    }

    public ResultSet qReqest(String query){

        ResultSet rs;
        try {
            PreparedStatement pst = null;
            if (connection != null) {
                pst = connection.prepareStatement(query);
                rs = pst.executeQuery();
                return rs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getServices(){
        String query = "SELECT * FROM services";
        return qReqest(query);
    }
}
