-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2018 at 06:04 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `new_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `khoahoc`
--

CREATE TABLE `khoahoc` (
  `id` int(11) NOT NULL,
  `name` varchar(125) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khoahoc`
--

INSERT INTO `khoahoc` (`id`, `name`) VALUES
(1, 'Sinovac Biotech, Ltd.'),
(2, 'Blackrock MuniAssets Fund, Inc.'),
(3, 'Post Holdings, Inc.'),
(4, 'Ameren Corporation'),
(5, 'UroGen Pharma Ltd.'),
(6, 'Universal Health Services, Inc.'),
(7, 'Public Storage'),
(8, 'Allegiant Travel Company'),
(9, 'NCI, Inc.'),
(10, 'Premier Financial Bancorp, Inc.');

-- --------------------------------------------------------

--
-- Table structure for table `lophoc`
--

CREATE TABLE `lophoc` (
  `id_sv` int(11) NOT NULL,
  `id_kh` int(11) NOT NULL,
  `siso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lophoc`
--

INSERT INTO `lophoc` (`id_sv`, `id_kh`, `siso`) VALUES
(7, 1, 32),
(8, 4, 34),
(7, 3, 51);

-- --------------------------------------------------------

--
-- Table structure for table `sinhvien`
--

CREATE TABLE `sinhvien` (
  `id` int(11) NOT NULL,
  `name` varchar(125) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(125) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sinhvien`
--

INSERT INTO `sinhvien` (`id`, `name`, `address`, `phone`) VALUES
(1, 'Claribel Wisam', '393 Washington Alley', '294-428-9853'),
(2, 'Kacey Holburn', '641 Mifflin Plaza', '302-281-4102'),
(3, 'Margi Levensky', '337 Hoepker Terrace', '612-695-4214'),
(4, 'Philippe Brand-Hardy', '802 American Hill', '324-702-5880'),
(5, 'Vasilis Manners', '335 Stephen Crossing', '798-653-1239'),
(6, 'Morganne Peltz', '57 Hayes Hill', '970-413-9097'),
(7, 'Foss Gorcke', '44 Talisman Trail', '891-680-2230'),
(8, 'Maryellen Peerless', '8 Gulseth Parkway', '867-515-9699'),
(9, 'Oralia Gunter', '31212 Victoria Pass', '577-751-0572'),
(10, 'Dani Margery', '33657 Holmberg Circle', '146-364-7730');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `khoahoc`
--
ALTER TABLE `khoahoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lophoc`
--
ALTER TABLE `lophoc`
  ADD KEY `id_sv` (`id_sv`),
  ADD KEY `id_kh` (`id_kh`);

--
-- Indexes for table `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `khoahoc`
--
ALTER TABLE `khoahoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `sinhvien`
--
ALTER TABLE `sinhvien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `lophoc`
--
ALTER TABLE `lophoc`
  ADD CONSTRAINT `lophoc_ibfk_1` FOREIGN KEY (`id_sv`) REFERENCES `sinhvien` (`id`),
  ADD CONSTRAINT `lophoc_ibfk_2` FOREIGN KEY (`id_kh`) REFERENCES `khoahoc` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
