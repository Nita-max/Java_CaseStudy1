# 🏦 Bank Management System (Java – OOPs Project)

This project is a **Bank Management System** implemented in **Java**, following strong **Object-Oriented Programming** concepts such as abstraction, inheritance, polymorphism, interface implementation, and encapsulation.

This system allows users to manage various types of bank accounts, perform transactions, calculate interest, and view reports.

---

## 🚀 Features

* Create different types of bank accounts:

  * Savings Account
  * Current Account
  * Loan Account
  * Salary Account
* Deposit & Withdraw money
* Overdraft handling (Current Account)
* Loan repayment logic
* Interest calculation
* End-of-Day Report
* Transaction history for each account
* Fully menu-driven program

---

## 🧩 Technologies Used

* **Java (Core Java)**
* **OOP Concepts**
* **UML Design**
* **Eclipse/VS Code/IntelliJ**

---

## 📘 UML Class Diagram

Below is the UML diagram representing the full architecture:

![UML Diagram](UML%20diagram.jpg)
UML diagram

---

## 🏗️ Project Structure

```
src/
 ├── AccountOperation.java     # Interface
 ├── BankAccount.java          # Abstract Parent Class
 ├── CurrentAccount.java       # Child Class
 ├── SavingsAccount.java       # Child Class
 ├── SalaryAccount.java        # Child Class
 ├── LoanAccount.java          # Child Class
 ├── Transaction.java          # Transaction Model
 ├── Bank.java                 # Bank Details
 └── Test.java                 # Main Menu-Driven Program
```

---

## 📄 Class Overview

### 🔹 **AccountOperation (Interface)**

Defines abstract operations like deposit, withdraw, showDetails, get/set account data, etc.

### 🔹 **BankAccount (Abstract Class)**

Parent class for all accounts. Contains:

* Common fields (accountNumber, holderName, balance, Aadhaar, nominee)
* Common methods for deposit, show details, add transactions etc.

### 🔹 **Derived Classes**

Each child class overrides withdrawal rules:

| Account Type       | Special Rules                                  |
| ------------------ | ---------------------------------------------- |
| **SavingAccount**  | Minimum Balance = 1000, Interest Rate applies  |
| **CurrentAccount** | Overdraft limit available                      |
| **SalaryAccount**  | Last Salary Date check                         |
| **LoanAccount**    | Loan Amount, Outstanding Amount, EMI deduction |

### 🔹 **Transaction Class**

Stores transactionID, amount, date, type, updated balance.

---

## ▶️ How to Run

1. Clone the repository:

   ```
   git clone https://github.com/your-username/your-repository.git
   ```
2. Open project in **Eclipse/VS Code/IntelliJ**.
3. Run `Test.java`
4. Use the console menu to perform operations.

---

## 📝 Sample Menu

```
1. Create Account
2. Deposit
3. Withdraw
4. Display Account Details
5. Display All Accounts
6. Transaction History
7. Calculate Interest
8. End Of Day Report
9. Exit
```

---

## 📌 Future Enhancements

* GUI using JavaFX or Swing
* Database integration (MySQL)
* Web-based version using Spring Boot

---

## 🙌 Author

Created by **Nita Waghchaure** 
