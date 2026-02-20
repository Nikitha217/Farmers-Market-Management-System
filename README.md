# Farmers Market Stall Booking (Java + JDBC + OOP)

---

## Problem Statement

* The objective of this project is to design and develop a console-based Java application for managing a local farmers’ market.
* The system supports:

  * Vendor registration
  * Stall booking for specific market days
  * Daily sales summary tracking
* All operations are performed using a console-based interface.

---

## Objectives

* Register and manage vendors
* Book stalls for vendors on specific market dates
* Prevent double booking of stalls
* Record daily sales summary
* View vendor and booking details
* Safely remove vendors with no active bookings
* Validate user inputs
* Connect to database using JDBC

---

## Technologies Used

* Programming Language: Java
* Database: Oracle / MySQL
* Connectivity: JDBC
* Concepts Used:

  * Encapsulation
  * Abstraction
  * Inheritance
  * Polymorphism
* IDE: Eclipse
* Interface: Console-based Menu System

---

## Features

### Vendor Management

* Register new vendor
* View vendor details
* View all vendors
* Update vendor status (ACTIVE / INACTIVE)
* Delete vendor safely

### Stall Booking

* Book stall for vendor on specific market date
* Validate vendor status before booking
* Prevent double booking of stall and time slot

### Sales Summary

* Record daily sales value
* Add sales notes
* Mark booking as COMPLETED

### Reports

* List bookings by vendor
* List bookings by market date

---

## Database Details

### Tables Used

* VENDOR_TBL
* STALL_BOOKING_TBL

---

## Project Structure

```plaintext

LocalFarmersMarketApplication
│
├── com.market.app
│   └── MarketMain.java
│
├── com.market.bean
│   ├── Vendor.java
│   └── StallBooking.java
│
├── com.market.dao
│   ├── VendorDAO.java
│   └── StallBookingDAO.java
│
├── com.market.service
│   └── MarketService.java
│
├── com.market.util
│   ├── DBUtil.java
│   ├── ValidationException.java
│   ├── BookingConflictException.java
│   └── ActiveBookingsExistException.java

```
---

## How to Run the Project

* Open Eclipse IDE
* Import or open the project
* Configure database connection in DBUtil.java
* Create required tables in database
* Add JDBC driver to project build path
* Run MarketMain.java
* Use console menu to perform operations

---

## Output
```md

The application provides the following menu options:

- Main Menu  
- Vendor Registration  
- Stall Booking  
- Sales Summary Entry  
- Booking List  
- Vendor List
```

---

## Student Details

* Name: Nikitha S
* Roll No: 717823P136

---
