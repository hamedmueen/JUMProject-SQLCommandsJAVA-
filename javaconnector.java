package com.cognixia.jumo.jdbc.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class javaconnector {
    private static final String URLUnix = "jdbc:mysql://database-1.cysgoj3prnni.us-west-1.rds.amazonaws.com:3306/university?serverTimeZone=EST5EDT";
    private static final String USERNAME = "JUMP";
    private static final String PASSWORD = "thiisit";


    public static Connection getConnection(){

        Connection conn = null;

        try{
            conn = DriverManager.getConnection(URLUnix,USERNAME, PASSWORD);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
