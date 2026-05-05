<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle Rental System</title>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600&display=swap" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom Styles -->
    <style>
        body {
            font-family: 'Outfit', sans-serif;
            background-color: #f8fafc;
            color: #1e293b;
        }
        .navbar-brand {
            font-weight: 600;
            letter-spacing: 1px;
            color: #ffffff !important;
        }
        .navbar {
            background: linear-gradient(135deg, #1e3a8a 0%, #3b82f6 100%);
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
        }
        .nav-link {
            color: #e2e8f0 !important;
            transition: color 0.3s ease;
        }
        .nav-link:hover {
            color: #ffffff !important;
        }
        .premium-card {
            background: white;
            border-radius: 12px;
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
            padding: 2rem;
            margin-top: 2rem;
            transition: transform 0.3s ease;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark pb-3 pt-3">
    <div class="container">
        <a class="navbar-brand" href="/">Drive Elite</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="/customers/list">Customers</a></li>
                <li class="nav-item"><a class="nav-link" href="/vehicles/list">Vehicles</a></li>
                <li class="nav-item"><a class="nav-link" href="/bookings/list">Bookings</a></li>
                <li class="nav-item"><a class="nav-link" href="/payments/list">Payments</a></li>
                <li class="nav-item"><a class="nav-link" href="/reviews/list">System Logs</a></li>
                <li class="nav-item"><a class="nav-link" href="/staff/manage">Staff</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
