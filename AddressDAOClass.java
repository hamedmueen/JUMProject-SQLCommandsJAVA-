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
                        rs.getString("zip"));
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
       int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter address_id: ");
        int address_id = Integer.parseInt(in.nextLine());
        System.out.println("Enter street: ");
        String street = in.nextLine();
        System.out.println("Enter city: ");
        String city = in.nextLine();
        System.out.println("Enter state: ");
        String state = Integer.parseInt(in.nextLine());
        System.out.println("Enter zip: ");
        String zip = in.nextLine();
        Address address = new Address(address_id, street, city, state, zip);
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO address (address_id, street, city, state, zip)"
                    + " VALUES (?,?,?,?,?)");
            pstmt.setInt(1, address.getAddress_id());
            pstmt.setString(2, address.getStreet());
            pstmt.setString(3, address.getCity());
            pstmt.setString(4, address.getState());
            pstmt.setString(5, address.getZip());
            rows = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        in.close();
        return rows == 1;

    }

    @Override
    public boolean update() {
        // TODO Auto-generated method stub
        int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter dept_id: ");
        int address_id = Integer.parseInt(in.nextLine());
        String stringUpdate = null;
        int intUpdate = 0;
        System.out.println("What do you want to update:");
        int select = Integer.parseInt(in.nextLine());
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE address SET ? = ? WHERE dept_id = ?");
            switch (select) {
                case 1:
                    System.out.println("Insert new address_id: ");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "address_id");
                    pstmt.setInt(2, intUpdate);
                    pstmt.setInt(3, address_id);
                    break;
                case 2:
                    System.out.println("Insert new street");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "street");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, address_id);
                    break;
                case 3:
                    System.out.println("Insert new city");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "city");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, addree_id);
                    break;
                case 4:
                    System.out.println("Insert new state");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "state");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, address_id);
                    break;
                case 5:
                    System.out.println("Insert new zip");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "zip");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, address_id);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            rows = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        in.close();
        return rows ==1;
    }

    @Override
    public boolean delete() {
        int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter address_id: ");
        int address_id = Integer.parseInt(in.nextLine());
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM address WHERE dept_id = ?");
            pstmt.setInt(2,address_id);
            rows = pstmt.executeUpdate();
            pstmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        in.close();
        return rows ==1;
    }

}
