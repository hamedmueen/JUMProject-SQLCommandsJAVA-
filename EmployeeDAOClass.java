package com.cognixia.jumo.jdbc.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOClass implements EmployeeDAO {

    Connection conn = ConnectionManager.getConnection();


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM department");

            while (rs.next()) {
                Employee e = new Employee(rs.getInt("emp_id"), rs.getString("emp_name"), rs.getString("job_title"),rs.getInt("salary"),rs.getDate("dob"),rs.getInt("dept_id"),rs.getInt("address_id"));
                emps.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public Department getEmployees(int id) {
        Department department = null;
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * from address where emp_id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                department= new Department(rs.getInt("dept_id"),rs.getString("dept_name"),rs.getString("cell"),rs.getInt("budget"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public boolean addEmployees(Department department) {
        return false;
    }

    @Override
    public boolean deleteEmployees(int id) {
        return false;
    }

    @Override
    public boolean updateEmployees(Department department) {
        return false;
    }
}
