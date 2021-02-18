package com.cognixia.jumo.jdbc.connect;

public class Company {
    private int company_id;
    private String company_name;
    private String headquarters;
    private String industry;
    private String global_strategy;
    private String organizational_culture;
    private int revenue_in_millions;

    public Company(int company_id, String company_name, String headquarters, String industry, String global_strategy, String organizational_culture, int revenue_in_millions){
        super();
        this.company_id = company_id;
        this.company_name = company_name;
        this.headquarters = headquarters;
        this.industry = industry;
        this.global_strategy = global_strategy;
        this.organizational_culture = organizational_culture;
        this.revenue_in_millions = revenue_in_millions;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getGlobal_strategy() {
        return global_strategy;
    }

    public void setGlobal_strategy(String global_strategy) {
        this.global_strategy = global_strategy;
    }

    public String getOrganizational_culture() {
        return organizational_culture;
    }

    public void setOrganizational_culture(String organizational_culture) {
        this.organizational_culture = organizational_culture;
    }

    public int getRevenue_in_millions() {
        return revenue_in_millions;
    }

    public void setRevenue_in_millions(int revenue_in_millions) {
        this.revenue_in_millions = revenue_in_millions;
    }

    @Override
    public String toString() {
        return "[Company=;
    }
}
