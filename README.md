# 🏦 Java Console-Based Bank System

This is a simple **Java-based Bank Management System** that runs in the **console**. It features user registration, login, basic banking operations like deposit and withdrawal, loan handling, and admin shutdown functionality. Built using Java's `Scanner`, `ArrayList`, and basic OOP principles.

---

## 📦 Features

- 🔐 **User Registration and Login**
- 💰 **Balance Management**
  - View Balance
  - Deposit Money
  - Withdraw Money
- 💸 **Loan System**
  - Loan application with interest
  - Monthly payment calculations
  - Loan repayment
- 📜 **Transaction History**
- 🔄 **Change PIN/Password**
- 🚪 **Logout & Exit**
- 🛡️ **Admin Shutdown (using special admin password)**
- ⛔ Input validation for edge cases (e.g., over-withdrawal, duplicate users)

---

## 🧾 Sample Code Structure

java
// User class
class User {
    String username;
    String password;
    ...
}

// Admin class
class admin {
    String adminPassword;
    ...
}

// Main Application class
public class mainBank {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<String> transactions = new ArrayList<>();
    
    public static void main(String[] args) {
      
    }
}

🔐 Login System
At startup, users choose:

1 Create an Account

2 Login to existing Account

Admin shutdown can be triggered by inputting 0 and the correct admin password.
