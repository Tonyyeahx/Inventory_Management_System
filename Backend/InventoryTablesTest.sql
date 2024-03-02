-- Create Store Table
CREATE TABLE IF NOT EXISTS Store (
    StoreId INT PRIMARY KEY NOT NULL,
    Longitude FLOAT NOT NULL,
    Latitude FLOAT NOT NULL,
    Manager VARCHAR(30) NOT NULL,
    OpenDate DATE NOT NULL,
    Contact CHAR(10) NOT NULL
);

-- Create Product Table
CREATE TABLE Product (
    ProductId INT PRIMARY KEY NOT NULL,
    CategoryId INT NOT NULL,
    SupplierId INT NOT NULL,
    ProductName VARCHAR(20) NOT NULL,
    Cost FLOAT NOT NULL,
    FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId),
    FOREIGN KEY (SupplierId) REFERENCES Supplier(SupplierId)
);

-- Create Category Table
CREATE TABLE Category (
    CategoryId INT PRIMARY KEY NOT NULL,
    CategoryName VARCHAR(20) NOT NULL
);

-- Create Supplier Table
CREATE TABLE Supplier (
    SupplierId INT PRIMARY KEY NOT NULL,
    SupplierName VARCHAR(20) NOT NULL,
    Contact CHAR(10) NOT NULL
);

-- Create Inventory Table
CREATE TABLE Inventory (
    InventoryId INT PRIMARY KEY NOT NULL,
    StoreId INT NOT NULL,
    ProductId INT NOT NULL,
    SellPrice FLOAT NOT NULL,
    Quantity INT NOT NULL,
    Discount FLOAT DEFAULT 1.0,
    LastOrderDate DATE,
    OrderQuantity INT NOT NULL,
    FOREIGN KEY (StoreId) REFERENCES Store(StoreId),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
);


