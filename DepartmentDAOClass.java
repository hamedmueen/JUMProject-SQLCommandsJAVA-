package com.cognixia.jumo.jdbc.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyDAOClass implements DAO{
    @Override
    public boolean createTable() throws SQLException {
        Statement stmt = conn.createStatement();
        boolean count = stmt.execute("CREATE TABLE company(" +
                " company_id INT PRIMARY KEY NOT NULL, " +
                " company_name VARCHAR(20) NOT NULL, " +
                " headquarters VARCHAR(25) NOT NULL, " +
                " industy VARCHAR(15) NOT NULL, " +
                " global_strategy  VARCHAR(25) NOT NULL, " +
                " organizational_culture VARCHAR(25) NOT NULL, " +
                " revenue_in_millions INT NOT NULL)");
        return count;
    }

    @Override
    public boolean insert() {
        int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter company id: ");
        int company_id = Integer.parseInt(in.nextLine());
        System.out.println("Enter company name: ");
        String company_name = in.nextLine();
        System.out.println("Enter headquarters: ");
        String headquarters = in.nextLine();
        System.out.println("Enter industry: ");
        String industry = in.nextLine();
        System.out.println("Enter global strategy: ");
        String global_strategy = in.nextLine();
        System.out.println("Enter Organizational Culture: ");
        String org_culture = in.nextLine();
        System.out.println("Enter revenue_in_millions: ");
        int revenue = Integer.parseInt(in.nextLine());
        Company company = new Company(company_id,company_name,headquarters,industry, global_strategy,
                org_culture, revenue);
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO company (company_id, company_name, headquarters, "
                    + " industry, global_strategy, organizational_culture, revenue_in_millions)"
                    + " VALUES (?,?,?,?,?,?,?)");
            pstmt.setInt(1, company.getCompany_id());
            pstmt.setString(2, company.getCompany_name());
            pstmt.setString(3,company.getHeadquarters());
            pstmt.setString(4,company.getIndustry());
            pstmt.setString(5, company.getGlobal_strategy());
            pstmt.setString(6,company.getOrganizational_culture());
            pstmt.setInt(7,company.getRevenue_in_millions());
            rows = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        in.close();
        return rows == 1;

    };

    @Override
    public boolean delete() {
        int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter company_id");
        int company_id = Integer.parseInt(in.nextLine());
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM company WHERE company_id = ?");
            pstmt.setInt(2, company_id);
            rows = pstmt.executeUpdate();
            pstmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        in.close();
        return rows ==1;
    }

    @Override
    public boolean update() {
        int rows = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter company_id: ");
        int company_id = Integer.parseInt(in.nextLine());
        String stringUpdate = null;
        int intUpdate = 0;
        System.out.println("What do you want to update:");
        int select = Integer.parseInt(in.nextLine());
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE company SET ? = ? WHERE company_id = ?");
            switch (select) {
                case 1:
                    System.out.println("Insert new company_id: ");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "company_id");
                    pstmt.setInt(2, intUpdate);
                    pstmt.setInt(3, company_id);
                    break;
                case 2:
                    System.out.println("Insert new company_name");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "company_name");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, company_id);
                    break;
                case 3:
                    System.out.println("Insert new headquarters");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "headquarters");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, company_id);
                    break;
                case 4:
                    System.out.println("Insert new industry");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "industry");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, company_id);
                    break;
                case 5:
                    System.out.println("Insert new global_strategy");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "global_strategy");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, company_id);
                    break;
                case 6:
                    System.out.println("Insert new organizational_culture");
                    stringUpdate = in.nextLine();
                    pstmt.setString(1, "organizational_culture");
                    pstmt.setString(2, stringUpdate);
                    pstmt.setInt(3, company_id);
                    break;
                case 7:
                    System.out.println("Insert new revenue_in_millions");
                    intUpdate = Integer.parseInt(in.nextLine());
                    pstmt.setString(1, "revenue_in_millions");
                    pstmt.setInt(2, intUpdate);
                    pstmt.setInt(3, company_id);
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
