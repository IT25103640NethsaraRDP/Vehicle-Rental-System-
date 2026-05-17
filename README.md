## 📖 About The Project

**DriveEase** is a comprehensive vehicle rental platform that provides a robust solution for both customers looking to rent vehicles and administrators managing the rental fleet. 

The application is heavily built on **Core Object-Oriented Programming (OOP) principles** such as Inheritance, Polymorphism, and Abstraction to elegantly solve complex business logic (e.g., differentiating between regular and premium customers, or customer reviews vs. internal admin notes).

## ✨ Key Features

- **Object-Oriented Architecture (Polymorphism & Inheritance):** 
  - **Dynamic User Models:** Distinct handling of `PremiumCustomer` and `RegularCustomer`.
  - **Polymorphic Reviews System:** Unified database table using JPA single-table inheritance to store both public `CustomerFeedback` and private `InternalAdminNotes`.
  - **Vehicle Types:** Base `Vehicle` class extended by `Car`, `Bike`, and `Lorry` with dynamic pricing models.
- **Custom Admin Authentication:** A secure, custom-built `AuthInterceptor` and login system mapping to a manual `AppUser` registry, ensuring administrative endpoints are tightly secured.
- **Modern Payments Gateway:** Integrated UI for flexible payment options, including support for **PayZy**, **KOKO Pay**, and Cash/Card transactions.
- **Comprehensive Admin Dashboard:** Manage the vehicle fleet, oversee customer bookings, handle polymorphic reviews, and manage the employee directory (Managers, Office Staff, Field Staff).

## 🛠️ Technology Stack

- **Backend:** Java 17, Spring Boot, Spring Web, Spring Data JPA (Hibernate)
- **Frontend:** JSP (JavaServer Pages), JSTL, Vanilla Modern CSS, HTML5
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

> **Note:** If your MySQL credentials differ, update them in `src/main/resources/application.properties` under `spring.datasource.username` and `spring.datasource.password`. The system will automatically generate all tables using Hibernate upon initial startup.

### How to Run the Application

#### Option 1: Using an IDE (Recommended)
1. Clone the repository and open your IDE.
2. Select **File > Open**, then choose this project folder.
3. Allow the IDE a few moments to resolve all Maven dependencies.
4. Locate the main application class (`VehicleRentalSystemApplication.java`).
5. Run the file directly from your IDE.

#### Option 2: Using the Command Line
1. Open your terminal at the root directory of this project.
2. Run the command:
   ```bash
   mvn spring-boot:run
   ```

## 🌐 Accessing the Site

Once the embedded Tomcat server successfully starts, the application will be hosted locally on port **8081**. Open your browser and visit:

```
http://localhost:8081/
```

*(Note: To access the Admin Dashboard, navigate to `/login` and use the pre-configured administrator credentials stored in your database).*

---

## 📊 System Architecture

The codebase includes an extensive Class-Responsibility-Collaboration (CRC) analysis and a comprehensive **UML Class Diagram** (`UML_Diagram.html`) demonstrating the relationships between `Booking`, `Payment`, `Review`, `Employee`, `Vehicle`, and `Customer` classes.

## 🤝 Contributors

Developed for **SE1020 OOP Project** by **Team WD62**.
