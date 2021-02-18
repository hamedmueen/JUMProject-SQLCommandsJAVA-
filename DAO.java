package com.cognixia.jumo.jdbc.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface DAO {
    Connection conn = ConnectionManager.getConnection();
    default List<Address> selectAllFromAddress(){
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
    };
    default Address selectAddress(int id){
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
    default List<Department> selectAllFromDepartment(){
        List<Department> depts = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM department");

            while (rs.next()) {
                Department d = new Department(rs.getInt("dept_id"), rs.getString("dept_name"), rs.getString("cell"),rs.getInt("budget"));
                depts.add(d);
                System.out.println(d.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
    };
    default Department selectDepartment(int dept_id){
        Department dept = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department WHERE dept_id = ?");
            pstmt.setInt(1, dept_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Department d = new Department(rs.getInt("dept_id"),
                        rs.getString("dept_name"),
                        rs.getString("cell"),
                        rs.getInt("budget"));
                dept = d;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
    default List<Employee> selectAllFromEmployee(){
        List<Employee> e = new ArrayList();
        return e;
    }
    default Employee selectEmployee(){
        return new Employee(0,null,null,0, null,0,0);
    }
    default List<Company> selectAllFromCompany(){
        List<Company> c = new ArrayList();
        return c;
    }
    default Company selectCompany(int company_id){ return new Company(0,null,null,null,null,null,0);}
    boolean insert();
    boolean delete();
    boolean update();
    boolean createTable() throws SQLException;
}
