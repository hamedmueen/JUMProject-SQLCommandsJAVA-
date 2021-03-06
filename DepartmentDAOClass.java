package com.cognixia.jumo.jdbc.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                        " company_id INT NOT NULL, " +
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
                Department d = new Department(rs.getInt("dept_id"), rs.getString("dept_name"), rs.getString("cell"), rs.getInt("budget"), rs.getInt("company_id"));
                dept = d;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }


    @Override
    public boolean insert(Scanner in) {
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.print("Enter dept_id: ");
        int dept_id = Integer.parseInt(in.nextLine());
        System.out.println("Enter dept_name: ");
        String dept_name = in.nextLine();
        System.out.println("Enter cell: ");
        String cell = in.nextLine();
        System.out.println("Enter budget: ");
        int budget = Integer.parseInt(in.nextLine());
        System.out.println("Enter Company_id: ");
        int company_id = Integer.parseInt(in.nextLine());
        Department department = new Department(dept_id,dept_name,cell,budget,company_id);
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
//        in.close();
        return rows == 1;

    }

    @Override
    public boolean delete(Scanner in) {
        // TODO Auto-generated method stub
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.println("Enter dept_id");
        int dept_id = Integer.parseInt(in.nextLine());
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM department WHERE dept_id = ?");
            pstmt.setInt(1,dept_id);
            rows = pstmt.executeUpdate();
            pstmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
//        in.close();
        return rows ==1;
    }

    @Override
    public boolean update(Scanner in) {
        // TODO Auto-generated method stub
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.println("Enter dept_id: ");
        int dept_id = Integer.parseInt(in.nextLine());
        String stringUpdate = null;
        int intUpdate = 0;
        System.out.println("What do you want to update:");
        System.out.println("Enter 1 for dept_id");
        System.out.println("Enter 2 for dept_name");
        System.out.println("Enter 3 for cell");
        System.out.println("Enter 4 for budget");
        int select = Integer.parseInt(in.nextLine());
        try {

            switch (select) {
                case 1:
                    System.out.println("Insert new dept_id: ");
                    intUpdate = Integer.parseInt(in.nextLine());
                    PreparedStatement pstmt = conn.prepareStatement("UPDATE department SET dept_id = ? WHERE dept_id = ?");
                    pstmt.setInt(1, intUpdate);
                    pstmt.setInt(2, dept_id);
                    rows = pstmt.executeUpdate();
                    pstmt.close();
                    break;
                case 2:
                    System.out.println("Insert new dept_name");
                    stringUpdate = in.nextLine();
                    PreparedStatement pstmt2 = conn.prepareStatement("UPDATE department SET dept_name = ? WHERE dept_id = ?");
                    pstmt2.setString(1, stringUpdate);
                    pstmt2.setInt(2, dept_id);
                    rows = pstmt2.executeUpdate();
                    pstmt2.close();
                    break;
                case 3:
                    System.out.println("Insert new cell");
                    stringUpdate = in.nextLine();
                    PreparedStatement pstmt3 = conn.prepareStatement("UPDATE department SET cell = ? WHERE dept_id = ?");
                    pstmt3.setString(1, stringUpdate);
                    pstmt3.setInt(2, dept_id);
                    rows = pstmt3.executeUpdate();
                    pstmt3.close();
                    break;
                case 4:
                    System.out.println("Insert new budget");
                    intUpdate = Integer.parseInt(in.nextLine());
                    PreparedStatement pstmt4 = conn.prepareStatement("UPDATE department SET budget = ? WHERE dept_id = ?");
                    pstmt4.setInt(1, intUpdate);
                    pstmt4.setInt(2, dept_id);
                    rows = pstmt4.executeUpdate();
                    pstmt4.close();
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
}
