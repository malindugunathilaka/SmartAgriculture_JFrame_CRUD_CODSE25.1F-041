# 🌾 Smart Agriculture Management System
## Java JFrame/Swing Desktop Application with NetBeans

---

## ✅ PROJECT TYPE CONFIRMATION

| Item | Value |
|------|-------|
| **UI Technology** | Java Swing (JFrame) |
| **Project Type** | Java SE Desktop Application |
| **IDE** | Apache NetBeans 12+ |
| **JDK** | Java 11+ |
| **Database** | MySQL 8.0 |
| **Pattern** | DAO + Singleton |

---

## 📁 PROJECT STRUCTURE

```
SmartAgricultureSystem_NetBeans/
├── src/
│   └── com/agriculture/
│       ├── ui/                        ← JFrame Forms (.java + .form)
│       │   ├── DashboardForm.java     ← Main Entry Point
│       │   ├── DashboardForm.form     ← GUI Builder XML
│       │   ├── FarmerForm.java
│       │   ├── FarmerForm.form
│       │   ├── CropForm.java
│       │   ├── CropForm.form
│       │   ├── SeasonForm.java
│       │   ├── SeasonForm.form
│       │   ├── ProductionForm.java
│       │   ├── ProductionForm.form
│       │   ├── ReportForm.java
│       │   └── ReportForm.form
│       ├── dao/                       ← Data Access Objects
│       │   ├── DatabaseConnection.java
│       │   ├── FarmerDAO.java
│       │   ├── CropDAO.java
│       │   ├── SeasonDAO.java
│       │   └── ProductionDAO.java
│       └── model/                     ← Entity Classes
│           ├── Farmer.java
│           ├── Crop.java
│           ├── Season.java
│           └── Production.java
├── sql/
│   └── database_setup.sql            ← Run this first!
├── lib/                              ← Put JAR files here
│   └── (mysql-connector-java-8.x.jar)
├── nbproject/
│   ├── project.xml
│   └── project.properties
├── build.xml
└── README.md
```

---

## 🚀 SETUP INSTRUCTIONS

### Step 1: Setup MySQL Database

```sql
-- Run in MySQL Workbench:
SOURCE path/to/sql/database_setup.sql;

-- Or open and execute: sql/database_setup.sql
```

### Step 2: Update Database Password

Open: `src/com/agriculture/dao/DatabaseConnection.java`

```java
// Line 14 - Change this:
private static final String PASSWORD = "";  // Your MySQL password
```

### Step 3: Add MySQL Connector JAR

1. Download: `mysql-connector-java-8.0.33.jar`
   - From: https://dev.mysql.com/downloads/connector/j/
2. Place in: `lib/` folder

### Step 4: Open in NetBeans

```
1. Open NetBeans IDE
2. File → Open Project
3. Select "SmartAgricultureSystem_NetBeans" folder
4. Click Open Project
```

### Step 5: Add Library in NetBeans

```
1. Right-click "Libraries" in project
2. Click "Add JAR/Folder"
3. Select mysql-connector-java-8.x.jar
4. Click Open
```

### Step 6: Run the Project

```
1. Right-click: DashboardForm.java
2. Click: Run File
   OR press: Shift + F6
```

---

## 🖥️ FORMS INCLUDED (All with .form files)

| Form | File | Purpose |
|------|------|---------|
| Dashboard | DashboardForm.java/.form | Main menu |
| Farmer | FarmerForm.java/.form | Farmer CRUD |
| Crop | CropForm.java/.form | Crop CRUD |
| Season | SeasonForm.java/.form | Season CRUD |
| Production | ProductionForm.java/.form | Production entries |
| Report | ReportForm.java/.form | Generate reports |

---

## 🔧 TROUBLESHOOTING

| Error | Solution |
|-------|----------|
| `ClassNotFoundException: Driver` | Add mysql-connector JAR |
| `Access denied` | Update PASSWORD in DatabaseConnection.java |
| `Unknown database` | Run sql/database_setup.sql first |
| Form not opening in Design | Ensure .form file exists |

---

## 📋 FEATURES

- ✅ Farmer Management (CRUD)
- ✅ Crop Management (CRUD)
- ✅ Season Management (Yala/Maha)
- ✅ Production Entry with ComboBox
- ✅ Reports with JTable popup
- ✅ NetBeans GUI Builder compatible

---

**Author:** Smart Agriculture System  
**Version:** 1.0  
**Java:** 11+  
**NetBeans:** 12+
