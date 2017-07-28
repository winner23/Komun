package com.vwinner.pcapp.komun.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBService {
    private Connection connection;

    public ResultSet qReqest(String query){
        connection = SQLiteConnection.dbConnector();
        ResultSet rs;
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            rs = pst.executeQuery();
            return rs;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getServices(){
        connection = SQLiteConnection.dbConnector();
        PreparedStatement pst;
        ResultSet rs;

        try{
            String query = "SELECT * FROM services";
            pst = connection.prepareStatement(query);
            rs = pst.executeQuery();
            return rs;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
