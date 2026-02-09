package com.agriculture.model;

import java.sql.Timestamp;

public class Crop {
    private int cropId;
    private String cropName;
    private String cropType;
    private Timestamp createdAt;

    public Crop() {}

    public Crop(String cropName, String cropType) {
        this.cropName = cropName;
        this.cropType = cropType;
    }

    public Crop(int cropId, String cropName, String cropType) {
        this.cropId = cropId;
        this.cropName = cropName;
        this.cropType = cropType;
    }

    public int getCropId() { return cropId; }
    public void setCropId(int cropId) { this.cropId = cropId; }
    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }
    public String getCropType() { return cropType; }
    public void setCropType(String cropType) { this.cropType = cropType; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    
    @Override
    public String toString() {
        return cropId + " - " + cropName;
    }
}
