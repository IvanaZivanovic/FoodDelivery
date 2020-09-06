-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 06, 2020 at 03:33 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food_delivery`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id_address` int(11) NOT NULL,
  `city_a` varchar(50) NOT NULL,
  `zip_code` varchar(50) NOT NULL,
  `municipality_a` varchar(50) NOT NULL,
  `street_name` varchar(50) NOT NULL,
  `street_number` varchar(30) NOT NULL,
  `apartment_number` varchar(30) NOT NULL,
  `last_name_a` varchar(50) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id_address`, `city_a`, `zip_code`, `municipality_a`, `street_name`, `street_number`, `apartment_number`, `last_name_a`, `id_user`) VALUES
(1, 'Belgrade', '11000', 'Palilula', 'Cvijiceva', '57', '5', 'Apostolovic', 11),
(3, 'Belgrade', '11000', 'Zvezdara', 'Rtanjska', '8', '1', 'Petrovic', 11),
(4, 'Belgrade', '11000', 'Stari grad', 'Simina', '4', '13', 'Bozic', 15),
(5, 'Belgrade', '11000', 'Vozdovac', 'Jove Ilica', '72', '1', 'Bogdanovic', 16),
(8, 'Belgrade', '11000', 'Palilula', 'Dalmatinska', '28', '9', 'Jankovic', 18),
(9, 'Beograd', '11000', 'Palilula', 'Zdravka Celara', '10', '8', 'Bozic', 19),
(10, 'beograd', '11000', 'palilula', 'zdr cel', '6', '8', 'ocigrija bozic', 20),
(11, 'Beograd', '11000', 'Novi Beograd', 'Jurija Gagarina', '244', '27', 'Ostojic', 11);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id_category` int(11) NOT NULL,
  `name_category` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id_category`, `name_category`) VALUES
(1, 'Appetizer'),
(3, 'Pizza'),
(4, 'Sandwiches'),
(5, 'Pancakes'),
(6, 'Drinks'),
(7, 'Desserts'),
(8, 'Pasta'),
(9, 'Salads'),
(10, 'Side Dish'),
(11, 'Chicken'),
(12, 'Veal'),
(13, 'Pork'),
(14, 'Seafood'),
(16, 'Main Course'),
(17, 'Grilled Specialites'),
(18, 'Buritto'),
(19, 'Nachos'),
(20, 'Fajitas'),
(21, 'Salsas'),
(22, 'Savoury dumplings'),
(23, 'Sweet dumplings');

-- --------------------------------------------------------

--
-- Table structure for table `cuisine`
--

CREATE TABLE `cuisine` (
  `id_cuisine` int(11) NOT NULL,
  `name_cuisine` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cuisine`
--

INSERT INTO `cuisine` (`id_cuisine`, `name_cuisine`) VALUES
(1, 'Serbian Food'),
(2, 'Italian Food'),
(3, 'Mexican Food'),
(5, 'Chinese Food'),
(6, 'Pizza'),
(7, 'Grill'),
(8, 'Cooked meals'),
(9, 'Sandwiches'),
(10, 'Desserts'),
(11, 'Greek Food'),
(12, 'Drinks');

-- --------------------------------------------------------

--
-- Table structure for table `meal`
--

CREATE TABLE `meal` (
  `id_meal` int(11) NOT NULL,
  `name_meal` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `size` varchar(50) NOT NULL,
  `id_cuisine` int(11) NOT NULL,
  `id_category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `meal`
--

INSERT INTO `meal` (`id_meal`, `name_meal`, `price`, `size`, `id_cuisine`, `id_category`) VALUES
(5, 'Capricciosa', 800, 'XL 52cm', 2, 3),
(6, 'Vegetariana', 500, '32cm', 2, 3),
(7, 'Margarita', 350, '52cm', 2, 3),
(9, 'Pljeskavica', 250, 'Small 150g', 7, 17),
(10, 'Beef burito', 500, 'standard', 3, 18),
(11, 'Beer Lav', 100, '0.33', 12, 6),
(12, 'Giros', 400, 'XL 400g', 11, 16),
(13, 'Pork burito', 400, 'standard', 3, 18),
(14, 'Punjena pljeskavica', 340, '250g', 7, 17),
(15, 'Pljeskavica ', 280, '200g', 7, 17),
(16, 'Gurmanska pljeskavica', 340, '260g', 7, 17),
(17, 'Cevapi', 280, '200g', 7, 17),
(18, 'Vesalica', 300, '170g', 7, 17),
(19, 'Kobasica', 300, '200g', 7, 17),
(20, 'Pileci file', 310, '200g', 7, 17),
(21, 'Pileci batak', 300, '200g', 7, 17),
(22, 'Coca cola', 90, '0.33', 12, 6),
(23, 'Biter Lemon ', 90, '0.33', 12, 6),
(24, 'Knjaz Milos Water', 80, '0.5', 12, 6),
(25, 'Ham Sandwich', 190, 'Standard', 9, 4),
(26, 'Kulen Sandwich', 240, 'Standard', 9, 4),
(27, 'Kulen Pancake', 250, 'Standard', 1, 5),
(28, 'Eurocrem Pancake', 180, 'Standard', 1, 5),
(29, 'Pancake Nutella', 190, 'Standard', 1, 5),
(30, 'French Fries', 140, '200g', 1, 10),
(31, 'Chicken buritto', 400, 'Standard', 3, 18),
(32, 'Dumplings with four kinds of cheese', 100, 'standard', 10, 22),
(33, 'Dumplings with mushrooms and truffle oil', 100, 'Standard', 10, 22),
(34, 'Dumplings with spinach and mozzarella', 120, 'standard', 10, 22),
(35, 'Dried tomatoes, black olives, feta cheese', 120, 'standard', 10, 22),
(36, 'Prosciutto, mozzarella and rocket dumpling', 120, 'standard', 10, 22),
(37, 'Mexican dumpling', 120, 'standard', 10, 22),
(38, 'Dumplings with smoked chicken fillet', 120, 'standard', 10, 22),
(39, 'Greek dumpling', 120, 'standard', 10, 22),
(40, 'Broccoli quinoa dumpling', 100, 'standard', 10, 22),
(41, 'Dumpling with plums', 95, 'one size', 10, 23),
(42, 'Dumplings with apricots', 120, 'one siize', 10, 23),
(43, 'Dumplings with poppy seeds', 135, 'one size', 10, 23),
(44, 'Nutella dumpling', 135, 'one size', 10, 23),
(45, 'Raffaello dumpling', 140, 'one size', 10, 23),
(46, 'Dumplings with sweet cheese and raspberries', 140, 'one size', 10, 23),
(47, 'Raspberry oreo dumpling', 140, 'one size', 10, 23),
(48, 'Blackcurrant dumpling', 140, 'one size', 10, 23),
(49, 'Dumplings with black chocolate and cherries', 145, 'one size', 10, 23),
(50, 'Amareti dumplings', 150, 'one size', 10, 23),
(51, 'Dumpling caramel, peanuts', 160, 'one size', 10, 23),
(52, 'Marzipan dumplings', 170, 'one size', 10, 23),
(53, 'Queen Mary dumplings', 170, 'one size', 10, 23),
(54, 'Dumplings with pistachio and raspberry', 170, 'one size', 10, 23),
(55, 'Royal dumpling', 180, 'one size', 10, 23);

-- --------------------------------------------------------

--
-- Table structure for table `meal_order`
--

CREATE TABLE `meal_order` (
  `id_meal_order` int(11) NOT NULL,
  `id_meal` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `comment` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `meal_order`
--

INSERT INTO `meal_order` (`id_meal_order`, `id_meal`, `id_order`, `quantity`, `comment`) VALUES
(2, 6, 6, 2, 'bez kečapa'),
(3, 7, 7, 2, ''),
(9, 10, 11, 2, ''),
(10, 10, 12, 1, ''),
(11, 13, 12, 1, ''),
(12, 16, 13, 1, 'luk, paradajz, majonez'),
(13, 20, 13, 1, 'senf'),
(14, 11, 13, 1, ''),
(15, 22, 13, 1, ''),
(16, 17, 14, 1, 'luk, kajmak'),
(17, 19, 14, 1, 'senf, urnebes'),
(18, 23, 14, 1, ''),
(19, 14, 15, 1, 'luk!!!'),
(20, 11, 15, 1, ''),
(21, 18, 15, 1, ''),
(22, 13, 16, 1, 'ekstra paradajz'),
(23, 31, 17, 2, 'oba sa ekstra kecapom'),
(24, 22, 17, 2, ''),
(25, 13, 18, 1, ''),
(26, 22, 18, 2, ''),
(27, 20, 19, 1, 'hocu majonez'),
(28, 17, 19, 1, ''),
(29, 17, 19, 1, ''),
(30, 16, 20, 2, 'majonez\nurnebes\nmalo luka\nvegeta'),
(31, 22, 20, 1, ''),
(32, 24, 20, 1, ''),
(33, 29, 20, 2, ''),
(34, 14, 21, 1, 'luk'),
(35, 20, 21, 1, 'senf'),
(36, 11, 21, 1, ''),
(37, 22, 21, 1, ''),
(38, 29, 21, 2, ''),
(39, 6, 22, 2, ''),
(40, 20, 23, 2, ''),
(41, 14, 24, 1, 'luk\nparadajz\nurnebes'),
(42, 20, 24, 1, 'senf\nparadajz'),
(43, 28, 24, 2, ''),
(44, 11, 24, 1, ''),
(45, 22, 24, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `meal_restaurant`
--

CREATE TABLE `meal_restaurant` (
  `id_meal_restaurant` int(11) NOT NULL,
  `id_restaurant` int(11) NOT NULL,
  `id_meal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `meal_restaurant`
--

INSERT INTO `meal_restaurant` (`id_meal_restaurant`, `id_restaurant`, `id_meal`) VALUES
(1, 3, 6),
(2, 3, 7),
(4, 3, 10),
(5, 3, 11),
(6, 13, 10),
(7, 13, 13),
(8, 10, 9),
(9, 10, 14),
(10, 10, 16),
(11, 10, 17),
(12, 10, 18),
(13, 10, 20),
(14, 10, 19),
(15, 10, 11),
(16, 10, 22),
(17, 10, 23),
(18, 10, 24),
(19, 13, 31),
(20, 13, 11),
(21, 13, 22),
(22, 13, 23),
(23, 13, 24),
(24, 10, 28),
(25, 10, 29),
(26, 3, 28),
(27, 3, 29),
(28, 18, 40),
(29, 18, 35),
(30, 18, 32),
(31, 18, 33),
(32, 18, 38),
(33, 18, 34),
(34, 18, 39),
(35, 18, 37),
(36, 18, 36),
(37, 18, 50),
(38, 18, 48),
(39, 18, 51),
(40, 18, 41),
(41, 18, 42),
(42, 18, 49),
(43, 18, 54),
(44, 18, 43),
(45, 18, 46),
(46, 18, 52),
(47, 18, 44),
(48, 18, 45),
(49, 18, 47),
(50, 18, 55);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id_order` int(11) NOT NULL,
  `amount` double NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `status` varchar(100) NOT NULL,
  `message_order` varchar(500) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_address` int(11) NOT NULL,
  `id_restaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id_order`, `amount`, `date`, `time`, `status`, `message_order`, `id_user`, `id_address`, `id_restaurant`) VALUES
(6, 1000, '2020-08-27', '12:20:00', 'rejected', '', 11, 3, 3),
(7, 700, '2020-08-29', '18:51:00', 'accepted', 'Estimated delivery time is 40 minutes.', 15, 4, 3),
(11, 1000, '2020-08-30', '09:58:04', 'accepted', 'Estimated delivery time is 67 minutes.', 15, 4, 13),
(12, 900, '2020-08-30', '10:56:08', 'accepted', 'Estimated delivery time is 55 minutes.', 15, 4, 13),
(13, 840, '2020-08-30', '20:21:53', 'accepted', 'Estimated delivery time is 33 minutes.', 15, 4, 10),
(14, 670, '2020-08-30', '20:25:31', 'accepted', 'Estimated delivery time is 90 minutes.', 16, 5, 10),
(15, 740, '2020-08-30', '23:18:54', 'accepted', 'Estimated delivery time is 80 minutes. Contact phone number is 060/000000.', 16, 5, 10),
(16, 400, '2020-08-30', '23:24:32', 'accepted', 'Estimated delivery time is 37 minutes. Contact phone number is 062/222333.', 18, 8, 13),
(17, 980, '2020-08-31', '16:15:17', 'accepted', 'Estimated delivery time is 45 minutes. Contact phone number is 011/777888.', 18, 8, 13),
(18, 580, '2020-09-02', '11:34:25', 'accepted', 'Estimated delivery time is 70 minutes. Contact phone number is 06978520.', 19, 9, 13),
(19, 870, '2020-09-02', '11:41:19', 'accepted', 'Estimated delivery time is 45 minutes. Contact phone number is 0639874569.', 19, 9, 10),
(20, 1230, '2020-09-02', '12:15:23', 'accepted', 'Estimated delivery time is 45 minutes. Contact phone number is 63653675.', 20, 10, 10),
(21, 1220, '2020-09-03', '19:57:32', 'accepted', 'Estimated delivery time is 72 minutes. Contact phone number is 063111222.', 11, 1, 10),
(22, 1000, '2020-09-03', '23:55:46', 'rejected', '/', 11, 1, 3),
(23, 620, '2020-09-04', '00:04:44', 'rejected', '/', 16, 5, 10),
(24, 1200, '2020-09-04', '11:05:39', 'accepted', 'Estimated delivery time is 52 minutes. Contact phone number is 060/111-222.', 16, 5, 10);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `id_restaurant` int(11) NOT NULL,
  `name_restaurant` varchar(100) NOT NULL,
  `min_order` double NOT NULL,
  `city` varchar(100) NOT NULL,
  `municipality` varchar(100) NOT NULL,
  `open_time` time NOT NULL,
  `close_time` time NOT NULL,
  `photo_restaurant` varchar(100) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`id_restaurant`, `name_restaurant`, `min_order`, `city`, `municipality`, `open_time`, `close_time`, `photo_restaurant`, `id_user`) VALUES
(1, 'The Saint', 600, 'Belgrade', 'Zvezdara', '10:00:00', '23:55:00', 'photos/logo/theSaint_logo.png', 2),
(2, 'Walter 2', 1000, 'Belgrade', 'Stari Grad', '10:00:00', '23:30:00', 'photos/logo/walter-logo.png', 3),
(3, 'Napoli', 600, 'Belgrade', 'Dusanovac', '09:00:00', '22:45:00', 'photos/logo/napoli_logo.JPG', 4),
(4, 'K2', 500, 'Belgrade', 'Palilula', '10:30:00', '23:15:00', 'photos/logo/k2-logo.png', 5),
(5, 'Zapata', 1350, 'Belgrade', 'Vracar', '10:00:00', '23:00:00', 'photos/logo/zapata-logo.jpg', 6),
(9, 'Etno Restoran Zlatar', 100, 'Belgrade', 'Palilula', '11:00:00', '23:30:00', 'photos/logo/zlatar-logo.JPG', 7),
(10, 'Pile&Prase', 600, 'Belgrade', 'Vracar', '11:00:00', '23:30:00', 'photos/logo/pile_prase_logo.jpg', 8),
(12, 'Solunac Terazije', 100, 'Belgrade', 'Stari Grad', '10:00:00', '23:00:00', 'photos/logo/solunac_logo.JPG', 9),
(13, 'Burito Madre', 100, 'Belgrade', 'Stari Grad', '10:00:00', '23:15:00', 'photos/logo/burito_madre_logo.png', 10),
(16, 'Haos Food', 1200, 'Belgrade', 'Savski venac', '10:30:00', '23:45:00', 'photos/logo/haos-food-logo.JPG', 12),
(17, 'Grill 51', 700, 'Belgrade', 'Zvezdara', '10:00:00', '23:00:00', 'photos/logo/grill51-logo.JPG', 14),
(18, 'Ferdinand Knedle', 250, 'Belgrade', 'Savski Venac', '09:00:00', '21:30:00', 'photos/logo/ferdinand-logo.JPG', 13);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_category`
--

CREATE TABLE `restaurant_category` (
  `id_restaurant_category` int(11) NOT NULL,
  `id_restaurant` int(11) NOT NULL,
  `id_category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurant_category`
--

INSERT INTO `restaurant_category` (`id_restaurant_category`, `id_restaurant`, `id_category`) VALUES
(1, 3, 3),
(3, 3, 4),
(7, 3, 7),
(8, 3, 5),
(9, 3, 6),
(12, 1, 3),
(13, 1, 8),
(14, 1, 4),
(15, 1, 6),
(16, 1, 9),
(17, 2, 17),
(18, 2, 9),
(19, 2, 10),
(20, 2, 7),
(21, 2, 5),
(22, 2, 6),
(23, 10, 17),
(24, 10, 4),
(25, 10, 5),
(26, 10, 6),
(27, 10, 7),
(28, 3, 8),
(29, 13, 18),
(30, 13, 19),
(32, 13, 9),
(33, 13, 7),
(34, 13, 6),
(35, 17, 17),
(36, 17, 11),
(37, 17, 4),
(38, 17, 9),
(39, 17, 5),
(40, 17, 6),
(41, 5, 6),
(42, 5, 1),
(43, 5, 20),
(44, 5, 21),
(45, 5, 10),
(46, 18, 22),
(47, 18, 23);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_cuisine`
--

CREATE TABLE `restaurant_cuisine` (
  `id_restaurant_cuisine` int(11) NOT NULL,
  `id_restaurant` int(11) NOT NULL,
  `id_cuisine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurant_cuisine`
--

INSERT INTO `restaurant_cuisine` (`id_restaurant_cuisine`, `id_restaurant`, `id_cuisine`) VALUES
(1, 3, 2),
(14, 3, 1),
(25, 3, 6),
(28, 1, 2),
(29, 1, 6),
(30, 1, 9),
(31, 13, 3),
(32, 17, 7),
(33, 5, 3),
(35, 2, 7),
(36, 2, 12),
(38, 2, 10),
(39, 18, 10),
(41, 17, 12),
(42, 17, 10),
(43, 17, 1),
(45, 5, 12),
(46, 5, 10),
(47, 4, 5),
(48, 4, 10),
(49, 4, 12),
(50, 9, 1),
(51, 9, 8),
(52, 9, 10),
(53, 9, 12),
(54, 16, 2),
(55, 16, 9),
(56, 16, 10),
(57, 16, 12);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `name_role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `name_role`) VALUES
(1, 'super_admin'),
(2, 'admin_restaurant'),
(3, 'user_customer');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `first_name`, `last_name`, `email`, `phone_number`, `username`, `password`, `status`) VALUES
(1, 'Ivana', 'Zivanovic', 'dgb.ivana@gmail.com', '063339555', 'ivana', 'ivana', 0),
(2, 'The Saint', '/', 'thesaint@gmail.com', '062689889', 'thesaint', 'thesaint', 0),
(3, 'Walter 2', '/', 'walter2@gmail.com', '0113300008', 'walter2', 'walter2', 0),
(4, 'Napoli', '/', 'napoli@gmail.com', '0641116999', 'napoli', 'napoli', 0),
(5, 'K2', '/', 'k2@gmail.com', '0603349778', 'k2', 'k2', 0),
(6, 'Zapata', '/', 'zapata@gmail.com', ' 0113809207', 'zapata', 'zapata', 0),
(7, 'Etno restoran Zlatar', '/', 'restoranzlatar@gmail.com', '0116754651', 'zlatar', 'zlatar', 0),
(8, 'Pile&Prase', '/', 'pileprase@gmail.com', '0600666696', 'pileprase', 'pileprase', 0),
(9, 'Solunac Terazije', '/', 'solunacterazije@gmail.com', '0113626202', 'solunacterazije', 'solunacterazije', 0),
(10, 'Burito Madre', '/', 'buritomadre@gmail.com', '0113037450', 'buritomadre', 'buritomadre', 0),
(11, 'Pera', 'Peric', 'pera@gmail.com', '0641234567', 'pera', 'pera', 0),
(12, 'Haos Food', '/', 'haosfood@gmail.com', '0113615245', 'haosfood', 'haosfood', 0),
(13, 'Ferdinand Knedle', '/', 'ferdinandknedle@gmail.com', '0611957092', 'ferdinandknedle', 'ferdinandknedle', 0),
(14, 'Grill 51', '/', 'gril51@gmail.com', '0652426716', 'grill51', 'grill51', 0),
(15, 'Marko', 'Markovic', 'marko@gmail.com', '063/524821', 'marko', 'marko', 0),
(16, 'Mina', 'Mirkovic', 'mina@gmail.com', '063/333333', 'mina', 'mina', 0),
(18, 'Aleksandra', 'Dutoit', 'saska@gmail.com', '064/222222', 'saska', 'saska', 0),
(19, 'Ivana', 'Bozic', 'bozicivana@yahoo.com', '0601234567', 'IvanaZa', 'ventilator', 0),
(20, 'Ognjen', 'Ocigrija', 'nebibilolose@hotmail.com', '31431431', 'ognjen', 'ventilator', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id_user`, `id_role`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2),
(11, 3),
(12, 2),
(13, 2),
(14, 2),
(15, 3),
(16, 3),
(18, 3),
(19, 3),
(20, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id_address`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_category`);

--
-- Indexes for table `cuisine`
--
ALTER TABLE `cuisine`
  ADD PRIMARY KEY (`id_cuisine`);

--
-- Indexes for table `meal`
--
ALTER TABLE `meal`
  ADD PRIMARY KEY (`id_meal`),
  ADD KEY `id_category` (`id_category`),
  ADD KEY `id_cuisine` (`id_cuisine`);

--
-- Indexes for table `meal_order`
--
ALTER TABLE `meal_order`
  ADD PRIMARY KEY (`id_meal_order`),
  ADD KEY `id_meal` (`id_meal`),
  ADD KEY `id_order` (`id_order`);

--
-- Indexes for table `meal_restaurant`
--
ALTER TABLE `meal_restaurant`
  ADD PRIMARY KEY (`id_meal_restaurant`),
  ADD KEY `id_meal` (`id_meal`),
  ADD KEY `id_restaurant` (`id_restaurant`) USING BTREE;

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_address` (`id_address`),
  ADD KEY `id_restaurant` (`id_restaurant`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id_restaurant`),
  ADD UNIQUE KEY `id_user` (`id_user`);

--
-- Indexes for table `restaurant_category`
--
ALTER TABLE `restaurant_category`
  ADD PRIMARY KEY (`id_restaurant_category`),
  ADD KEY `id_category` (`id_category`),
  ADD KEY `id_restaurant` (`id_restaurant`);

--
-- Indexes for table `restaurant_cuisine`
--
ALTER TABLE `restaurant_cuisine`
  ADD PRIMARY KEY (`id_restaurant_cuisine`),
  ADD KEY `id_cuisine` (`id_cuisine`),
  ADD KEY `id_restaurant` (`id_restaurant`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `email` (`email`,`username`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `user_role_ibfk_1` (`id_user`),
  ADD KEY `id_role` (`id_role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id_address` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `cuisine`
--
ALTER TABLE `cuisine`
  MODIFY `id_cuisine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `meal`
--
ALTER TABLE `meal`
  MODIFY `id_meal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `meal_order`
--
ALTER TABLE `meal_order`
  MODIFY `id_meal_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `meal_restaurant`
--
ALTER TABLE `meal_restaurant`
  MODIFY `id_meal_restaurant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id_restaurant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `restaurant_category`
--
ALTER TABLE `restaurant_category`
  MODIFY `id_restaurant_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `restaurant_cuisine`
--
ALTER TABLE `restaurant_cuisine`
  MODIFY `id_restaurant_cuisine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `meal`
--
ALTER TABLE `meal`
  ADD CONSTRAINT `meal_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`),
  ADD CONSTRAINT `meal_ibfk_2` FOREIGN KEY (`id_cuisine`) REFERENCES `cuisine` (`id_cuisine`);

--
-- Constraints for table `meal_order`
--
ALTER TABLE `meal_order`
  ADD CONSTRAINT `meal_order_ibfk_1` FOREIGN KEY (`id_meal`) REFERENCES `meal` (`id_meal`),
  ADD CONSTRAINT `meal_order_ibfk_2` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`);

--
-- Constraints for table `meal_restaurant`
--
ALTER TABLE `meal_restaurant`
  ADD CONSTRAINT `meal_restaurant_ibfk_1` FOREIGN KEY (`id_meal`) REFERENCES `meal` (`id_meal`),
  ADD CONSTRAINT `meal_restaurant_ibfk_2` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurant` (`id_restaurant`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`id_address`) REFERENCES `address` (`id_address`),
  ADD CONSTRAINT `order_ibfk_2` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurant` (`id_restaurant`),
  ADD CONSTRAINT `order_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD CONSTRAINT `restaurant_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `restaurant_category`
--
ALTER TABLE `restaurant_category`
  ADD CONSTRAINT `restaurant_category_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`),
  ADD CONSTRAINT `restaurant_category_ibfk_2` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurant` (`id_restaurant`);

--
-- Constraints for table `restaurant_cuisine`
--
ALTER TABLE `restaurant_cuisine`
  ADD CONSTRAINT `restaurant_cuisine_ibfk_1` FOREIGN KEY (`id_cuisine`) REFERENCES `cuisine` (`id_cuisine`),
  ADD CONSTRAINT `restaurant_cuisine_ibfk_2` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurant` (`id_restaurant`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
