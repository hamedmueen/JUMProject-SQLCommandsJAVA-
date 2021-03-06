package com.cognixia.jumo.jdbc.connect;

import java.sql.*;
import java.util.Scanner;


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
    public boolean insert(Scanner in) {
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.print("Enter address_id: ");
        int address_id = Integer.parseInt(in.nextLine());
        System.out.println("Enter street: ");
        String street = in.nextLine();
        System.out.println("Enter city: ");
        String city = in.nextLine();
        System.out.println("Enter state: ");
        String state =in.nextLine();
        System.out.println("Enter zip: ");
        String zip = in.nextLine();
        Address address = new Address(address_id, street, city, state, zip);
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO address (address_id, street, city, state, zip)"
                    + " VALUES (?,?,?,?,?)");
            pstmt.setInt(1, address.getId());
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
//        in.close();
        return rows == 1;

    }

    @Override
    public boolean update(Scanner in) {
        // TODO Auto-generated method stub
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.println("Enter address_id: ");
        int address_id = Integer.parseInt(in.nextLine());
        String stringUpdate = null;
        int intUpdate = 0;
        System.out.println("What do you want to update:");
        System.out.println("Enter 1 for address id");
        System.out.println("Enter 2 for street");
        System.out.println("Enter 3 for city");
        System.out.println("Enter 4 for state");
        System.out.println("Enter 5 for zip");
        int select = Integer.parseInt(in.nextLine());
        try {
            switch (select) {
                case 1:
                    System.out.println("Insert new address_id: ");
                    intUpdate = Integer.parseInt(in.nextLine());
                    PreparedStatement pstmt = conn.prepareStatement("UPDATE address SET address_id = ? WHERE address_id = ?");
                    pstmt.setInt(1, intUpdate);
                    pstmt.setInt(2, address_id);
                    rows = pstmt.executeUpdate();
                    pstmt.close();
                    break;
                case 2:
                    System.out.println("Insert new street");
                    stringUpdate = in.nextLine();
                    PreparedStatement pstmt2 = conn.prepareStatement("UPDATE address SET street = ? WHERE address_id = ?");
                    pstmt2.setString(1, stringUpdate);
                    pstmt2.setInt(2, address_id);
                    rows = pstmt2.executeUpdate();
                    pstmt2.close();
                    break;
                case 3:
                    System.out.println("Insert new city");
                    stringUpdate = in.nextLine();
                    PreparedStatement pstmt3 = conn.prepareStatement("UPDATE address SET city = ? WHERE address_id = ?");
                    pstmt3.setString(1, stringUpdate);
                    pstmt3.setInt(2, address_id);
                    rows = pstmt3.executeUpdate();
                    pstmt3.close();
                    break;
                case 4:
                    System.out.println("Insert new state");
                    intUpdate = Integer.parseInt(in.nextLine());
                    PreparedStatement pstmt4 = conn.prepareStatement("UPDATE address SET state = ? WHERE address_id = ?");
                    pstmt4.setString(1, stringUpdate);
                    pstmt4.setInt(2, address_id);
                    rows = pstmt4.executeUpdate();
                    pstmt4.close();
                    break;
                case 5:
                    System.out.println("Insert new zip");
                    intUpdate = Integer.parseInt(in.nextLine());
                    PreparedStatement pstmt5 = conn.prepareStatement("UPDATE address SET zip = ? WHERE address_id = ?");
                    pstmt5.setString(2, stringUpdate);
                    pstmt5.setInt(3, address_id);
                    rows = pstmt5.executeUpdate();
                    pstmt5.close();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        in.close();
        return rows ==1;
    }

    @Override
    public boolean delete(Scanner in) {
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.println("Enter address_id: ");
        int address_id = Integer.parseInt(in.nextLine());
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM address WHERE address_id = ?");
            pstmt.setInt(1,address_id);
            rows = pstmt.executeUpdate();
            pstmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
//        in.close();
        return rows ==1;
    }
}
