package com.cognixia.jumo.jdbc.connect;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner extends ConnectionManager{
	
	public static void main(String[] args) throws SQLException {
		
    	Scanner scan = new Scanner(System.in);
    	Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Enter username: ");
            user = scan.nextLine();
            System.out.println("Enter password: ");
            password = scan.nextLine();
            if (!password.equals("thisisit") && user.equals("JUMP")) {
                System.out.println("Invalid password.");
            } else {
                break;
            }
        }
//    	DepartmentDAOClass dao1 = new DepartmentDAOClass();
//    	dao1.createTable();
//
//    	EmployeeDAOClass dao2 = new EmployeeDAOClass();
//    	dao2.createTable();
    	
    	boolean exitLoop = true;
    	
		while(exitLoop) {
			
			
	    	System.out.println("Which of the following would you like to access?"
	    			+ "\nAddresses\t- 1"
	    			+ "\nCompanies\t- 2"
	    			+ "\nDepartments\t- 3"
	    			+ "\nEmployees\t- 4"
	    			+ "\nQuit\t\t- 5");
	    	
	    	int selection = Integer.parseInt(scan.nextLine());
	    	
	    	switch(selection) {
			case 1:
				System.out.println("Addresses were selected.");
				accessAddresses(scan);
				break;
			case 2:
				System.out.println("Companies were selected.");
				accessCompanies(scan);
				break;
			case 3:
				System.out.println("Departments were selected.");
				accessDepartments(scan);
				break;
			case 4:
				System.out.println("Employees were selected.");
				accessEmployees(scan);
				break;
			case 5:
				System.out.println("Exiting system...");
				exitLoop = false;
				break;
			default:
				System.out.println("An error has occurred, try again.");
				break;
	    	}
	    	
	    	
		}
    	scan.close();
    }
	
	private static void accessAddresses(Scanner scan) {

		AddressDAOClass addDAO = new AddressDAOClass();
		
		boolean exitLoopDept = true;
    	
    	while(exitLoopDept) {

        	System.out.println("What would you like to do with the addresses?"
        			+ "\nSelect an address table\t- 1"
        			+ "\nSelect all from address\t- 2"
        			+ "\nInsert an address\t- 3"
        			+ "\nDelete an address\t- 4"
        			+ "\nUpdate an address\t- 5"
        			+ "\nReturn to main menu\t- 6");

        	int select = Integer.parseInt(scan.nextLine());

        	switch(select) {
	    		case 1:
	    			System.out.println("Selecting an address was selected."
	    					+ "\nEnter an address_id to select the desired address.");

	    	    	int desiredID = Integer.parseInt(scan.nextLine());
	    	    	
	    			System.out.println(addDAO.selectAddress(desiredID));
	    			break;
	    		case 2:
	    			System.out.println("Selecting all addresses was selected.");
	    			System.out.println(addDAO.selectAllFromAddress());
	    			break;
	    		case 3:
	    			System.out.println("Inserting an address was selected.");
	    			addDAO.insert(scan);
	    			break;
	    		case 4:
	    			System.out.println("Deleting an address was selected.");
	    			addDAO.delete(scan);
	    			break;
	    		case 5:
	    			System.out.println("Updating an address was selected.");
	    			addDAO.update(scan);
	    			break;
	    		case 6:
	    			System.out.println("Returning to main menu...");
	    			exitLoopDept = false;
	    			break;
	    		default:
	    			System.out.println("An error has occurred, returning to main menu.");
	    			exitLoopDept = false;
	    			break;
        	}
    	}
		
	}
	
	private static void accessCompanies(Scanner scan) {
		
		CompanyDAOClass comDAO = new CompanyDAOClass();
		
		boolean exitLoopDept = true;
    	
    	
    	while(exitLoopDept) {
    		
        	System.out.println("What would you like to do with the companies?"
        			+ "\nSelect a company table\t- 1"
        			+ "\nSelect all from company\t- 2"
        			+ "\nInsert a company\t- 3"
        			+ "\nDelete a company\t- 4"
        			+ "\nUpdate a company\t- 5"
        			+ "\nReturn to main menu\t- 6");

        	int select = Integer.parseInt(scan.nextLine());

			
        	switch(select) {
	    		case 1:
	    			System.out.println("Selecting a company was selected."
	    					+ "\nEnter a company_id to select the desired company.");

	    	    	int desiredID = Integer.parseInt(scan.nextLine());
	    			System.out.println(comDAO.selectCompany(desiredID));
	    			
	    			break;
	    		case 2:
	    			System.out.println("Selecting all companies was selected.");
	    			comDAO.selectAllFromCompany();
	    			break;
	    		case 3:
	    			System.out.println("Inserting a company was selected.");
	    			comDAO.insert(scan);
	    			break;
	    		case 4:
	    			System.out.println("Deleting a company was selected.");
	    			comDAO.delete(scan);
	    			break;
	    		case 5:
	    			System.out.println("Updating a company was selected.");
	    			comDAO.update(scan);
	    			break;
	    		case 6:
	    			System.out.println("Returning to main menu...");
	    			exitLoopDept = false;
	    			break;
	    		default:
	    			System.out.println("An error has occurred, returning to main menu.");
	    			exitLoopDept = false;
	    			break;
        	}
    	}
		
	}
	
	
	private static void accessDepartments(Scanner scan) throws SQLException {
		
		DepartmentDAOClass deptDAO = new DepartmentDAOClass();
		boolean exitLoopDept = true;
    	
    	
    	while(exitLoopDept) {

    		
        	System.out.println("What would you like to do with the departments?"
        			+ "\nSelect a department table\t- 1"
        			+ "\nSelect all from department\t- 2"
        			+ "\nInsert a department\t- 3"
        			+ "\nDelete a department\t- 4"
        			+ "\nUpdate a department\t- 5"
        			+ "\nReturn to main menu\t- 6");

        	int select = Integer.parseInt(scan.nextLine());

			
        	switch(select) {
	    		case 1:
	    			System.out.println("Selecting a department was selected."
	    					+ "\nEnter a dept_id to select the desired department.");
	    			
	    	    	int desiredID = Integer.parseInt(scan.nextLine());
	    			System.out.println(deptDAO.selectDepartment(desiredID));
	    			
	    			break;
	    		case 2:
	    			System.out.println("Selecting all departments was selected.");
	    			deptDAO.selectAllFromDepartment();
	    			break;
	    		case 3:
	    			System.out.println("Inserting a department was selected.");
	    			deptDAO.insert(scan);
	    			break;
	    		case 4:
	    			System.out.println("Deleting a department was selected.");
	    			deptDAO.delete(scan);
	    			break;
	    		case 5:
	    			System.out.println("Updating a department was selected.");
	    			deptDAO.update(scan);
	    			break;
	    		case 6:
	    			System.out.println("Returning to main menu...");
	    			exitLoopDept = false;
	    			break;
	    		default:
	    			System.out.println("An error has occurred, returning to main menu.");
	    			exitLoopDept = false;
	    			break;
        	}
    	}
	}
	
	private static void accessEmployees(Scanner scan) {
		
		EmployeeDAOClass empDAO = new EmployeeDAOClass();
		
		boolean exitLoopDept = true;
    	
    	while(exitLoopDept) {

    		
        	System.out.println("What would you like to do with the employees?"
        			+ "\nSelect an employee table\t- 1"
        			+ "\nSelect all employees\t- 2"
        			+ "\nInsert an employee\t- 3"
        			+ "\nDelete an employee\t- 4"
        			+ "\nUpdate an employee\t- 5"
        			+ "\nReturn to main menu\t- 6");

        	int select = Integer.parseInt(scan.nextLine());

        	switch(select) {
	    		case 1:
	    			System.out.println("Selecting an employee was selected."
	    					+ "\nEnter a emp_id to select the desired employee.");
	    	    	int desiredID = Integer.parseInt(scan.nextLine());
	    	    	
	    			System.out.println(empDAO.selectEmployee(desiredID));
	    			break;
	    		case 2:
	    			System.out.println("Selecting all employees was selected.");
	    			empDAO.selectAllFromEmployee();
	    			break;
	    		case 3:
	    			System.out.println("Inserting an employee was selected.");
	    			empDAO.insert(scan);
	    			break;
	    		case 4:
	    			System.out.println("Deleting an employee was selected.");
	    			empDAO.delete(scan);
	    			break;
	    		case 5:
	    			System.out.println("Updating an employee was selected.");
	    			empDAO.update(scan);
	    			break;
	    		case 6:
	    			System.out.println("Returning to main menu...");
	    			exitLoopDept = false;
	    			break;
	    		default:
	    			System.out.println("An error has occurred, returning to main menu.");
	    			exitLoopDept = false;
	    			break;
        	}
    	}
	}

}
