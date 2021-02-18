package com.cognixia.jumo.jdbc.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DepartmentDAOClass implements DAO {

    Connection conn = ConnectionManager.getConnection();

    @Override
    public boolean createTable() throws SQLException{
        Statement stmt = conn.createStatement();
        boolean count = stmt.execute("CREATE TABLE department(" +
                " dept_id INT PRIMARY KEY NOT NULL, " +
                " dept_name VARCHAR(20) NOT NULL, " +
                " cell VARCHAR(15) NOT NULL, " +
                " budget INT NOT NULL, " + 
                " FOREIGN KEY (company_id) REFERENCES company(company_id))");
        return count;
    }

    @Override
    public Department selectDepartment(int dept_id) {
        Department dept = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department WHERE dept_id = ?");
            pstmt.setInt(1, dept_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Department d = new Department(rs.getInt("dept_id"), rs.getString("dept_name"), rs.getString("cell"), rs.getInt("budget"), rs.getInt("company_id");
                dept = d;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }

    @Override
    public boolean insert() {
        int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter dept_id: ");
        int dept_id = Integer.parseInt(in.nextLine());
        System.out.println("Enter dept_name: ");
        String dept_name = in.nextLine();
        System.out.println("Enter cell: ");
        String cell = in.nextLine();
        System.out.println("Enter budget: ");
        int budget = Integer.parseInt(in.nextLine());
        System.out.println("Enter Company ID: ");
        int company_id = Integer.parseInt(in.nextLine());
        Department department = new Department(dept_id,dept_name,cell,budget);
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO department (dept_id, dept_name, cell, budget, company_id)"
                    + " VALUES (?,?,?,?,?)");
            pstmt.setInt(1, department.getDept_id());
            pstmt.setString(2, department.getName());
            pstmt.setString(3,department.getCell());
            pstmt.setInt(4,department.getBudget());
            pstmt.setInt(5,company_id);
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
    public boolean delete() {
        // TODO Auto-generated method stub
        int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter dept_id");
        int dept_id = Integer.parseInt(in.nextLine());
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM department WHERE dept_id = ?");
            pstmt.setInt(2,dept_id);
            rows = pstmt.executeUpdate();
            pstmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        in.close();
        return rows ==1;
    }

    @Override
    public boolean update() {
        // TODO Auto-generated method stub
        int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter dept_id: ");
        int dept_id = Integer.parseInt(in.nextLine());
        String stringUpdate = null;
        int intUpdate = 0;
        System.out.println("What do you want to update:");
        int select = Integer.parseInt(in.nextLine());
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE department SET ? = ? WHERE dept_id = ?");
            switch (select) {
                case 1:
                    System.out.println("Insert new dept_id: ");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "dept_id");
                    pstmt.setInt(2, intUpdate);
                    pstmt.setInt(3, dept_id);
                    break;
                case 2:
                    System.out.println("Insert new dept_name");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "dept_name");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, dept_id);
                    break;
                case 3:
                    System.out.println("Insert new cell");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "cell");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, dept_id);
                    break;
                case 4:
                    System.out.println("Insert new budget");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "budget");
                    pstmt.setInt(2, intUpdate);
                    pstmt.setInt(3, dept_id);
                    break;
                case 5:
                    System.out.println("Insert new Company Id");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "company_id");
                    pstmt.setInt(2, intUpdate);
                    pstmt.setInt(3, dept_id);
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
}
