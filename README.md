
# 💳 Bank Management System in Java (Console-Based)

This is a **console-based banking system** implemented in Java. It allows users to create accounts, log in, perform transactions like deposit, withdraw, take out loans, view transaction history, and more.

## 🛠 Features

- Account creation and login
- Deposit and withdrawal functionality
- Loan system with interest and repayment calculation
- Transaction history logging
- Change user password (PIN)
- Admin password for secure exit

## 👤 User Roles

- **User** – can register, log in, and access basic banking functionalities
- **Admin** – can exit the program with a secure password

## 🖥 Sample Menu (After Login)

```
1. Show Balance  
2. Deposit  
3. Withdraw  
4. Loan Money  
5. Show Transactions  
6. Change Pin  
7. Log Out  
```

## 🔐 Admin Exit

To exit the program completely, enter option `0` and provide the admin password.

## 🧾 Transaction Logs

All successful deposits, withdrawals, and loan activities are logged and viewable via the "Show Transactions" menu option.

## 📂 File Structure

```bash
├── mainBank.java        # Main Java program
```

## 🚀 How to Run

1. Compile the program:

```bash
javac mainBank.java
```

2. Run the program:

```bash
java mainBank
```

## 👨‍💻 Technologies Used

- Java SE (Standard Edition)
- Scanner class for console input
- ArrayList for storing users and transactions

## 📌 Notes

- No external libraries or GUI components were used
- Data is not persistent (does not save after program ends)
- This project is ideal for beginners learning object-oriented programming and console interaction in Java

## 📸 Preview (Console Output)

```
WELCOME TO BANKNET!
1. Create an Account
2. Login existing Account
Enter Here:
```

## 📃 License

This project is open-source and free to use under the MIT License.

---

**Developed for educational purposes. Contributions welcome!**
