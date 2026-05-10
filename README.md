# DriveEase - Vehicle Rental Management System

Welcome to the **DriveEase Vehicle Rental System** repository! 

This project is a comprehensive vehicle rental platform developed for the **SE1020 OOP Project by Team WD62**. It leverages the power of Spring Boot and Java to provide a robust, object-oriented solution for both customers looking to rent vehicles and administrators managing the rental fleet.

## ✨ Key Features

- **Object-Oriented Architecture:** Implements core OOP principles with polymorphic customer models (Premium vs. Regular Customers).
- **Streamlined Booking System:** Intuitive interface for users to browse vehicles and finalize bookings with real-time status tracking.
- **Modern Payments Gateway:** Integrated UI for flexible payment options, including support for **PayZy**, **KOKO Pay**, and classic Card transactions.
- **Admin Management Panel:** A comprehensive backend dashboard for administrators to:
  - Manage the vehicle fleet (add, update, remove cars, vans, lorries).
  - Oversee all customer bookings.
  - Manage staff and employee directories.
  - Monitor and review customer feedback.

## 🛠️ Technology Stack

- **Backend:** Java 17, Spring Boot, Spring Data JPA (Hibernate)
- **Frontend:** JSP (JavaServer Pages), Vanilla Modern CSS, HTML5
- **Database:** MySQL
- **Build Tool:** Maven

---

## 🚀 Getting Started

Follow these step-by-step instructions to set up the DriveEase application on your local machine.

### Prerequisites

1. **Java Development Kit (JDK) 17** (or compatible version).
2. **MySQL Server** (Ensure your server is actively running).
3. **Maven** 
4. Your preferred Java IDE (IntelliJ IDEA, Eclipse, or VS Code).

### Database Setup

1. Open your MySQL client (MySQL Workbench, command line, etc.).
2. Run the following SQL command to create the necessary database schema:
   ```sql
   CREATE DATABASE IF NOT EXISTS vrs_db;
   ```
3. Ensure your MySQL credentials are set to:
    - **Username:** `root`
    - **Password:** `root`

> [!NOTE]
> If your MySQL credentials differ, update them in `src/main/resources/application.properties` under `spring.datasource.username` and `spring.datasource.password`. The system will automatically generate all tables using Hibernate upon initial startup.

### How to Run the Application

#### Option 1: Using an IDE (Recommended)
1. Open your IDE and select **File > Open**, then choose this project folder.
2. Allow the IDE a few moments to resolve all Maven dependencies.
3. Locate the main application class (`VehicleRentalSystemApplication.java`).
4. Run the file directly from your IDE.

#### Option 2: Using the Command Line
1. Open your terminal at the root directory of this project.
2. Run the command:
   ```bash
   mvn spring-boot:run
   ```

## 🌐 Accessing the Site

Once Tomcat successfully starts, the application will be hosted locally on port **8081**. Open your browser and visit:

```
http://localhost:8081/
```

Enjoy managing rentals with DriveEase!
