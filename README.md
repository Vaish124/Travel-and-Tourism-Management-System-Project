# 🌍 Travel & Tourism Management System

A desktop-based **Tourism Management System** built using **Java (Swing & AWT)** and **MySQL**, designed to allow tourists to:
- Register/login as users
- Browse and book hotels
- Browse and book tour packages
- View booking history

---

## 📌 Technologies Used

- Java (Swing & AWT)
- MySQL
- JDBC
- Eclipse IDE

---

## 🛠 Installation & Setup

### 1. Clone the repository

```bash
git clone https://github.com/Vaish124/Travel-and-Tourism-Management-System-Project.git
cd Travel-and-Tourism-Management-System-Project
```

### 2. Set up the MySQL database

Open MySQL (via command line or GUI like phpMyAdmin) and execute the following SQL queries:

```sql
-- Create database
CREATE DATABASE IF NOT EXISTS travel_mgmt;
USE travel_mgmt;

-- Create tourist table
CREATE TABLE IF NOT EXISTS tourist (
    tourist_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    phone VARCHAR(20)
);

-- Create hotel table
CREATE TABLE IF NOT EXISTS hotel (
    hotel_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    cost_per_night DECIMAL(10,2)
);

-- Create package table
CREATE TABLE IF NOT EXISTS package (
    package_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    details TEXT,
    cost DECIMAL(10,2)
);

-- Create hotel booking table
CREATE TABLE IF NOT EXISTS booking_hotel (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    tourist_id INT NOT NULL,
    hotel_id INT NOT NULL,
    check_in DATE,
    check_out DATE,
    total_cost DECIMAL(10,2),
    FOREIGN KEY (tourist_id) REFERENCES tourist(tourist_id),
    FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)
);

-- Create package booking table
CREATE TABLE IF NOT EXISTS booking_package (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    tourist_id INT NOT NULL,
    package_id INT NOT NULL,
    booking_date DATE,
    total_cost DECIMAL(10,2),
    FOREIGN KEY (tourist_id) REFERENCES tourist(tourist_id),
    FOREIGN KEY (package_id) REFERENCES package(package_id)
);

-- Insert sample hotel data
INSERT INTO hotel (name, location, cost_per_night) VALUES
('Hotel Sunrise', 'Goa', 3000.00),
('Hotel Pearl', 'Manali', 2500.00),
('Hotel Palace', 'Jaipur', 2000.00);

-- Insert sample package data
INSERT INTO package (name, details, cost) VALUES
('Goa Tour', '3 nights in Goa with beach visits', 9000.00),
('Manali Adventure', '4 nights with trekking', 12000.00),
('Rajasthan Heritage', '5 nights across Jaipur & Udaipur', 15000.00);
```

### 3. Configure the Java application

- Open the project in Eclipse.
- Go to `DBConnection.java` and update the database credentials:
  ```java
  private static final String DB_URL = "jdbc:mysql://localhost:3306/travel_mgmt";
  private static final String USERNAME = "your_mysql_username";
  private static final String PASSWORD = "your_mysql_password";
  ```

- Add the MySQL Connector/J `.jar` file to the project’s classpath.

---

## 🚀 How to Run

1. Launch Eclipse and import the project.
2. Run the main class (`TravelManagementSystem.java` or similar).
3. Use the GUI to:
   - Register a tourist
   - Log in
   - Book hotels or packages
   - View booking history

---

## 📁 Project Structure

```
/src
  ├── config/
  │   └── DBConnection.java
  ├── gui/
  │   ├── LoginFrame.java
  │   ├── TouristDashboard.java
  │   ├── HotelBookingFrame.java
  │   └── PackageBookingFrame.java
  └── models/
      ├── Tourist.java
      ├── Hotel.java
      ├── Package.java
      └── Booking.java

/lib
  └── mysql-connector-java-x.x.xx.jar

README.md
```

---

## 🧪 Features

- Tourist registration and authentication
- Hotel listing and booking
- Tour package selection and booking
- Booking management (view history)

---

## 💡 Future Enhancements

- Admin dashboard for hotel/package management
- JavaFX UI upgrade
- Email confirmation system
- Payment gateway integration
- Export reports (PDF, Excel)

---

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/YourFeature`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/YourFeature`
5. Open a pull request

---

## 📄 License

This project is open-source and free to use under the [MIT License](LICENSE).

---

## 🙏 Acknowledgments

- Java Community
- MySQL Documentation
- Swing/AWT Tutorials

---
