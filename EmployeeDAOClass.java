package com.cognixia.jumo.jdbc.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                " dob date NOT NULL," +
                " FOREIGN KEY (dept_id) REFERENCES department(dept_id)," +
                " FOREIGN KEY (address_id) REFERENCES address(address_id))");
        return count;
    }

    @Override
    public List<Employee> selectAllFromEmployee() {
        List<Employee> emps = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM employee");

            while (rs.next()) {
                Employee e = new Employee(rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("job_title"),
                        rs.getInt("salary"),
                        rs.getDate("dob"),
                        rs.getInt("dept_id"),
                        rs.getInt("address_id"));
                emps.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public Employee selectEmployee() {
        Department department = null;
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * from employee where emp_id = ?");
            //pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                department= new Department(rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("job_title"),
                        rs.getInt("salary"));
                        rs.getDate("dob"),
                        rs.getInt("dept_id"),
                        rs.getInt("address_id"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert() {
        return false;
    }

    @Override
    public boolean delete() {
        int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter emp_id: ");
        int address_id = Integer.parseInt(in.nextLine());
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM employee WHERE emp_id = ?");
            pstmt.setInt(2,emp_id);
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

    @Override
    public boolean update() {
        // TODO Auto-generated method stub
        int rows = 0;
        Scanner in = new Scanner(System.in);
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
                    pstmt.setInt(1, "salary");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, emp_id);
                    break;
                case 5:
                    System.out.println("Insert new dob");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "zip");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, emp_id);
                    break;
                case 6:
                    System.out.println("Insert new dept_id");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setInt(1, "dept_id");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, emp_id);
                    break;
                case 7:
                    System.out.println("Insert new address_id)
                    pstmt.setInt(1, "address_id");
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
        in.close();
        return rows ==1;
    }
}
