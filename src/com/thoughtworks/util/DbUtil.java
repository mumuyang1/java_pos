package com.thoughtworks.util;

import java.sql.*;

public class DbUtil {

    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/pet";
    private String user = "root";
    private String password = "lyz123";

    private Connection conn = null;

    public Connection getConnection(){
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
