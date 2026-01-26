-- ===========================================
-- Smart Agriculture Management System
-- Database Setup Script
-- Run this in MySQL Workbench or MySQL CLI
-- ===========================================

-- Create Database
CREATE DATABASE IF NOT EXISTS agriculture_system;
USE agriculture_system;

-- Drop existing tables (if any)
DROP TABLE IF EXISTS production;
DROP TABLE IF EXISTS season;
DROP TABLE IF EXISTS crop;
DROP TABLE IF EXISTS farmer;

-- Create Farmer Table
CREATE TABLE farmer (
    farmer_id INT PRIMARY KEY AUTO_INCREMENT,
    farmer_name VARCHAR(100) NOT NULL,
    nic VARCHAR(15) UNIQUE NOT NULL,
    address VARCHAR(255),
    contact_no VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Crop Table
CREATE TABLE crop (
    crop_id INT PRIMARY KEY AUTO_INCREMENT,
    crop_name VARCHAR(50) NOT NULL,
    crop_type VARCHAR(30),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Season Table
CREATE TABLE season (
    season_id INT PRIMARY KEY AUTO_INCREMENT,
    season_name VARCHAR(20) NOT NULL,
    year INT NOT NULL,
    UNIQUE(season_name, year)
);

-- Create Production Table
CREATE TABLE production (
    production_id INT PRIMARY KEY AUTO_INCREMENT,
    farmer_id INT NOT NULL,
    crop_id INT NOT NULL,
    season_id INT NOT NULL,
    quantity DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (farmer_id) REFERENCES farmer(farmer_id) ON DELETE CASCADE,
    FOREIGN KEY (crop_id) REFERENCES crop(crop_id) ON DELETE CASCADE,
    FOREIGN KEY (season_id) REFERENCES season(season_id) ON DELETE CASCADE
);

-- ==========================================
-- Sample Data
-- ==========================================

-- Insert Farmers
INSERT INTO farmer (farmer_name, nic, address, contact_no) VALUES
('Kamal Perera', '901234567V', 'Colombo', '0771234567'),
('Sunil Fernando', '852345678V', 'Kandy', '0772345678'),
('Nimal Silva', '903456789V', 'Galle', '0773456789'),
('Amara Kumari', '884567890V', 'Jaffna', '0774567890'),
('Saman Jayawardena', '925678901V', 'Anuradhapura', '0775678901');

-- Insert Crops
INSERT INTO crop (crop_name, crop_type) VALUES
('Rice', 'Cereal'),
('Maize', 'Cereal'),
('Tomato', 'Vegetable'),
('Chili', 'Vegetable'),
('Potato', 'Vegetable'),
('Banana', 'Fruit'),
('Mango', 'Fruit'),
('Green Gram', 'Pulse'),
('Black Gram', 'Pulse'),
('Cinnamon', 'Spice');

-- Insert Seasons
INSERT INTO season (season_name, year) VALUES
('Yala', 2023),
('Maha', 2023),
('Yala', 2024),
('Maha', 2024),
('Yala', 2025);

-- Insert Production Records
INSERT INTO production (farmer_id, crop_id, season_id, quantity) VALUES
(1, 1, 1, 2500.50),
(1, 2, 1, 1200.00),
(2, 1, 2, 3000.00),
(2, 3, 2, 800.75),
(3, 1, 3, 2800.25),
(3, 4, 3, 600.00),
(4, 5, 3, 1500.00),
(4, 6, 4, 2000.50),
(5, 1, 4, 3500.00),
(5, 7, 4, 1800.00),
(1, 1, 5, 2600.00),
(2, 3, 5, 950.25),
(3, 8, 5, 400.00);

-- Verify Data
SELECT 'Database setup completed successfully!' AS Status;
SELECT COUNT(*) AS FarmerCount FROM farmer;
SELECT COUNT(*) AS CropCount FROM crop;
SELECT COUNT(*) AS SeasonCount FROM season;
SELECT COUNT(*) AS ProductionCount FROM production;
