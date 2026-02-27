# 🚗 Vehicle Rental System

**SE1020 — Object Oriented Programming | Group Project**

A dual-portal web-based vehicle rental management system built with Java Spring Boot, Thymeleaf, and Bootstrap 5.

**Two Separate Portals:**

- 🔧 **Admin Dashboard** (`/admin/*`) - For staff & administrators to manage all operations
- 👤 **Customer Portal** (`/user/*`) - For customers to browse vehicles and manage their bookings

---

## 👥 Team Members & Components

| Member            | Component                         | Branch                        |
| ----------------- | --------------------------------- | ----------------------------- |
| Member 1          | Vehicle Management                | `feature/vehicle-management`  |
| Member 2          | Customer Management               | `feature/customer-management` |
| Member 3 (Leader) | Booking Management + Architecture | `feature/booking-management`  |
| Member 4          | Payment Management                | `feature/payment-management`  |
| Member 5          | Employee Management               | `feature/employee-management` |
| Member 6          | Feedback & Review Management      | `feature/feedback-management` |

---

## 🛠 Tech Stack

- **Backend:** Java 21, Spring Boot 3.2
- **Frontend:** HTML5, Thymeleaf, Bootstrap 5.3
- **Data Storage:** File I/O (.txt files)
- **Build Tool:** Maven
- **Version Control:** Git / GitHub
- **IDE:** Visual Studio Code / IntelliJ IDEA

---

## 📁 Project Structure - Dual Portal System

```
Vehicle-Rental-System-/
├── src/
│   ├── main/
│   │   ├── java/com/vehiclerental/
│   │   │   ├── VehicleRentalApplication.java        ← App entry point
│   │   │   ├── model/
│   │   │   │   └── BaseEntity.java                  ← Abstract parent class
│   │   │   ├── service/
│   │   │   │   └── BaseFileService.java             ← Abstract file service
│   │   │   └── controller/
│   │   │       ├── HomeController.java              ← Routes: /, /admin/dashboard, /user/dashboard
│   │   │       ├── admin/                           ← 🔧 ADMIN CONTROLLERS (Staff Only)
│   │   │       │   ├── AdminVehicleController.java  ← /admin/vehicles/*
│   │   │       │   ├── AdminCustomerController.java ← /admin/customers/*
│   │   │       │   ├── AdminBookingController.java  ← /admin/bookings/*
│   │   │       │   ├── AdminPaymentController.java  ← /admin/payments/*
│   │   │       │   ├── AdminEmployeeController.java ← /admin/employees/*
│   │   │       │   └── AdminReviewController.java   ← /admin/reviews/*
│   │   │       └── user/                            ← 👤 USER/CUSTOMER CONTROLLERS
│   │   │           ├── UserVehicleController.java   ← /user/vehicles/* (Browse)
│   │   │           ├── UserBookingController.java   ← /user/bookings/* (Self-service)
│   │   │           ├── UserPaymentController.java   ← /user/payments/* (History & Invoices)
│   │   │           ├── UserReviewController.java    ← /user/reviews/* (Leave Reviews)
│   │   │           └── UserProfileController.java   ← /user/profile/* (Account)
│   │   └── resources/
│   │       ├── application.properties               ← App configuration
│   │       ├── templates/
│   │       │   ├── index.html                       ← Portal selection home page
│   │       │   ├── fragments/navbar.html            ← Shared navbar component
│   │       │   ├── admin/                           ← 🔧 ADMIN TEMPLATES
│   │       │   │   ├── dashboard.html               ← /admin/dashboard
│   │       │   │   ├── vehicles/
│   │       │   │   │   ├── list.html                ← /admin/vehicles
│   │       │   │   │   ├── add.html                 ← /admin/vehicles/add
│   │       │   │   │   └── edit.html                ← /admin/vehicles/edit
│   │       │   │   ├── customers/
│   │       │   │   │   ├── list.html
│   │       │   │   │   ├── add.html
│   │       │   │   │   └── edit.html
│   │       │   │   ├── bookings/
│   │       │   │   │   ├── list.html
│   │       │   │   │   ├── add.html
│   │       │   │   │   └── edit.html
│   │       │   │   ├── payments/
│   │       │   │   │   ├── list.html
│   │       │   │   │   ├── add.html
│   │       │   │   │   └── edit.html
│   │       │   │   ├── employees/
│   │       │   │   │   ├── list.html
│   │       │   │   │   ├── add.html
│   │       │   │   │   └── edit.html
│   │       │   │   └── reviews/
│   │       │   │       ├── list.html
│   │       │   │       ├── add.html
│   │       │   │       └── edit.html
│   │       │   └── user/                            ← 👤 CUSTOMER TEMPLATES
│   │       │       ├── dashboard.html               ← /user/dashboard
│   │       │       ├── vehicles/
│   │       │       │   ├── browse.html              ← /user/vehicles
│   │       │       │   └── details.html             ← /user/vehicles/details
│   │       │       ├── bookings/
│   │       │       │   ├── my-bookings.html         ← /user/bookings
│   │       │       │   ├── new.html                 ← /user/bookings/new
│   │       │       │   ├── details.html             ← /user/bookings/details
│   │       │       │   └── cancel.html              ← /user/bookings/cancel
│   │       │       ├── payments/
│   │       │       │   ├── history.html             ← /user/payments
│   │       │       │   ├── invoices.html            ← /user/payments/invoices
│   │       │       │   └── make-payment.html        ← /user/payments/make-payment
│   │       │       ├── reviews/
│   │       │       │   ├── my-reviews.html          ← /user/reviews
│   │       │       │   └── leave.html               ← /user/reviews/leave
│   │       │       └── profile/
│   │       │           ├── view.html                ← /user/profile
│   │       │           ├── edit.html                ← /user/profile/edit
│   │       │           └── settings.html            ← /user/profile/settings
│   │       └── static/css/
│   │           └── style.css                        ← Global CSS styles
│   └── test/
│       └── java/com/vehiclerental/                  ← Unit tests
├── data/                                            ← Data storage files
│   ├── vehicles.txt
│   ├── customers.txt
│   ├── bookings.txt
│   ├── payments.txt
│   ├── employees.txt
│   └── reviews.txt
├── pom.xml                                          ← Maven dependencies & config
└── README.md                                        ← This file
```

---

## 🔄 Portal Overview

### 🔧 Admin Dashboard (`/admin/*`)

**Access Level:** Staff & Administrators Only

**Purpose:** Complete management of all business operations.

**Key Features:**

- **Vehicle Management:** Add, edit, view all vehicles in the fleet
- **Customer Management:** Register and manage customer profiles
- **Booking Management:** Create and modify rental bookings for customers
- **Payment Tracking:** Record and monitor all payments
- **Employee Directory:** Manage staff and employee information
- **Review Management:** Monitor and moderate customer feedback

**Navbar Color:** Dark (indicating staff/admin area)

**Sample URLs:**

- `/admin/dashboard` - Main dashboard
- `/admin/vehicles` - List all vehicles
- `/admin/customers/add` - Register new customer
- `/admin/bookings` - View all bookings
- `/admin/payments` - Payment records
- `/admin/employees` - Staff directory
- `/admin/reviews` - Customer reviews

---

### 👤 Customer Portal (`/user/*`)

**Access Level:** Customers & End Users

**Purpose:** Self-service booking and account management.

**Key Features:**

- **Browse Vehicles:** Search and view available vehicles for rent
- **Make Bookings:** Create and manage personal rental reservations
- **Payment Management:** View payment history and download invoices
- **Leave Reviews:** Submit feedback and ratings on rentals
- **Account Management:** Update profile and adjust account settings

**Navbar Color:** Primary/Blue (indicating customer area)

**Sample URLs:**

- `/user/dashboard` - Customer dashboard
- `/user/vehicles` - Browse available vehicles
- `/user/vehicles/details` - View vehicle details
- `/user/bookings` - My rental bookings
- `/user/bookings/new` - Create new booking
- `/user/payments` - Payment history
- `/user/reviews/leave` - Submit a review
- `/user/profile` - My account profile

---

## 🚀 Getting Started - Step by Step Setup Guide

### Step 1: Prerequisites

Install the following on your device before cloning the repository:

#### **1.1 Java Development Kit (JDK) 21**

- **macOS:**

  ```bash
  # Using Homebrew
  brew install java21

  # Verify installation
  java -version
  ```

- **Windows:**
  - Download from [oracle.com/java](https://www.oracle.com/java/technologies/downloads/#java21)
  - Install and add `JAVA_HOME` environment variable
  - Verify: Open Command Prompt and run `java -version`

- **Linux:**
  ```bash
  sudo apt update
  sudo apt install openjdk-21-jdk
  java -version
  ```

#### **1.2 Maven**

- **macOS:**

  ```bash
  brew install maven
  mvn -version
  ```

- **Windows:**
  - Download from [maven.apache.org](https://maven.apache.org/download.cgi)
  - Extract to a folder (e.g., `C:\Maven`)
  - Add to PATH environment variable
  - Verify: `mvn -version`

- **Linux:**
  ```bash
  sudo apt install maven
  mvn -version
  ```

#### **1.3 Git**

- Download from [git-scm.com](https://git-scm.com/) or use:

  ```bash
  # macOS
  brew install git

  # Linux
  sudo apt install git

  # Verify
  git --version
  ```

---

### Step 2: Clone the Repository

Choose your preferred location on your computer and run:

```bash
# Navigate to your projects directory
cd ~/projects
# (or any folder where you want to store the project)

# Clone the repository
git clone https://github.com/IT25103640NethsaraRDP/Vehicle-Rental-System-.git

# Navigate to the project folder
cd Vehicle-Rental-System-
```

**Verify the clone was successful:**

```bash
ls -la
# You should see: pom.xml, src/, data/, README.md, etc.
```

---

### Step 3: Create Your Personal Branch

Each team member should work on their own branch. This keeps the `main` branch stable.

```bash
# View all branches
git branch -a

# Create and switch to your feature branch
git checkout -b feature/your-component-name

# Examples:
# git checkout -b feature/vehicle-management
# git checkout -b feature/customer-management
# git checkout -b feature/booking-management
# git checkout -b feature/payment-management
# git checkout -b feature/employee-management
# git checkout -b feature/feedback-management

# Verify you're on your new branch (should show your branch name)
git branch
```

---

### Step 4: Build the Project (Maven)

#### **4.1 Clean Build (recommended for first time)**

```bash
mvn clean install
```

This will:

- Remove any previous build artifacts
- Download all dependencies from Maven repositories
- Compile the Java source code
- Run tests (if any)
- Package the application

#### **4.2 Compile Only (faster, after initial setup)**

```bash
mvn clean compile
```

**Expected Output:**

```
[INFO] BUILD SUCCESS
```

---

### Step 5: Run the Application

#### **Option A: Using Maven Spring Boot Plugin** (Recommended)

```bash
# Unix/macOS/Linux
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

#### **Option B: Using Maven directly**

```bash
mvn spring-boot:run
```

**Wait for the application to start - you'll see:**

```
Tomcat started on port(s): 8080 (http)
Application 'Vehicle Rental System' is running!
```

---

### Step 6: Access the Application

Open your web browser and navigate to:

```
http://localhost:8080
```

You should see the **Vehicle Rental System Dashboard** with a navigation bar containing:

- **Vehicles** - Manage vehicle inventory
- **Customers** - Manage customer information
- **Bookings** - Manage rental bookings
- **Payments** - Manage payment records
- **Employees** - Manage employee information
- **Reviews** - Manage customer reviews

---

### Step 7: Stop the Application

Press `Ctrl + C` in the terminal where Maven is running.

---

## 📝 Common Maven Commands

| Command               | Purpose                      |
| --------------------- | ---------------------------- |
| `mvn clean`           | Remove build artifacts       |
| `mvn compile`         | Compile source code          |
| `mvn test`            | Run unit tests               |
| `mvn clean install`   | Full build with dependencies |
| `mvn spring-boot:run` | Run the application          |
| `mvn clean package`   | Create executable JAR file   |

---

## 🔀 Git Workflow for Team Development

### Daily Workflow

```bash
# 1. Before you start working, update your branch from main
git checkout main
git pull origin main
git checkout feature/your-component

# 2. Make your changes to files
# (Edit Java files, HTML templates, CSS, etc.)

# 3. Commit your work regularly
git status                          # See what changed
git add .                          # Stage all changes
git commit -m "Add [description]"  # Commit with clear message

# 4. Push to remote repository
git push origin feature/your-component

# 5. When your component is ready, create a Pull Request (PR)
# Go to GitHub and create a PR from your branch to main
```

### Example Commit Messages

```
✅ Add BaseEntity abstract class with ID and timestamp fields
✅ Implement Vehicle model with encapsulation
✅ Create VehicleController with CRUD endpoints
✅ Add vehicle list template and styling
✅ Fix: Correct null pointer exception in booking service
```

### Handling Merge Conflicts

If there are merge conflicts:

```bash
# Update your branch with latest main
git fetch origin
git rebase origin/main
# OR merge instead of rebase (safe option)
git merge origin/main

# Resolve conflicts in your IDE, then:
git add .
git commit -m "Resolve merge conflicts"
git push origin feature/your-component
```

---

## 🧠 OOP Concepts Applied

| Concept                | Implementation                                                                  |
| ---------------------- | ------------------------------------------------------------------------------- |
| **Abstraction**        | `BaseEntity`, `BaseFileService` - abstract classes defining common behavior     |
| **Encapsulation**      | Private fields with public getters/setters in all model classes                 |
| **Inheritance**        | All models extend `BaseEntity`; services extend `BaseFileService`               |
| **Polymorphism**       | Abstract methods overridden in child classes (e.g., calculateCost, getDiscount) |
| **Information Hiding** | No direct field access - all access through methods                             |

---

## 📝 Data Storage Format

All data is stored as **comma-separated values (CSV)** in text files located in `/data/`:

**Example: `data/vehicles.txt`**

```
id,type,brand,model,licensePlate,rentalPrice,available
1,Car,Toyota,Camry,ABC-123,50.00,true
2,Truck,Ford,F-150,XYZ-789,75.00,true
```

**Example: `data/customers.txt`**

```
id,name,email,phone,tier
1,John Doe,john@email.com,555-1234,REGULAR
2,Jane Smith,jane@email.com,555-5678,PREMIUM
```

---

## ❓ Troubleshooting

### Issue: `mvn: command not found`

**Solution:** Maven is not installed or not in PATH

```bash
# macOS users
brew install maven

# Then verify
mvn -version
```

### Issue: `java: command not found`

**Solution:** Java is not installed or not in PATH

```bash
# macOS users
brew install java21
java -version
```

### Issue: `Port 8080 already in use`

**Solution:** Stop other applications using port 8080 or change the port:

```bash
# Change port in src/main/resources/application.properties
server.port=8081
```

### Issue: Build fails with `BUILD FAILURE`

**Solution:**

```bash
# Clean everything and rebuild
mvn clean install

# If that fails, check Java version
java -version  # Should be Java 21+
```

### Issue: Cannot see other pages (only homepage visible)

**Solution:** Ensure all controllers are implemented:

- Check that all `*Controller.java` files exist in `src/main/java/com/vehiclerental/controller/`
- Verify each controller has `@RestController` and `@RequestMapping` annotations
- Check that navigation links in `templates/fragments/navbar.html` match controller endpoints

---

## 📧 Support

If you encounter any issues:

1. Check the troubleshooting section above
2. Review the application logs in the console
3. Make sure all prerequisites are installed correctly
4. Ask your team lead or create an issue in the GitHub repository

---

**Happy Coding! 🚀**
