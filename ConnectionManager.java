package com.cognixia.jumo.jdbc.connect;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionManager {

    private static Connection conn = null;

    public static void makeConnection() {

        Properties props = new Properties();
        try{
            props.load(new FileInputStream("./resources/config.properties"));

            String url = props.getProperty("url");
            String user = props.getProperty("username");
            String password = props.getProperty("password");

            conn = DriverManager.getConnection(url, user, password);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        if(conn == null){
            makeConnection();
        }
        return conn;
    }

    public static void closeConnection() throws SQLException{
        if(conn != null){
            conn.close();
            conn =null;
        }
    }
}
   // public static void state() {
   //     Connection conn = javaconnector.getConnection();
    //    try {
    //        Statement stmt = conn.createStatement();
    //        int count = stmt.executeUpdate("UPDATE student SET credits = 90 WHERE student_id =10000");
     //       System.out.println("Modified Rows: " + count);
     //       ResultSet rs = stmt.executeQuery("SELECT * from student");
//
     //       while (rs.next()) {
     //           System.out.println("Name: " + rs.getString("first_name") + " " + rs.getString("last_name") + " Age: ");
    //        }
    //    } catch (SQLException e) {
    //        e.printStackTrace();
   //     }
  //  }
