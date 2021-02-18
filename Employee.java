package com.cognixia.jumo.jdbc.connect;

import java.util.Date;

public class Employee {

    private int emp_id;
    private String emp_name;
    private String job_title;
    private int salary;
    private Date dob;
    private int dept_id;
    private int address_id;


    public Employee(int emp_id, String emp_name, String job_title, int salary, Date dob, int dept_id, int address_id) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.job_title = job_title;
        this.salary = salary;
        this.dob = dob;
        this.dept_id = dept_id;
        this.address_id = address_id;
    }

    public int getEmpId() {
        return emp_id;
    }

    public String getName() {
        return emp_name;
    }

    public void setName(String name) {
        this.emp_name = emp_name;
    }

    public String getJobTitle() {
        return job_title;
    }

    public void setJobTitle(String jobTitle) {
        this.job_title = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmpId(int empId) {
        this.emp_id = empId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getDeptId() {
        return dept_id;
    }

    public void setDeptId(int deptId) {
        this.dept_id = dept_id;
    }

    public int getAddId() {
        return address_id;
    }

    public void setAddId(int addId) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return emp_id + " " + this.emp_name + " " + this.job_title + " " + this.salary + " " + this.dob + " " + this.dept_id;
    }
}