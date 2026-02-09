-- ============================================================
-- Smart Agriculture System - Database Setup Script
-- ============================================================
-- Run this script in MySQL Workbench or MySQL Command Line
-- to create the database and required tables.
-- ============================================================

-- Create Database
DROP DATABASE IF EXISTS smart_agriculture;
CREATE DATABASE smart_agriculture;
USE smart_agriculture;

-- ============================================================
-- Table: farmers
-- ============================================================
CREATE TABLE farmers (
    farmer_id INT AUTO_INCREMENT PRIMARY KEY,
    farmer_name VARCHAR(100) NOT NULL,
    nic VARCHAR(15) NOT NULL UNIQUE,
    address VARCHAR(255),
    contact_no VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- ============================================================
-- Table: crops
-- ============================================================
CREATE TABLE crops (
    crop_id INT AUTO_INCREMENT PRIMARY KEY,
    crop_name VARCHAR(100) NOT NULL,
    crop_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- ============================================================
-- Table: seasons
-- ============================================================
CREATE TABLE seasons (
    season_id INT AUTO_INCREMENT PRIMARY KEY,
    season_name VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    UNIQUE KEY unique_season_year (season_name, year)
) ENGINE=InnoDB;

-- ============================================================
-- Table: productions
-- ============================================================
CREATE TABLE productions (
    production_id INT AUTO_INCREMENT PRIMARY KEY,
    farmer_id INT NOT NULL,
    crop_id INT NOT NULL,
    season_id INT NOT NULL,
    quantity DOUBLE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (farmer_id) REFERENCES farmers(farmer_id) ON DELETE RESTRICT,
    FOREIGN KEY (crop_id) REFERENCES crops(crop_id) ON DELETE RESTRICT,
    FOREIGN KEY (season_id) REFERENCES seasons(season_id) ON DELETE RESTRICT
) ENGINE=InnoDB;

-- ============================================================
-- Sample Data (Optional - Uncomment to insert)
-- ============================================================

-- Insert sample farmers
INSERT INTO farmers (farmer_name, nic, address, contact_no) VALUES
('Kamal Perera', '198512345678', 'No. 45, Main Street, Colombo', '0771234567'),
('Nimal Silva', '199087654321', 'No. 123, Temple Road, Kandy', '0772345678'),
('Sunil Fernando', '197512345V', 'No. 78, Lake View, Galle', '0773456789'),
('Kumara Bandara', '198256789012', 'No. 56, Hill Side, Matara', '0774567890'),
('Saman Wickrama', '199123456789', 'No. 89, Beach Road, Negombo', '0775678901');

-- Insert sample crops
INSERT INTO crops (crop_name, crop_type) VALUES
('Rice (Samba)', 'Cereal'),
('Rice (Nadu)', 'Cereal'),
('Maize', 'Cereal'),
('Tomato', 'Vegetable'),
('Carrot', 'Vegetable'),
('Potato', 'Vegetable'),
('Banana', 'Fruit'),
('Papaya', 'Fruit'),
('Green Gram', 'Pulse'),
('Black Pepper', 'Spice');

-- Insert sample seasons
INSERT INTO seasons (season_name, year) VALUES
('Yala', 2024),
('Maha', 2024),
('Yala', 2025),
('Maha', 2025);

-- Insert sample production records
INSERT INTO productions (farmer_id, crop_id, season_id, quantity) VALUES
(1, 1, 1, 2500.50),
(1, 4, 1, 500.00),
(2, 1, 1, 3200.75),
(2, 2, 2, 2800.00),
(3, 3, 1, 1500.25),
(3, 5, 2, 800.00),
(4, 7, 1, 1200.00),
(4, 8, 2, 950.50),
(5, 9, 1, 600.00),
(5, 10, 2, 150.75);

-- ============================================================
-- Verification Queries
-- ============================================================
-- Run these to verify the setup:

-- SELECT * FROM farmers;
-- SELECT * FROM crops;
-- SELECT * FROM seasons;
-- SELECT * FROM productions;

-- ============================================================
-- Production Summary View (Optional)
-- ============================================================
CREATE OR REPLACE VIEW production_summary AS
SELECT 
    p.production_id,
    f.farmer_name,
    c.crop_name,
    c.crop_type,
    CONCAT(s.season_name, ' ', s.year) AS season,
    p.quantity,
    p.created_at
FROM productions p
JOIN farmers f ON p.farmer_id = f.farmer_id
JOIN crops c ON p.crop_id = c.crop_id
JOIN seasons s ON p.season_id = s.season_id
ORDER BY p.created_at DESC;

-- SELECT * FROM production_summary;

-- ============================================================
-- End of Setup Script
-- ============================================================
SELECT 'Database setup completed successfully!' AS Status;
