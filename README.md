# 🚗 Vehicle Rental System
**SE1020 — Object Oriented Programming | Group Project**

A web-based vehicle rental management system built with Java Spring Boot, Thymeleaf, and Bootstrap 5.

---

## 👥 Team Members & Components

| Member | Component | Branch |
|--------|-----------|--------|
| Member 1 | Vehicle Management | `feature/vehicle-management` |
| Member 2 | Customer Management | `feature/customer-management` |
| Member 3 (Leader) | Booking Management + Architecture | `feature/booking-management` |
| Member 4 | Payment Management | `feature/payment-management` |
| Member 5 | Employee Management | `feature/employee-management` |
| Member 6 | Feedback & Review Management | `feature/feedback-management` |

---

## 🛠 Tech Stack

- **Backend:** Java 21, Spring Boot 3.2
- **Frontend:** HTML5, Thymeleaf, Bootstrap 5.3
- **Data Storage:** File I/O (.txt files)
- **Build Tool:** Maven
- **Version Control:** Git / GitHub

---

## 🚀 How to Run

### Prerequisites
- Java JDK 21 installed
- Maven installed (or use the included `./mvnw` wrapper)

### Steps
```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/vehicle-rental-system.git
cd vehicle-rental-system

# 2. Run the application
./mvnw spring-boot:run
# OR on Windows:
mvnw.cmd spring-boot:run

# 3. Open in browser
# http://localhost:8080
```

---

## 📁 Project Structure

```
vehicle-rental-system/
├── src/main/java/com/vehiclerental/
│   ├── VehicleRentalApplication.java   ← App entry point
│   ├── model/                          ← Entity classes (OOP)
│   │   ├── BaseEntity.java             ← Abstract parent (ALL models extend this)
│   │   ├── Vehicle.java / Car.java / Motorcycle.java / Truck.java
│   │   ├── Customer.java / RegularCustomer.java / PremiumCustomer.java
│   │   ├── Booking.java / ShortTermBooking.java / LongTermBooking.java
│   │   ├── Payment.java / CashPayment.java / CardPayment.java
│   │   ├── Employee.java / Manager.java / FieldStaff.java
│   │   └── Review.java / CustomerReview.java / AdminReview.java
│   ├── service/                        ← File I/O services
│   │   ├── BaseFileService.java        ← Abstract parent (ALL services extend this)
│   │   └── [Component]FileService.java
│   └── controller/                     ← HTTP request handlers
│       ├── HomeController.java
│       └── [Component]Controller.java
├── src/main/resources/
│   ├── templates/                      ← HTML pages (Thymeleaf)
│   │   ├── fragments/navbar.html       ← Shared navbar
│   │   ├── index.html                  ← Dashboard home page
│   │   └── [component]/list|add|edit.html
│   ├── static/css/style.css            ← Global stylesheet
│   └── application.properties          ← App configuration
├── data/                               ← Text file storage
│   ├── vehicles.txt
│   ├── customers.txt
│   ├── bookings.txt
│   ├── payments.txt
│   ├── employees.txt
│   └── reviews.txt
└── pom.xml                             ← Maven dependencies
```

---

## 🧠 OOP Concepts Applied

| Concept | Where |
|---------|-------|
| **Abstraction** | `BaseEntity`, `BaseFileService`, all abstract model classes |
| **Encapsulation** | Private fields + getters/setters in every model class |
| **Inheritance** | Every model extends `BaseEntity`; subclasses (Car, Truck etc.) extend component parent |
| **Polymorphism** | Abstract methods overridden in subclasses (calculateRentalCost, getRentalDiscount, etc.) |
| **Information Hiding** | No public fields anywhere — all access through methods |

---

## 📝 Data File Format

All data is stored as comma-separated values in `/data/*.txt`.
Lines starting with `#` are comments and are ignored.

---

## 🔀 Git Workflow

```bash
# Each member works on their own branch
git checkout feature/your-component

# Commit regularly with clear messages
git add .
git commit -m "Add Vehicle abstract class with encapsulation"
git push origin feature/your-component

# When your component is complete, create a Pull Request to merge into main
```
