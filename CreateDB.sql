CREATE DATABASE PizzaStoreDB
USE PizzaStoreDB

-- Customers Table
CREATE TABLE Customers(
	CustomerID VARCHAR(10) PRIMARY KEY,
	Password VARCHAR(255) not null UNIQUE,
	ContactName VARCHAR(255) not null,
	Address VARCHAR(500),
	Phone VARCHAR(15)
)

-- Categories Table
CREATE TABLE Categories (
    CategoryID VARCHAR(10) PRIMARY KEY,
    CategoryName VARCHAR(255) NOT NULL,
    Description VARCHAR(500)
);

-- Suppliers Table
CREATE TABLE Suppliers (
    SupplierID VARCHAR(10) PRIMARY KEY,
    CompanyName VARCHAR(255) NOT NULL,
    Address VARCHAR(500),
    Phone VARCHAR(15)
);

-- Products Table
CREATE TABLE Products (
    ProductID VARCHAR(10) PRIMARY KEY,
    ProductName VARCHAR(255) NOT NULL,
    SupplierID VARCHAR(10),
    CategoryID VARCHAR(10),
    QuantityPerUnit int,
    UnitPrice DECIMAL(10,2),
	Description VARCHAR(500),
    ProductImage TEXT, --link url
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID),
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

-- Orders Table
CREATE TABLE Orders(
	OrderID varchar(10) PRIMARY KEY,
	CustomerID varchar(10),
	OrderDate DATE,
	RequiredDate DATE,
	ShippedDate DATE,
	Freight DECIMAL(10,2),
	ShipAddress VARCHAR(500),
	FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
)

-- Order Details Table
CREATE TABLE OrderDetails (
    OrderID varchar(10),
    ProductID varchar(10),
    UnitPrice DECIMAL(10,2),
    Quantity INT,
    PRIMARY KEY (OrderID, ProductID),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- Account Table
CREATE TABLE Account (
    AccountID INT PRIMARY key IDENTITY(1,1),
    UserName VARCHAR(255) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    FullName NVARCHAR(255),
    Type INT NOT NULL DEFAULT 2, -- 1 = Staff, 2 = User (Mặc định là User)
    CONSTRAINT CK_Account_Type CHECK (Type IN (1, 2)) -- Ràng buộc giá trị Type
);

-- Insert into Customers
SELECT * FROM Customers
INSERT INTO Customers (CustomerID, Password, ContactName, Address, Phone) VALUES
('CUST001', 'Cust@123', 'Michael Brown', '123 Main St, NY', '1234567890'),
('CUST002', 'Cust@456', 'Emily Davis', '456 Elm St, CA', '9876543210'),
('CUST003', 'Cust@789', 'David Wilson', '789 Pine St, TX', '1122334455');


-- Insert into Categories
INSERT INTO Categories (CategoryID, CategoryName, Description) VALUES
('CAT01', 'Classic Pizzas', 'Traditional pizzas with various toppings'),
('CAT02', 'Specialty Pizzas', 'Unique pizza combinations'),
('CAT03', 'Drinks', 'Soft drinks and beverages');


-- Insert into Suppliers
INSERT INTO Suppliers (SupplierID, CompanyName, Address, Phone) VALUES
('SUP01', 'Italian Ingredients Ltd', '500 Italy St, Rome', '5551112222'),
('SUP02', 'Cheese Factory Inc.', '200 Dairy Rd, Wisconsin', '5553334444'),
('SUP03', 'Beverage Co.', '100 Soda Ave, NY', '5556667777');


-- Insert into Products
INSERT INTO Products (ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, Description, ProductImage) VALUES
('PIZ001', 'Margherita Pizza', 'SUP01', 'CAT01', 1, 9.99, 'Classic Italian pizza with tomatoes and mozzarella', 'https://example.com/margherita.jpg'),
('PIZ002', 'Pepperoni Pizza', 'SUP02', 'CAT01', 1, 12.99, 'Spicy pepperoni slices on cheese pizza', 'https://example.com/pepperoni.jpg'),
('PIZ003', 'BBQ Chicken Pizza', 'SUP01', 'CAT02', 1, 14.99, 'BBQ sauce, grilled chicken, and red onions', 'https://example.com/bbqchicken.jpg'),
('PIZ004', 'Veggie Supreme', 'SUP02', 'CAT02', 1, 11.99, 'A mix of fresh vegetables and cheese', 'https://example.com/veggiesupreme.jpg'),
('DRK001', 'Coca Cola', 'SUP03', 'CAT03', 1, 1.99, 'Refreshing soft drink', 'https://example.com/coca-cola.jpg'),
('DRK002', 'Sprite', 'SUP03', 'CAT03', 1, 1.99, 'Lemon-lime soft drink', 'https://example.com/sprite.jpg');


-- Insert into Orders
INSERT INTO Orders (OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress) VALUES
('ORD001', 'CUST001', '2024-03-01', '2024-03-03', '2024-03-02', 5.00, '123 Main St, NY'),
('ORD002', 'CUST002', '2024-03-02', '2024-03-04', '2024-03-03', 4.50, '456 Elm St, CA'),
('ORD003', 'CUST003', '2024-03-03', '2024-03-05', '2024-03-04', 6.00, '789 Pine St, TX');


-- Insert into OrderDetails
INSERT INTO OrderDetails (OrderID, ProductID, UnitPrice, Quantity) VALUES
('ORD001', 'PIZ001', 9.99, 2),
('ORD001', 'DRK001', 1.99, 2),
('ORD002', 'PIZ002', 12.99, 1),
('ORD002', 'DRK002', 1.99, 1),
('ORD003', 'PIZ003', 14.99, 2),
('ORD003', 'PIZ004', 11.99, 1);


-- Insert into Account
SELECT * FROM Account
INSERT INTO Account (UserName, Password, FullName, Type) VALUES
('admin', 'Admin@123', 'Pizza Store Admin', 1),
('john_doe', 'John12345', 'John Doe', 2),
('jane_smith', 'Jane@987', 'Jane Smith', 2);

SELECT * FROM Account
INSERT INTO Account (UserName, Password, FullName) VALUES
('admin4', 'Admin@123', 'Pizza Store Admin'),




