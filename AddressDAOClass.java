package com.cognixia.jumo.jdbc.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressDAOClass implements AddressDAO{

    Connection conn = ConnectionManager.getConnection();

    @Override
    public List<Address> getAllAddresses() {
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
    public Address getAddress(int id) {
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
    public boolean addAddress(Address address) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateAddress(Address address) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteAddress(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}

