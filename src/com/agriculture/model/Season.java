package com.agriculture.model;

public class Season {
    private int seasonId;
    private String seasonName;
    private int year;

    public Season() {}

    public Season(String seasonName, int year) {
        this.seasonName = seasonName;
        this.year = year;
    }

    public Season(int seasonId, String seasonName, int year) {
        this.seasonId = seasonId;
        this.seasonName = seasonName;
        this.year = year;
    }

    public int getSeasonId() { return seasonId; }
    public void setSeasonId(int seasonId) { this.seasonId = seasonId; }
    public String getSeasonName() { return seasonName; }
    public void setSeasonName(String seasonName) { this.seasonName = seasonName; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    
    @Override
    public String toString() {
        return seasonId + " - " + seasonName + " " + year;
    }
}
