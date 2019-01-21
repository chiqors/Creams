-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 21, 2019 at 12:35 PM
-- Server version: 10.3.10-MariaDB-log
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `creams`
--

-- --------------------------------------------------------

--
-- Table structure for table `credit_restock`
--

CREATE TABLE `credit_restock` (
  `id_credit_restock` int(11) NOT NULL,
  `provider_name` varchar(20) NOT NULL,
  `type` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `kuota` int(11) NOT NULL,
  `expired_date` date NOT NULL,
  `balance_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `credit_restock_kuota`
--

CREATE TABLE `credit_restock_kuota` (
  `id_credit_restock_kuota` int(11) NOT NULL,
  `provider_name` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `balance_current` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `credit_restock_kuota`
--

INSERT INTO `credit_restock_kuota` (`id_credit_restock_kuota`, `provider_name`, `type`, `balance_current`) VALUES
(1, 'AXIS', 'Kuota', 150),
(2, 'Indosat', 'Kuota', 150),
(3, 'Smartfren', 'Kuota', 250),
(4, 'Telkomsel', 'Kuota', 150),
(5, 'TRI', 'Kuota', 150),
(6, 'XL', 'Kuota', 150);

-- --------------------------------------------------------

--
-- Table structure for table `credit_restock_plnpdam`
--

CREATE TABLE `credit_restock_plnpdam` (
  `id_credit_restock_plnpdam` int(11) NOT NULL,
  `no_pelanggan` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL,
  `customer_name` text NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer_credit`
--

CREATE TABLE `customer_credit` (
  `id_customer_credit` int(11) NOT NULL,
  `provider_name` varchar(20) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id_employee` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `employee_name` varchar(20) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id_employee`, `username`, `password`, `employee_name`, `role`) VALUES
(1, 'admin', 'admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `income`
--

CREATE TABLE `income` (
  `id_income` int(11) NOT NULL,
  `credit` int(11) NOT NULL,
  `credit_kuota` int(11) NOT NULL,
  `pln` int(11) NOT NULL,
  `pdam` int(11) NOT NULL,
  `outcome` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `credit_restock`
--
ALTER TABLE `credit_restock`
  ADD PRIMARY KEY (`id_credit_restock`);

--
-- Indexes for table `credit_restock_kuota`
--
ALTER TABLE `credit_restock_kuota`
  ADD PRIMARY KEY (`id_credit_restock_kuota`);

--
-- Indexes for table `credit_restock_plnpdam`
--
ALTER TABLE `credit_restock_plnpdam`
  ADD PRIMARY KEY (`id_credit_restock_plnpdam`),
  ADD UNIQUE KEY `no_pelanggan` (`no_pelanggan`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indexes for table `customer_credit`
--
ALTER TABLE `customer_credit`
  ADD PRIMARY KEY (`id_customer_credit`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id_employee`);

--
-- Indexes for table `income`
--
ALTER TABLE `income`
  ADD PRIMARY KEY (`id_income`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `credit_restock`
--
ALTER TABLE `credit_restock`
  MODIFY `id_credit_restock` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `credit_restock_kuota`
--
ALTER TABLE `credit_restock_kuota`
  MODIFY `id_credit_restock_kuota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `credit_restock_plnpdam`
--
ALTER TABLE `credit_restock_plnpdam`
  MODIFY `id_credit_restock_plnpdam` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer_credit`
--
ALTER TABLE `customer_credit`
  MODIFY `id_customer_credit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id_employee` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `income`
--
ALTER TABLE `income`
  MODIFY `id_income` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
