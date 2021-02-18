package com.cognixia.jumo.jdbc.connect;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Department getEmployees(int id);
    boolean addEmployees(Department department);
    boolean deleteEmployees(int id);
    boolean updateEmployees(Department department);
}
