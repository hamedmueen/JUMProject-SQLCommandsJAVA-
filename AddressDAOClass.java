package com.cognixia.jumo.jdbc.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressDAOClass implements DAO{

    Connection conn = ConnectionManager.getConnection();

    @Override
    public boolean createTable() throws SQLException {
        Statement stmt = conn.createStatement();
        boolean count = stmt.execute("CREATE TABLE address(" +
                " address_id INT PRIMARY KEY NOT NULL," +
                " street VARCHAR(50) NOT NULL," +
                " city VARCHAR(20) NOT NULL," +
                " state VARCHAR(20) NOT NULL," +
                " zip VARCHAR(15) NOT NULL)");
        return count;
    }

    @Override
    public List<Address> selectAllFromAddress() {
        Connection conn = ConnectionManager.getConnection();
       List<Address> ads = new ArrayList<>();
       try{
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM address");

           while(rs.next()){
               Address a = new Address(rs.getInt("address_id"),rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("zip"));
               ads.add(a);
           }
       }
       catch(SQLException e){
           e.printStackTrace();
       }
       return ads;
    }

    @Override
    public Address selectAddress(int id) {
        Address address = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * from address where address_id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                address = new Address(rs.getInt("address_id"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip_code"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public boolean insert() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        return false;
    }

}
