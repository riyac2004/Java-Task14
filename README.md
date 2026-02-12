# Java-Task14
TASK 14: Mini Project – Console-Based Inventory Management System

# TASK 14: Mini Project – Console-Based Inventory Management System

## 📌 Project Overview
This project is a console-based Inventory Management System developed using Java Collections.  
It allows users to manage product records efficiently through a menu-driven interface.  
The system performs basic inventory operations such as adding, updating, deleting, and viewing products, while also storing data persistently using file handling.

---

## 🛠 Tools & Technologies Used
- Java
- IntelliJ IDEA
- Java Collections Framework (HashMap)
- File Handling (BufferedReader, BufferedWriter)

---

## 📦 Features Implemented

- Add new products to inventory
- Update existing product details
- Delete products from inventory
- View all products
- Display inventory summary (total items, total quantity, total value)
- Validate unique Product IDs
- Handle invalid user inputs
- Persist inventory data using file storage (`inventory.txt`)
- Modular and refactored code using methods

---

## 🏗 System Design

### Product Class
The `Product` class contains:
- id (unique identifier)
- name (product name)
- quantity (available stock)
- price (per unit price)

### Data Storage
- Products are stored in a `HashMap<Integer, Product>`
- Key → Product ID
- Value → Product object
- Ensures fast lookup and unique ID validation

---

## 💾 Data Persistence
- Inventory data is stored in a file named `inventory.txt`
- Data is saved automatically when the program exits
- Existing data is loaded when the program starts

---

## ▶️ How to Run the Project

1. Open the project in IntelliJ IDEA.
2. Compile and run the `InventoryManagementSystem` class.
3. Use the menu options to manage inventory.
4. On exit, data will be saved automatically.

---

## 🔐 Validation & Error Handling

- Prevents duplicate Product IDs
- Handles invalid numeric inputs
- Displays meaningful error messages
- Ensures safe file handling using try-with-resources

---

## 📘 Learning Outcomes

- Understanding Java Collections (HashMap)
- Implementing CRUD operations in a console application
- Applying file handling for data persistence
- Structuring modular and maintainable Java code
- Handling user input validation and exceptions

---

## ✅ Conclusion

This project demonstrates the practical use of Java Collections and file handling to build a functional inventory management system.  
It serves as a foundation for developing larger database-driven or GUI-based applications in the future.

---

<img width="1358" height="805" alt="image" src="https://github.com/user-attachments/assets/d2ea046e-520a-4d44-86e6-bbc9be6e6c6c" />

<img width="772" height="765" alt="image" src="https://github.com/user-attachments/assets/9f1b858e-5726-4822-b2fe-d103e67b7b7a" />

<img width="820" height="671" alt="image" src="https://github.com/user-attachments/assets/3b7102e4-1fec-4a05-b856-faff69c36916" />

<img width="894" height="686" alt="image" src="https://github.com/user-attachments/assets/f0263027-3dcc-4425-abc5-69bb9da968aa" />

<img width="715" height="464" alt="image" src="https://github.com/user-attachments/assets/5013a19c-6192-4674-8cf0-8d81a04ae51b" />
