-- Dropping table product if already existing in the database
DROP TABLE IF EXISTS `product`;

-- Table creation
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    brand VARCHAR(255),
    price DECIMAL(38,2),
    category VARCHAR(255),
    release_date DATETIME(6),
    product_available BIT NOT NULL,
    stock_quantity INT NOT NULL,
    image_name VARCHAR(255),
    image_type VARCHAR(255),
    image_date LONGBLOB
);

-- Data population
INSERT INTO Product (name, description, brand, price, category, release_date, product_available, stock_quantity) VALUES
('Laptop', 'High-performance laptop', 'TechBrand', 1200.50, 'Electronics', '2023-10-10', true, 50),
('Smartphone', 'Latest model smartphone', 'MobileTech', 800.00, 'Electronics', '2024-01-15', true, 200),
('Headphones', 'Noise-cancelling headphones', 'SoundCorp', 150.75, 'Accessories', '2022-11-20', true, 100),
('Coffee Maker', 'Automatic coffee maker', 'KitchenPro', 89.99, 'Home Appliances', '2023-05-05', true, 40),
('Office Chair', 'Ergonomic office chair', 'ComfortSeats', 220.30, 'Furniture', '2024-02-12', true, 30),
('Gaming Console', 'Next-gen gaming console', 'GameWorld', 499.99, 'Electronics', '2023-12-01', true, 75),
('Electric Toothbrush', 'Rechargeable electric toothbrush', 'OralHealth', 29.99, 'Personal Care', '2024-03-07', true, 150),
('Blender', 'High-speed blender', 'KitchenGadget', 99.95, 'Home Appliances', '2023-06-18', true, 60),
('LED TV', '50-inch 4K UHD TV', 'VisionTech', 650.00, 'Electronics', '2023-09-25', true, 20),
('Fitness Tracker', 'Waterproof fitness tracker', 'FitWear', 79.90, 'Wearable Tech', '2023-08-30', true, 90);