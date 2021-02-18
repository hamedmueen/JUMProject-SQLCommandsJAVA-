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
            ResultSet rs = stmt.executeQuery("Select * FROM department");

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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * from address where emp_id = ?");
            //pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                department= new Department(rs.getInt("dept_id"),
                        rs.getString("dept_name"),
                        rs.getString("cell"),
                        rs.getInt("budget"));
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
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
