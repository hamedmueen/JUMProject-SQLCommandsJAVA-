package com.cognixia.jumo.jdbc.connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CompanyDAOClass implements DAO{
    @Override
    public boolean createTable() throws SQLException {
        return false;
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
        return false;
    }
}
