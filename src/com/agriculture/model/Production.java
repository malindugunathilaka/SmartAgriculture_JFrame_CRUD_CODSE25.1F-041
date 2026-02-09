package com.agriculture.model;

public class Production {
    private int productionId;
    private int farmerId;
    private int cropId;
    private int seasonId;
    private double quantity;
    private String farmerName;
    private String cropName;
    private String seasonName;

    public Production() {}

    public Production(int farmerId, int cropId, int seasonId, double quantity) {
        this.farmerId = farmerId;
        this.cropId = cropId;
        this.seasonId = seasonId;
        this.quantity = quantity;
    }

    public int getProductionId() { return productionId; }
    public void setProductionId(int productionId) { this.productionId = productionId; }
    public int getFarmerId() { return farmerId; }
    public void setFarmerId(int farmerId) { this.farmerId = farmerId; }
    public int getCropId() { return cropId; }
    public void setCropId(int cropId) { this.cropId = cropId; }
    public int getSeasonId() { return seasonId; }
    public void setSeasonId(int seasonId) { this.seasonId = seasonId; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
    public String getFarmerName() { return farmerName; }
    public void setFarmerName(String farmerName) { this.farmerName = farmerName; }
    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }
    public String getSeasonName() { return seasonName; }
    public void setSeasonName(String seasonName) { this.seasonName = seasonName; }
}
