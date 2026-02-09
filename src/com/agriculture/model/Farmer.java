package com.agriculture.model;

import java.sql.Timestamp;

public class Farmer {
    private int farmerId;
    private String farmerName;
    private String nic;
    private String address;
    private String contactNo;
    private Timestamp createdAt;

    public Farmer() {}

    public Farmer(String farmerName, String nic, String address, String contactNo) {
        this.farmerName = farmerName;
        this.nic = nic;
        this.address = address;
        this.contactNo = contactNo;
    }

    public Farmer(int farmerId, String farmerName, String nic, String address, String contactNo, Timestamp createdAt) {
        this.farmerId = farmerId;
        this.farmerName = farmerName;
        this.nic = nic;
        this.address = address;
        this.contactNo = contactNo;
        this.createdAt = createdAt;
    }

    public int getFarmerId() { return farmerId; }
    public void setFarmerId(int farmerId) { this.farmerId = farmerId; }
    public String getFarmerName() { return farmerName; }
    public void setFarmerName(String farmerName) { this.farmerName = farmerName; }
    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    
    @Override
    public String toString() {
        return farmerId + " - " + farmerName;
    }
}
