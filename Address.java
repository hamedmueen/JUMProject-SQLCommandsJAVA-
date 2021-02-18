package com.cognixia.jumo.jdbc.connect;

public class Address {

    private int address_id;
    private String street;
    private String city;
    private String state;
    private String zip;
    public Address(int address_id, String street, String city, String state, String zip) {
        super();
        this.address_id = address_id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    public int getId() {
        return address_id;
    }
    public void setId(int address_id) {
        this.address_id = address_id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    @Override
    public String toString() {
        return "Address [id=" + this.address_id + ", street=" + this.street 
        		+ ", city=" + this.city + ", state=" + this.state + ", zip=" 
        		+ this.zip + "]";
    }
}
