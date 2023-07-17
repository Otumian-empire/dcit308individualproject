-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 17, 2023 at 06:48 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dcit_308_inventory_management_system_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `goodId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `dateBilled` date NOT NULL DEFAULT current_timestamp(),
  `customerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id`, `goodId`, `quantity`, `price`, `dateBilled`, `customerId`) VALUES
(1, 1, 5, 1200, '2023-07-16', 1),
(2, 2, 10, 100, '2023-07-16', 1),
(3, 2, 1, 10, '2023-07-16', 1),
(4, 3, 10, 50, '2023-07-16', 1),
(5, 3, 80, 400, '2023-07-16', 3),
(6, 3, 200, 1000, '2023-07-16', 1);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Beverages'),
(2, 'Bread/Bakery'),
(3, 'Canned/Jarred Goods'),
(4, 'Dairy Products'),
(5, 'Dry/Baking Goods'),
(6, 'Frozen Products'),
(7, 'Meat'),
(8, 'Farm Produce'),
(9, 'Home Cleaners'),
(10, 'Paper Goods'),
(11, 'Home Care');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `email`) VALUES
(1, 'John Doe', 'johndoe@email.com'),
(2, 'Jane Doe', 'janedoe@email.com'),
(3, 'Luda Smith', 'luda@email.com');

-- --------------------------------------------------------

--
-- Table structure for table `good`
--

CREATE TABLE `good` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `vendorId` int(11) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `good`
--

INSERT INTO `good` (`id`, `name`, `quantity`, `price`, `categoryId`, `vendorId`, `description`) VALUES
(1, 'Rice', 0, 20, 8, 3, 'A simple rice'),
(2, 'Apples', 89, 10, 8, 1, 'Red delicious apples'),
(3, 'Cow Milk', 9, 5, 1, 2, 'Whole milk'),
(4, 'Eggs', 399, 12, 0, 2, 'Free range eggs'),
(5, 'Bread', 189, 20, 2, 1, 'Whole wheat bread'),
(6, 'Cheese', 30, 399, 1, 2, 'Cheddar cheese'),
(7, 'Soup', 15, 299, 3, 3, 'Chicken noodle soup'),
(8, 'Toilet Paper', 12, 499, 6, 1, '12-pack of toilet paper'),
(9, 'Shampoo', 6, 599, 7, 2, '24-ounce bottle of shampoo'),
(10, 'Dish Soap', 8, 399, 7, 3, '12-ounce bottle of dish soap'),
(11, 'Oranges', 15, 149, 8, 1, 'Navel oranges'),
(12, 'Yogurt rice', 10, 199, 1, 2, 'Plain yogurt'),
(13, 'Cereal', 11, 249, 4, 3, 'Honey Nut Cheerios'),
(14, 'Coffee', 10, 499, 5, 1, 'Ground coffee'),
(15, 'Tea', 299, 8, 5, 1, 'Black tea'),
(16, 'Water', 24, 199, 7, 3, '12-pack of bottled water'),
(17, 'Pasta', 16, 149, 2, 1, 'Dry pasta'),
(18, 'White Rice', 12, 199, 2, 2, 'White rice'),
(19, 'Beans', 10, 149, 2, 3, 'Black beans'),
(20, 'Soda', 12, 249, 5, 1, 'Can of soda'),
(21, 'Beer', 6, 399, 5, 2, 'Bottle of beer'),
(22, 'Chicken', 10, 399, 3, 1, 'Boneless, skinless chicken breasts'),
(23, 'Beef', 8, 499, 3, 2, 'Ground beef'),
(24, 'Pork', 6, 399, 3, 3, 'Boneless, skinless pork chops'),
(25, 'Fish', 4, 299, 3, 1, 'Salmon fillets'),
(26, 'Shrimp', 2, 199, 3, 2, 'Frozen shrimp'),
(27, 'Eggs', 12, 149, 1, 3, 'Free range eggs'),
(28, 'Cheese', 10, 299, 1, 1, 'Cheddar cheese'),
(29, 'Milk', 5, 199, 1, 2, 'Whole milk'),
(30, 'Butter', 4, 399, 1, 3, 'Unsalted butter'),
(31, 'Yogurt', 8, 149, 1, 1, 'Greek yogurt'),
(32, 'Ice Cream', 6, 399, 5, 2, 'Vanilla ice cream'),
(33, 'Cookies', 4, 299, 4, 3, 'Chocolate chip cookies'),
(34, 'Cake', 2, 499, 4, 1, 'Chocolate cake'),
(35, 'Pie', 1, 299, 4, 2, 'Apple pie'),
(36, 'Candy', 10, 199, 5, 3, 'Assorted candies'),
(37, 'Chips', 8, 149, 5, 1, 'Bag of potato chips'),
(38, 'Blueberry', 20, 90, 8, 3, 'Something nice for the  tongue'),
(39, 'Note 3', 20, 12, 10, 1, 'simple note 3 books'),
(40, 'Sharpener', 5, 2, 10, 1, 'some normal sharpener'),
(41, 'soda powder', 4, 15, 2, 3, ''),
(42, 'Green Berry', 12, 5, 8, 3, 'sample green for the hulks'),
(43, 'Over fed Chicken meat', 5, 300, 7, 3, 'One lazy overfed chicken meat'),
(44, 'Bran bread', 12, 12, 5, 2, 'some burnt bread'),
(45, 'white bread', 2, 50, 2, 2, 'some alo whites bread'),
(46, 'frozen blue rice', 3, 140, 6, 2, 'what the hell'),
(47, 'greek washing powder', 20, 15, 9, 1, 'The best washing powder'),
(48, 'Mud fish', 2, 12, 3, 3, ''),
(49, 'Water melon', 1, 120, 1, 1, ''),
(50, 'kontomere', 40, 10, 8, 3, ''),
(51, 'red bean', 6, 6, 8, 3, 'who doesn\'t like red beans');

-- --------------------------------------------------------

--
-- Table structure for table `issued_good`
--

CREATE TABLE `issued_good` (
  `id` int(11) NOT NULL,
  `goodId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `dateIssued` date NOT NULL DEFAULT current_timestamp(),
  `customerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issued_good`
--

INSERT INTO `issued_good` (`id`, `goodId`, `quantity`, `dateIssued`, `customerId`) VALUES
(1, 1, 1, '2023-07-16', 3),
(2, 46, 3, '2023-07-16', 2),
(3, 15, 3, '2023-07-16', 3),
(4, 14, 120, '2023-07-16', 2),
(5, 45, 5, '2023-07-16', 1),
(6, 1, 1, '2023-07-16', 1),
(7, 15, 3, '2023-07-16', 3),
(8, 12, 12, '2023-07-16', 2),
(9, 1, 1, '2023-07-16', 1),
(10, 1, 1, '2023-07-16', 1),
(11, 1, 1, '2023-07-16', 1),
(12, 1, 0, '2023-07-16', 1),
(13, 1, -100, '2023-07-16', 1),
(14, 1, 2, '2023-07-16', 1),
(15, 1, 90, '2023-07-16', 1),
(16, 1, 7, '2023-07-16', 1),
(17, 1, 1, '2023-07-16', 1),
(18, 13, 1, '2023-07-16', 1),
(19, 5, 10, '2023-07-16', 2),
(20, 2, 10, '2023-07-16', 1),
(21, 2, 1, '2023-07-16', 1),
(22, 3, 10, '2023-07-16', 1),
(23, 3, 80, '2023-07-16', 3),
(24, 3, 200, '2023-07-16', 1);

-- --------------------------------------------------------

--
-- Table structure for table `new_table`
--

CREATE TABLE `new_table` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`id`, `name`, `email`) VALUES
(1, 'Acme Coprs', 'acme@gmail.com'),
(2, 'Big Apple Groceries', 'bigapple@gmail.com'),
(3, 'Farmer\'s Market', 'farmersmarket@email.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `good`
--
ALTER TABLE `good`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `issued_good`
--
ALTER TABLE `issued_good`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `new_table`
--
ALTER TABLE `new_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `good`
--
ALTER TABLE `good`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `issued_good`
--
ALTER TABLE `issued_good`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `new_table`
--
ALTER TABLE `new_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
