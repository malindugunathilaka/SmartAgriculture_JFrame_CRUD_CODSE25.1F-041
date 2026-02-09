# Smart Agriculture Management System

A Java Swing desktop application for managing agricultural data including farmers, crops, seasons, and production records. Built with NetBeans IDE using JFrame forms.

## Features

- **Dashboard**: Central navigation hub with colorful buttons to access all modules
- **Farmer Management**: Add, edit, delete, and search farmers with contact information
- **Crop Management**: Manage crop types with growing season and price per kg
- **Season Management**: Track agricultural seasons by name and year
- **Production Records**: Record production data linking farmers, crops, and seasons
- **Reports**: Generate summary reports for production analysis

## Screenshots

Each module has a unique color theme:
- 🟢 Dashboard: Forest Green
- 🔵 Farmer Management: Blue
- 🟢 Crop Management: Green
- 🟠 Season Management: Orange
- 🟣 Production Records: Purple
- 🔵 Reports: Teal

## Requirements

- **Java JDK**: Version 8 or higher
- **NetBeans IDE**: Version 8.2 or higher (recommended: NetBeans 12+)
- **MySQL Server**: Version 5.7 or higher
- **MySQL Connector/J**: Version 8.x (JDBC driver)

## Installation & Setup

### Step 1: Set Up MySQL Database

1. Start your MySQL server
2. Open MySQL command line or a tool like MySQL Workbench
3. Run the SQL script located at `sql/database_setup.sql`:

```sql
source /path/to/SmartAgricultureNetBeans/sql/database_setup.sql
```

This will create:
- Database: `smart_agriculture`
- Tables: `farmers`, `crops`, `seasons`, `productions`
- Sample data for testing

### Step 2: Configure Database Connection

1. Open `src/com/agriculture/dao/DatabaseConnection.java`
2. Update line 19 with your MySQL password:

```java
private static final String PASSWORD = "your_mysql_password_here";
```

If your MySQL uses different settings, also update:
- `URL` (line 17) - for different host/port
- `USER` (line 18) - for different username

### Step 3: Add MySQL JDBC Driver

1. Download MySQL Connector/J from: https://dev.mysql.com/downloads/connector/j/
2. In NetBeans, right-click the project → Properties
3. Go to Libraries → Add JAR/Folder
4. Select the downloaded `mysql-connector-java-8.x.x.jar`

### Step 4: Open and Run

1. Open NetBeans IDE
2. File → Open Project → Select `SmartAgricultureNetBeans` folder
3. Right-click project → Run
4. Or run `DashboardForm.java` directly

## Project Structure

```
SmartAgricultureNetBeans/
├── src/com/agriculture/
│   ├── dao/                    # Data Access Objects
│   │   ├── DatabaseConnection.java
│   │   ├── FarmerDAO.java
│   │   ├── CropDAO.java
│   │   ├── SeasonDAO.java
│   │   └── ProductionDAO.java
│   ├── model/                  # Entity Classes
│   │   ├── Farmer.java
│   │   ├── Crop.java
│   │   ├── Season.java
│   │   └── Production.java
│   └── ui/                     # JFrame Forms
│       ├── DashboardForm.java/.form
│       ├── FarmerForm.java/.form
│       ├── CropForm.java/.form
│       ├── SeasonForm.java/.form
│       ├── ProductionForm.java/.form
│       └── ReportForm.java/.form
├── sql/
│   └── database_setup.sql      # Database setup script
├── lib/                        # Add JDBC driver here
├── nbproject/                  # NetBeans configuration
├── build.xml                   # Ant build file
└── README.md
```

## Usage Guide

### Dashboard
- Click any colored button to open the corresponding management form
- Close individual forms to return to the dashboard

### Managing Records (Farmer, Crop, Season)
1. **Add**: Fill in the fields and click "Add"
2. **Edit**: Select a row in the table, modify fields, click "Update"
3. **Delete**: Select a row and click "Delete"
4. **Search**: Enter a name and click "Search" (click "Clear" to reset)

### Production Records
1. Select a Farmer, Crop, and Season from the dropdown menus
2. Enter the quantity in kilograms
3. Click "Add" to save the record
4. Use "Refresh Combos" if you've added new farmers/crops/seasons

### Reports
- **Farmer-Crop Summary**: Total production by each farmer for each crop
- **Season Production**: Total production aggregated by season
- **Crop Analysis**: Statistics per crop (total qty, average, farmer count)
- **All Productions**: Complete list of all production records

## Troubleshooting

### "No suitable driver found"
- Ensure MySQL Connector/J JAR is added to project libraries
- Verify the JAR file is not corrupted

### "Access denied for user"
- Check username and password in `DatabaseConnection.java`
- Ensure the MySQL user has permissions for the database

### "Unknown database 'smart_agriculture'"
- Run the `database_setup.sql` script first
- Check MySQL is running and accessible

### "Communications link failure"
- Verify MySQL server is running
- Check the host and port in the connection URL
- Ensure no firewall is blocking the connection

## Database Schema

### farmers
| Column | Type | Description |
|--------|------|-------------|
| id | INT | Primary Key |
| name | VARCHAR(100) | Farmer's name |
| address | VARCHAR(255) | Address |
| phone | VARCHAR(20) | Phone number |

### crops
| Column | Type | Description |
|--------|------|-------------|
| id | INT | Primary Key |
| name | VARCHAR(100) | Crop name |
| growing_season | VARCHAR(50) | When it grows |
| price_per_kg | DECIMAL(10,2) | Price per kg |

### seasons
| Column | Type | Description |
|--------|------|-------------|
| id | INT | Primary Key |
| season_name | VARCHAR(50) | Season name |
| year | INT | Year |

### productions
| Column | Type | Description |
|--------|------|-------------|
| id | INT | Primary Key |
| farmer_id | INT | Foreign Key → farmers |
| crop_id | INT | Foreign Key → crops |
| season_id | INT | Foreign Key → seasons |
| quantity | DECIMAL(10,2) | Quantity in kg |

## Technologies Used

- Java SE 8+
- Swing (JFrame, JTable, JComboBox, etc.)
- JDBC for database connectivity
- MySQL database
- NetBeans IDE with Matisse GUI Builder
- Nimbus Look and Feel

## License

This project is provided for educational purposes.

## Author

Created as part of an agricultural management system project.
