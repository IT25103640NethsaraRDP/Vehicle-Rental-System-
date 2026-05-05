# Vehicle Rental System

This is a Spring Boot application for a Vehicle Rental System. Follow these step-by-step instructions to get the application running on your local machine.

## Prerequisites
Before you begin, ensure you have the following installed on your machine:
1. **Java Development Kit (JDK) 17** (or compatible version).
2. **MySQL Server** (Make sure your MySQL server is running).
3. **Maven** (or you can use your IDE's built-in Maven support).
4. An IDE like **IntelliJ IDEA**, **Eclipse**, or **VS Code**.

## Database Setup
The application requires a MySQL database to be created before it can run.

1. Open your MySQL client (like MySQL Workbench, phpMyAdmin, or the command line).
2. Run the following SQL command to create the database:
   ```sql
   CREATE DATABASE IF NOT EXISTS vrs_db;
   ```
3. *Note:* Ensure your MySQL root user credentials are:
    - **Username:** `root`
    - **Password:** `root`

> [!NOTE]
> If your MySQL credentials are different, you will need to update them in the `src/main/resources/application.properties` file under `spring.datasource.username` and `spring.datasource.password`.

## How to Run the Application

You can run this application in a few different ways:

### Option 1: Using your IDE (Recommended)
1. Open your IDE (IntelliJ IDEA, Eclipse, etc.).
2. Select **File > Open** and choose the `Vehicle Rental System` folder.
3. Wait for the IDE to resolve all Maven dependencies (this might take a few minutes the first time).
4. Locate the main application class (usually named `VehicleRentalSystemApplication.java` inside `src/main/java/...`).
5. Right-click the file and select **Run 'VehicleRentalSystemApplication.main()'**.

### Option 2: Using the Command Line
1. Open your terminal or command prompt.
2. Navigate to the root directory of the project (where `pom.xml` is located).
3. Run the following Maven command:
   ```bash
   mvn spring-boot:run
   ```

## Accessing the Site
Once the application starts, you will see a message in the console indicating that Tomcat has started. 
The application runs on port `8081`.

Open your web browser and navigate to:
```
http://localhost:8081/
```

> [!TIP]
> The database tables will be automatically created for you when the application starts up, thanks to Hibernate's auto-update feature.
