package com.cognixia.jumo.jdbc.connect;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDAOClass implements DAO {

    Connection conn = ConnectionManager.getConnection();

    @Override
    public boolean createTable() throws SQLException {
        Statement stmt = conn.createStatement();
        boolean count = stmt.execute("CREATE TABLE employee(" +
                "emp_id INT PRIMARY KEY NOT NULL," +
                " emp_name VARCHAR(40) NOT NULL," +
                " job_title VARCHAR(20) NOT NULL," +
                " salary INT NOT NULL," +
                " dob VARCHAR(10) NOT NULL," +
                " dept_id INT NOT NULL, " +
                " address_id INT NOT NULL, " +
                " FOREIGN KEY (dept_id) REFERENCES department(dept_id)," +
                " FOREIGN KEY (address_id) REFERENCES address(address_id))");
        return count;
    }

    @Override
    public boolean insert(Scanner in) {
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.print("Enter emp_id: ");
        int emp_id = Integer.parseInt(in.nextLine());
        System.out.println("Enter emp_name: ");
        String emp_name = in.nextLine();
        System.out.println("Enter job_title: ");
        String job_title = in.nextLine();
        System.out.println("Enter salary: ");
        int salary = Integer.parseInt(in.nextLine());
        System.out.println("Enter dob: ");
        String dob = in.nextLine();
        System.out.println("Enter dept_id: ");
        int dept_id = Integer.parseInt(in.nextLine());
        System.out.println("Enter address_id: ");
        int address_id = Integer.parseInt(in.nextLine());
        Employee employee = new Employee(emp_id,emp_name,job_title, salary, dob, dept_id,address_id);
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employee (emp_id, company_name, headquarters, "
                    + " industry, global_strategy, organizational_culture, revenue_in_millions)"
                    + " VALUES (?,?,?,?,?,?,?)");
            pstmt.setInt(1, employee.getEmpId());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3, employee.getJobTitle());
            pstmt.setInt(4, employee.getSalary());
            pstmt.setString(5, employee.getDob());
            pstmt.setInt(6,employee.getDeptId());
            pstmt.setInt(7,employee.getAddId());
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
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.println("Enter emp_id: ");
        int emp_id = Integer.parseInt(in.nextLine());
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM employee WHERE emp_id = ?");
            pstmt.setInt(2,emp_id);
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
        System.out.println("Enter emp_id: ");
        int emp_id = Integer.parseInt(in.nextLine());
        String stringUpdate = null;
        int intUpdate = 0;
        System.out.println("What do you want to update: ");
        int select = Integer.parseInt(in.nextLine());
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE employee SET ? = ? WHERE emp_id = ?");
            switch (select) {
                case 1:
                    System.out.println("Insert new emp_id: ");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "emp_id");
                    pstmt.setInt(2, intUpdate);
                    pstmt.setInt(3, emp_id);
                    break;
                case 2:
                    System.out.println("Insert new emp_name: ");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "emp_name");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, emp_id);
                    break;
                case 3:
                    System.out.println("Insert new job_title");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "job_title");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, emp_id);
                    break;
                case 4:
                    System.out.println("Insert new salary");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "salary");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, emp_id);
                    break;
                case 5:
                    System.out.println("Insert new dob");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "dob");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, emp_id);
                    break;
                case 6:
                    System.out.println("Insert new dept_id");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "dept_id");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, emp_id);
                    break;
                case 7:
                    System.out.println("Insert new address_id");
                    pstmt.setString(1, "address_id");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, emp_id);
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
//        in.close();
        return rows ==1;
    }
}
