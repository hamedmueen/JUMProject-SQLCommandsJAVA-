package com.cognixia.jumo.jdbc.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    default Address selectAddress(int address_id){
        Address address = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * from address where address_id = ?");
            pstmt.setInt(1, address_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Address a = new Address(rs.getInt("address_id"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"));
                        address = a;
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
                Department d = new Department(rs.getInt("dept_id"), rs.getString("dept_name"), rs.getString("cell"),rs.getInt("budget"),rs.getInt("company_id"));
                depts.add(d);
                System.out.println(depts.toString());
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
                Department d = new Department(rs.getInt("dept_id"), rs.getString("dept_name"), rs.getString("cell"), rs.getInt("budget"), rs.getInt("company_id"));
                dept = d;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
    default List<Employee> selectAllFromEmployee(){
        List<Employee> emps = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM employee");

            while (rs.next()) {
                Employee e = new Employee(rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("job_title"),
                        rs.getInt("salary"),
                        rs.getString("dob"),
                        rs.getInt("dept_id"),
                        rs.getInt("address_id"));
                        emps.add(e);
                        System.out.println(e.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }

    default Employee selectEmployee(int emp_id) {
        Employee emp = null;
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * from employee where emp_id = ?");
            pstmt.setInt(1, emp_id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Employee e = new Employee(rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("job_title"),
                        rs.getInt("salary"),
                        rs.getString("dob"),
                        rs.getInt("dept_id"),
                        rs.getInt("address_id"));
                        emp =e;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    default List<Company> selectAllFromCompany(){
        List<Company> comps = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM company");

            while (rs.next()) {
                Company c = new Company(rs.getInt("company_id"),
                        rs.getString("company_name"),
                        rs.getString("headquarters"),
                        rs.getString("industry"),
                        rs.getString("global_strategy"),
                        rs.getString("organizational_culture"),
                        rs.getInt("revenue_in_millions"));
                        comps.add(c);
               
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comps;
    }
    default Company selectCompany(int company_id) {
        Company company = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department WHERE company_id = ?");
            pstmt.setInt(1, company_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Company c = new Company(rs.getInt("company_id"), rs.getString("company_name"),
                        rs.getString("headquarters"), rs.getString("industry"), rs.getString("global_strategy"),
                        rs.getString("organizational_culture"), rs.getInt("budget"));
                company = c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }
    boolean insert(Scanner in);
    boolean delete(Scanner in);
    boolean update(Scanner in);
    boolean createTable() throws SQLException;
}
