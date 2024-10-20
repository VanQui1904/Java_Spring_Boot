CREATE TABLE Brands (
    brand_id SERIAL PRIMARY KEY,
    brand_name VARCHAR(100) NOT NULL UNIQUE 
);
CREATE TABLE Categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE   
);
CREATE TABLE Showrooms (
	showroom_id serial primary key,
	showroom_name varchar(200),
	address varchar(200) not null
);
-- Tạo bảng Car (Xe)
CREATE TABLE Cars (
    car_id SERIAL PRIMARY KEY,
    carname VARCHAR(100) NOT NULL,
    brand_id int NOT NULL,
	category_id int NOT NULL,
    model_year INT NOT NULL,
    price DECIMAL(15, 2) NOT NULL,
    image_url TEXT,
    description TEXT,
	FOREIGN KEY (brand_id) REFERENCES Brands(brand_id) ON DELETE CASCADE,
	FOREIGN KEY (category_id) REFERENCES Categories(category_id) ON DELETE CASCADE
);
-- Tạo bảng Customer (Khách hàng)
CREATE TABLE Customers (
    customer_id SERIAL PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	phone_number VARCHAR(20),
	address TEXT	    
);
CREATE TABLE TestDrives (
    testdrive_id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    showroom_id INT NOT NULL,
    bookingTime TIMESTAMP NOT NULL,
    status VARCHAR(20) DEFAULT 'Pending',
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (car_id) REFERENCES Cars(car_id) ON DELETE CASCADE,
    FOREIGN KEY (showroom_id) REFERENCES Showrooms(showroom_id) ON DELETE CASCADE
);

-- Tạo bảng Order (Đơn hàng)
CREATE TABLE Car_Orders (
    order_id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    car_price DECIMAL(15, 2) NOT NULL,
    status VARCHAR(20) DEFAULT 'Pending',
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id) ON DELETE CASCADE
);
-- Tạo bảng Payment (Thanh toán)
CREATE TABLE Payments (
    payment_id SERIAL PRIMARY KEY,
    payment_method VARCHAR(200)
);
CREATE TABLE Accounts (
    account_id SERIAL PRIMARY KEY,
	customer_id int,
    username VARCHAR(50) NOT NULL UNIQUE,
    account_password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    account_role VARCHAR(20) DEFAULT 'USER', -- Các giá trị có thể là 'USER' hoặc 'ADMIN'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (customer_id) REFERENCES Customers(customer_id) ON DELETE CASCADE
);
INSERT INTO Brands (brand_name) VALUES
('Toyota'),
('Honda'),
('Ford'),
('BMW'),
('Mercedes');
INSERT INTO Categories (category_name) VALUES
('SUV'),
('Sedan'),
('Truck'),
('Coupe'),
('Convertible');
INSERT INTO Showrooms (showroom_name,address) VALUES
('Showroom A','123 Main Street, City A'),
('Showroom B','456 Elm Street, City B'),
('Showroom C','789 Oak Avenue, City C');
INSERT INTO Cars (carname, brand_id, category_id, model_year, price, image_url, description) VALUES
('Toyota Corolla', 1, 2, 2022, 20000.00, 'https://example.com/images/corolla.jpg', 'Compact sedan with great fuel efficiency.'),
('Honda CR-V', 2, 1, 2021, 30000.00, 'https://example.com/images/crv.jpg', 'Popular SUV with modern features.'),
('Ford F-150', 3, 3, 2023, 45000.00, 'https://example.com/images/f150.jpg', 'Best-selling truck in the U.S.'),
('BMW X5', 4, 1, 2022, 60000.00, 'https://example.com/images/x5.jpg', 'Luxury SUV with premium features.'),
('Mercedes C-Class', 5, 2, 2023, 55000.00, 'https://example.com/images/cclass.jpg', 'Elegant sedan with advanced technology.');
INSERT INTO Customers (first_name, last_name, email, phone_number, address) VALUES
('John', 'Doe', 'john.doe@example.com', '1234567890', '111 Maple Street, City A'),
('Jane', 'Smith', 'jane.smith@example.com', '0987654321', '222 Pine Avenue, City B');
INSERT INTO TestDrives (customer_id, car_id, showroom_id, bookingTime, status) VALUES
(1, 1, 1, '2024-10-10 10:00:00', 'Pending'),
(2, 2, 2, '2024-10-11 14:00:00', 'Pending');
INSERT INTO Car_Orders (customer_id, car_price, status) VALUES
(1, 20000.00, 'Pending'),
(2, 30000.00, 'Pending');
INSERT INTO Payments (payment_method) VALUES
('Credit Card'),
('PayPal'),
('Bank Transfer');
INSERT INTO Accounts (customer_id, username, account_password, email, account_role) VALUES
(1, 'johndoe', 'hashedpassword1', 'john.doe@example.com', 'USER'),
(2, 'janesmith', 'hashedpassword2', 'jane.smith@example.com', 'ADMIN');
