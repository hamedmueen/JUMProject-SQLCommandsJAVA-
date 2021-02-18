package com.cognixia.jumo.jdbc.connect;

import java.util.List;

public interface DepartmentDAO {
    List<Department> getAllDepartments();
    Department getDepartment(int id);
    boolean addDepartment();
    boolean deleteDepartment();
    boolean updateDepartment();

}
