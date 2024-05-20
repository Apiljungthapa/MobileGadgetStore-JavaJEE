-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2024 at 08:48 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bytebazzar`
--

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
  `product_id` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `cart_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`product_id`, `user_id`, `quantity`, `cart_id`) VALUES
('PRD009', 'rashmideep1', '1', 'CRD001'),
('PRD010', 'mirajbhandari1', '2', 'CRD001'),
('PRD002', 'Ayub_bhatta1', '2', 'CRD001');

-- --------------------------------------------------------

--
-- Table structure for table `inquiry`
--

CREATE TABLE `inquiry` (
  `Inquiry_ID` varchar(50) NOT NULL,
  `User_ID` varchar(50) DEFAULT NULL,
  `Subject` varchar(255) NOT NULL,
  `Created_at` date DEFAULT NULL,
  `Message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `Order_ID` varchar(50) NOT NULL,
  `User_ID` varchar(50) NOT NULL,
  `Total_Amount` decimal(10,2) NOT NULL,
  `Status` enum('Pending','Delivered','Canceled') NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `payment` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`Order_ID`, `User_ID`, `Total_Amount`, `Status`, `city`, `address`, `payment`) VALUES
('306d4c0a-323b-440b-b878-50e18eaa5bca', 'Ayub_bhatta1', 1680.00, 'Pending', 'kathmandu', 'Kamalpokhari', 'Khalti');

-- --------------------------------------------------------

--
-- Table structure for table `order_products`
--

CREATE TABLE `order_products` (
  `Order_ID` varchar(50) NOT NULL,
  `Product_ID` varchar(50) NOT NULL,
  `Line_Quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_products`
--

INSERT INTO `order_products` (`Order_ID`, `Product_ID`, `Line_Quantity`) VALUES
('306d4c0a-323b-440b-b878-50e18eaa5bca', 'PRD002', 2),
('306d4c0a-323b-440b-b878-50e18eaa5bca', 'PRD009', 1),
('306d4c0a-323b-440b-b878-50e18eaa5bca', 'PRD010', 2);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `Product_ID` varchar(50) NOT NULL,
  `Product_Name` varchar(255) NOT NULL,
  `Screen_Size` varchar(50) NOT NULL,
  `Processor` varchar(100) NOT NULL,
  `RAM` varchar(50) NOT NULL,
  `Features` text NOT NULL,
  `Discount` decimal(4,2) NOT NULL,
  `Storage` varchar(100) NOT NULL,
  `Camera` varchar(100) NOT NULL,
  `Warranty` varchar(100) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `Discount_Amount` decimal(8,2) NOT NULL,
  `Image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`Product_ID`, `Product_Name`, `Screen_Size`, `Processor`, `RAM`, `Features`, `Discount`, `Storage`, `Camera`, `Warranty`, `price`, `Discount_Amount`, `Image`) VALUES
('PRD002', 'iPhone 13 Pro Max', '6.7 inches', 'A15 Bionic', '6GB', 'High-end iPhone with powerful performance, advanced camera features, and sleek design.', 12.00, '128GB', '126MP', '1 year', 7000.00, 840.00, '/ByteBazzar/images/product_images/iphone 13 max.jpg'),
('PRD003', 'OnePlus 9 Pro', '6.7 inches', 'Qualcomm Snapdragon 880', '12GB', 'Flagship phone with smooth performance, vibrant display, and impressive camera capabilities.', 8.00, '64GB', '120MP', '1.5 years', 112500.00, 9000.00, '/ByteBazzar/images/product_images/oneplus 9pro.jpeg'),
('PRD004', 'Google Pixel 6 Pro', '6.7 inches', 'Qualcomm Snapdragon 111', '12GB', 'Google\'s flagship offering with cutting-edge camera technology, stock Android experience, and premium design', 9.00, '126GB', '60MP', '1.5 years', 99500.00, 8955.00, '/ByteBazzar/images/product_images/google pixel 6 pro.jpeg'),
('PRD005', 'Xiaomi Mi 11 Ultra', '6.81 inches', 'Qualcomm Snapdragon 777', '12GB', 'Feature-packed flagship device with innovative camera features, powerful performance, and high-resolution display.', 8.00, '82GB', '52MP', '1.5 years', 105000.00, 8400.00, '/ByteBazzar/images/product_images/XiaomiMi11Ultra.jpeg'),
('PRD006', 'Samsung Galaxy Z Fold 3', '7.6 inches', 'MOTOROLLA A15', '12GB', 'Foldable smartphone with a large inner display, improved durability, and multitasking capabilities.', 20.00, '256GB', '100MP', '2 years', 180000.00, 36000.00, '/ByteBazzar/images/product_images/Samsung Galaxy Z Fold 3.jpeg'),
('PRD007', 'iPhone SE (2022)', '4.7 inches', 'A19 Bionic', '4GB', 'Compact iPhone with powerful performance, updated internals, and affordable price point.', 6.00, '302GB', '128MP', '1 year', 49500.00, 2970.00, '/ByteBazzar/images/product_images/iPhone SE (2022).jpeg'),
('PRD008', 'OnePlus Nord 2', '6.43 inches', 'MediaTek Dimensity 1200-AI', '8GB', 'Mid-range smartphone with solid performance, 5G connectivity, and clean OxygenOS experience.', 8.00, '56GB', '199MP', '3 years', 39999.00, 3199.92, '/ByteBazzar/images/product_images/OnePlus Nord 2.jpeg'),
('PRD009', 'Xiaomi Redmi Note 11 Pro', '6.67 inches', 'MediaTek Dimensity 920', '6GB', 'Budget-friendly smartphone with impressive camera capabilities, long battery life, and sleek design.', 8.00, '64GB', '74MP', '1 year', 29999.00, 2399.92, '/ByteBazzar/images/product_images/Xiaomi Redmi Note 11 Pro.jpeg'),
('PRD010', 'Realme GT 2 Pro', '6.7 inches', 'Qualcomm Snapdragon 8 Gen 1', '12GB', 'Performance-oriented flagship device with top-tier specifications, sleek design, and impressive camera features.', 9.00, '126GB', '86MP', '3 years', 74999.00, 6749.91, '/ByteBazzar/images/product_images/Realme GT 2 Pro.jpeg'),
('PRD011', 'Sony Xperia 5 III', '6.1 inches', 'Snapdragon 888', '8GB', 'Premium smartphone with advanced camera features, sleek design, and ample storage.', 10.00, '256GB', '102MP', '4 years', 99999.00, 9999.90, '/ByteBazzar/images/product_images/Sony Xperia 5 III.jpeg'),
('PRD012', 'Motorola Edge 20 Pro', '6.7 inches', 'Snapdragon 870', '8GB', 'Stylish device prioritizing camera capabilities, suitable for everyday use.', 7.00, '256GB', '64MP', '1 years', 79999.00, 5599.93, '/ByteBazzar/images/product_images/Motorola Edge 20 Pro.jpeg'),
('PRD013', 'ASUS ROG Phone 5', '6.78 inches', 'Snapdragon 888', '16GB', 'Gaming-oriented smartphone with powerful hardware and extensive storage.', 12.00, '126GB', '264MP', '3 years', 149999.00, 17999.88, '/ByteBazzar/images/product_images/ASUS ROG Phone 5.jpeg'),
('PRD014', 'Nokia X100', '6.67 inches', 'Snapdragon 480 5G', '6GB', 'Affordable 5G option with decent camera performance and long-lasting battery.', 6.00, '226GB', '34MP', '1 years', 34999.00, 2099.94, '/ByteBazzar/images/product_images/Nokia X100.jpeg'),
('PRD015', 'LG Velvet 2 Pro', '6.8 inches', 'Snapdragon 888', '8GB', 'Elegant smartphone offering versatile camera options and smooth performance.', 9.00, '256GB', '64MP', '1 year', 89999.00, 8099.91, '/ByteBazzar/images/product_images/LG Velvet 2 Pro.jpeg'),
('PRD016', 'Oppo Find X3 Pro', '6.7 inches', 'Snapdragon 888', '12GB', 'Flagship device with superior camera capabilities and excellent display quality.', 10.00, '256GB', '128MP', '2 years', 119999.00, 11999.90, '/ByteBazzar/images/product_images/Oppo Find X3 Pro.jpeg'),
('PRD017', 'Vivo X60 Pro+', '6.56 inches', 'Snapdragon 888', '12GB', 'Premium handset with advanced photography features and a sleek design.', 8.00, '126GB', '64MP', '2 years', 84999.00, 6799.92, '/ByteBazzar/images/product_images/ivo X60 Pro+.jpeg'),
('PRD018', 'Xiaomi Poco F3', '6.67 inches', 'Snapdragon 870', '12GB', 'Affordable device offering impressive camera functionality and smooth performance.', 10.00, '128GB', '87MP', '2.5 years', 39999.00, 3999.90, '/ByteBazzar/images/product_images/Xiaomi Poco F3.jpeg'),
('PRD019', 'Realme GT Neo 2', '6.62 inches', 'Snapdragon 870', '12GB', 'Mid-range smartphone with strong performance and decent camera capabilities.', 10.00, '126GB', '84MP', '1.5 years', 49999.00, 4999.90, '/ByteBazzar/images/product_images/Realme GT Neo 2.jpeg'),
('PRD020', 'Lenovo Legion Phone Duel 2', '6.7 inches', 'Exynos 2100 ', '16GB', 'Gaming-focused device with powerful hardware and innovative design.', 8.00, '256GB', '64MP', '1 year', 129999.00, 10399.92, '/ByteBazzar/images/product_images/Lenovo Legion Phone Duel 2.jpeg'),
('PRD021', 'Huawei P50 Pro', '6.6 inches', 'Kirin 9000', '16GB', 'Premium flagship phone with a focus on photography and sleek design.', 9.00, '512GB', '120MP', '1 year', 129999.00, 11699.91, '/ByteBazzar/images/product_images/Huawei P50 Pro.jpeg'),
('PRD022', 'ZTE Axon 30 Ultra', '6.67 inches', 'Snapdragon 888', '6GB', 'High-performance smartphone with a focus on photography and multimedia.', 6.00, '128GB', '54MP', '3 years', 89999.00, 5399.94, '/ByteBazzar/images/product_images/ZTE Axon 30 Ultra.jpeg'),
('PRD023', 'Nokia G50', '6.82 inches', 'Snapdragon 480', '4GB', 'Budget-friendly device with reliable performance and essential features.', 10.00, '126GB', '124MP', '1.5 years', 24999.00, 2499.90, '/ByteBazzar/images/product_images/Nokia G50.jpeg'),
('PRD024', 'Motorola Moto G Power (2022)', '6.8 inches', 'Snapdragon 680', '4GB', 'Mid-range smartphone with long battery life and solid camera performance.', 8.00, '66GB', '14MP', '2 years', 18999.00, 1519.92, '/ByteBazzar/images/product_images/Motorola Moto G Power.jpeg'),
('PRD025', 'Sony Xperia 10 III', '6.0 inches', 'Snapdragon 690', '6GB', 'Premium mid-range phone with an emphasis on camera quality and immersive display.', 9.00, '256GB', '64MP', '1 year', 44999.00, 4049.91, '/ByteBazzar/images/product_images/Sony Xperia 10 III.jpeg'),
('PRD026', 'BlackBerry Key3', '6.5 inches', 'Snapdragon 778G', '8GB', 'Iconic smartphone with a physical keyboard and focus on security and productivity.', 6.00, '256GB', '16MP', '1.5 years', 69999.00, 4199.94, '/ByteBazzar/images/product_images/BlackBerry Key3.jpeg'),
('PRD027', 'Xiaomi Redmi K40 Gaming Edition', '6.8 inches', 'Dimensity 1200', '6GB', 'Gaming-focused device with powerful hardware and advanced camera capabilities.', 5.00, '126GB', '10MP', '1 year', 34999.00, 1749.95, '/ByteBazzar/images/product_images/Xiaomi Redmi K40 Gaming Edition.jpeg'),
('PRD028', 'Realme Narzo 50A', '6.7 inches', 'MediaTek Helio G85', '6GB', 'Budget-friendly smartphone with a large display and decent camera performance.', 9.00, '126GB', '14MP', '2 years', 30000.00, 2700.00, '/ByteBazzar/images/product_images/Realme Narzo 50A.jpeg'),
('PRD029', 'OPPO Reno7 Pro 5G', '5.6 inches', 'Dimensity 1200', '6GB', 'Premium 5G smartphone with a focus on photography and sleek design.', 10.00, '126GB', '24MP', '2 years', 39999.00, 3999.90, '/ByteBazzar/images/product_images/OPPO Reno7 Pro 5G.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `User_ID` varchar(50) NOT NULL,
  `Full_Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Phone_Number` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Role` varchar(50) NOT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `IMG_LINK` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`User_ID`, `Full_Name`, `Email`, `Password`, `Phone_Number`, `Gender`, `Role`, `ADDRESS`, `IMG_LINK`) VALUES
('apil12', 'APIL THAPA', 'apil@gmail.com', '501hzdzSAKIwBsnUzGSTfzfPiE2SxlLB0rt/9UQ/DDQp42xqMWzxDKtv+61UdeI+6M2Kh8ci', '+9779867004146', 'Male', 'admin', NULL, NULL),
('Ayub_bhatta1', 'AYUB BHATTA', 'bhatta.ayub1263@gmail.com', 'NSEWCmJ6p5JSb0PsXgldgGqESBzXAIecWsYm2w/WV6SlTo4Wqu+Xp4+ZNoirUVCH8aG1mISB', '+9779863589173', 'Male', 'user', NULL, NULL),
('mirajbhandari1', 'Ayub Bhattarai', 'mirajdeepbhandari@gmail.com', 'N5ZX7EwZX8TCyzP4c4BquWRMyci9J2LI0aFgZ+vORYOZZDM41lRk6RDuvdYeK5zecopdgDgKCQ==', '+9779888998822', 'Male', 'user', 'dillibazar', '/ByteBazzar/resources/images/users/Ayub.jpg'),
('rashmideep1', 'RASHMI DEEP', 'rashmi@gmail.com', 'eso7ZifS0QsrOcSsv5a8o4YvtxTlNJhYUYkHusYstrYBQAzKi19tnlMEieU1QU+CK7yGESk=', '+9779844341570', 'Male', 'user', NULL, '/ByteBazzar/resources/images/users/download (3).jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD KEY `product_id` (`product_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `inquiry`
--
ALTER TABLE `inquiry`
  ADD PRIMARY KEY (`Inquiry_ID`),
  ADD KEY `User_ID` (`User_ID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Order_ID`),
  ADD KEY `User_ID` (`User_ID`);

--
-- Indexes for table `order_products`
--
ALTER TABLE `order_products`
  ADD PRIMARY KEY (`Order_ID`,`Product_ID`),
  ADD KEY `Product_ID` (`Product_ID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`Product_ID`),
  ADD UNIQUE KEY `Product_Name` (`Product_Name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`User_ID`),
  ADD UNIQUE KEY `User_ID` (`User_ID`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Phone_Number` (`Phone_Number`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `carts_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`Product_ID`),
  ADD CONSTRAINT `carts_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`User_ID`);

--
-- Constraints for table `inquiry`
--
ALTER TABLE `inquiry`
  ADD CONSTRAINT `inquiry_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`);

--
-- Constraints for table `order_products`
--
ALTER TABLE `order_products`
  ADD CONSTRAINT `order_products_ibfk_1` FOREIGN KEY (`Order_ID`) REFERENCES `orders` (`Order_ID`),
  ADD CONSTRAINT `order_products_ibfk_2` FOREIGN KEY (`Product_ID`) REFERENCES `products` (`Product_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
