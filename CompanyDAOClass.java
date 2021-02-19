package com.cognixia.jumo.jdbc.connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CompanyDAOClass implements DAO{
    @Override
    public boolean createTable() throws SQLException {
        Statement stmt = conn.createStatement();
        boolean count = stmt.execute("CREATE TABLE company(" +
                " company_id INT PRIMARY KEY NOT NULL, " +
                " company_name VARCHAR(20) NOT NULL, " +
                " headquarters VARCHAR(25) NOT NULL, " +
                " industry VARCHAR(15) NOT NULL, " +
                " global_strategy  VARCHAR(25) NOT NULL, " +
                " organizational_culture VARCHAR(25) NOT NULL, " +
                " revenue_in_millions INT NOT NULL)");
        return count;
    }

    @Override
    public boolean insert(Scanner in) {
        int rows = 0;
//        Scanner in = new Scanner(System.in);
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
//        in.close();
        return rows == 1;

    };

    @Override
    public boolean delete(Scanner in) {
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.println("Enter company_id");
        int company_id = Integer.parseInt(in.nextLine());
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM company WHERE company_id = ?");
            pstmt.setInt(1, company_id);
            rows = pstmt.executeUpdate();
            pstmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
//        in.close();
        return rows ==1;
    }

    @Override
    public boolean update(Scanner in) {
        int rows = 0;
//        Scanner in = new Scanner(System.in);
        System.out.println("Enter company_id: ");
        int company_id = Integer.parseInt(in.nextLine());
        String stringUpdate = null;
        int intUpdate = 0;
        System.out.println("What do you want to update:");
        System.out.println("Enter 1 for company_id");
        System.out.println("Enter 2 for company_name");
        System.out.println("Enter 3 for headquarters");
        System.out.println("Enter 4 for industry");
        System.out.println("Enter 5 for global strategy");
        System.out.println("Enter 6 for organizational culture");
        System.out.println("Enter 7 for revenue in millions");
        int select = Integer.parseInt(in.nextLine());
        try {
            switch (select) {
                case 1:
                    System.out.println("Insert new company_id: ");
                    intUpdate = Integer.parseInt(in.nextLine());
                    PreparedStatement pstmt = conn.prepareStatement("UPDATE company SET company_id = ? WHERE company_id = ?");
                    pstmt.setInt(1, intUpdate);
                    pstmt.setInt(2, company_id);
                    rows = pstmt.executeUpdate();
                    pstmt.close();
                    break;
                case 2:
                    System.out.println("Insert new company_name");
                    stringUpdate = in.nextLine();
                    PreparedStatement pstmt2 = conn.prepareStatement("UPDATE company SET company_name = ? WHERE company_id = ?");
                    pstmt2.setString(1, stringUpdate);
                    pstmt2.setInt(2, company_id);
                    rows = pstmt2.executeUpdate();
                    pstmt2.close();
                    break;
                case 3:
                    System.out.println("Insert new headquarters");
                    stringUpdate = in.nextLine();
                    PreparedStatement pstmt3 = conn.prepareStatement("UPDATE company SET headquarters = ? WHERE company_id = ?");
                    pstmt3.setString(1, stringUpdate);
                    pstmt3.setInt(2, company_id);
                    rows = pstmt3.executeUpdate();
                    pstmt3.close();
                    break;
                case 4:
                    System.out.println("Insert new industry");
                    stringUpdate = in.nextLine();
                    PreparedStatement pstmt4 = conn.prepareStatement("UPDATE company SET industry = ? WHERE company_id = ?");
                    pstmt4.setString(1, stringUpdate);
                    pstmt4.setInt(2, company_id);
                    rows = pstmt4.executeUpdate();
                    pstmt4.close();
                    break;
                case 5:
                    System.out.println("Insert new global_strategy");
                    stringUpdate = in.nextLine();
                    PreparedStatement pstmt5 = conn.prepareStatement("UPDATE company SET global_strategy = ? WHERE company_id = ?");
                    pstmt5.setString(1, stringUpdate);
                    pstmt5.setInt(2, company_id);
                    rows = pstmt5.executeUpdate();
                    pstmt5.close();
                    break;
                case 6:
                    System.out.println("Insert new organizational_culture");
                    stringUpdate = in.nextLine();
                    PreparedStatement pstmt6 = conn.prepareStatement("UPDATE company SET organizational_culture = ? WHERE company_id = ?");
                    pstmt6.setString(1, stringUpdate);
                    pstmt6.setInt(2, company_id);
                    rows = pstmt6.executeUpdate();
                    pstmt6.close();
                    break;
                case 7:
                    System.out.println("Insert new revenue_in_millions");
                    intUpdate = Integer.parseInt(in.nextLine());
                    PreparedStatement pstmt7 = conn.prepareStatement("UPDATE company SET revenue_in_millions = ? WHERE company_id = ?");
                    pstmt7.setInt(1, intUpdate);
                    pstmt7.setInt(2, company_id);
                    rows = pstmt7.executeUpdate();
                    pstmt7.close();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        in.close();
        return rows ==1;
    }
}
