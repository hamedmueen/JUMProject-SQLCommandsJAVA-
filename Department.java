package com.cognixia.jumo.jdbc.connect;

public class Department {

    private String dept_name;
    private String cell;
    private int budget;
    private int dept_id;

    public Department(int dept_id,String dept_name, String cell, int budget) {
        super();
        this.dept_name = dept_name;
        this.dept_id = dept_id;
        this.cell = cell;
        this.budget = budget;
    }

    public String getName() {
        return dept_name;
    }

    public void setName(String name) {
        this.dept_name = dept_name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDeptID(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString(){
        return this.dept_name + " " + this.cell + " " + this.budget + " ";
    }
}
