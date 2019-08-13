/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.26-0ubuntu0.18.04.1 : Database - tms_new
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tms_new` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `tms_new`;

/*Table structure for table `Aircraft` */

DROP TABLE IF EXISTS `Aircraft`;

CREATE TABLE `Aircraft` (
  `aircraft_model` varchar(255) NOT NULL,
  `aircraft_make` varchar(255) DEFAULT NULL,
  `business_capacity` int(11) NOT NULL,
  `economy_capacity` int(11) NOT NULL,
  `firstclass_capacity` int(11) NOT NULL,
  PRIMARY KEY (`aircraft_model`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Airline` */

DROP TABLE IF EXISTS `Airline`;

CREATE TABLE `Airline` (
  `airline_id` varchar(255) NOT NULL,
  `airline_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`airline_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Airline_Aircraft` */

DROP TABLE IF EXISTS `Airline_Aircraft`;

CREATE TABLE `Airline_Aircraft` (
  `airline_airline_id` varchar(255) NOT NULL,
  `aircraft_aircraft_model` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `Cart` */

DROP TABLE IF EXISTS `Cart`;

CREATE TABLE `Cart` (
  `cart_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Cart_Flight` */

DROP TABLE IF EXISTS `Cart_Flight`;

CREATE TABLE `Cart_Flight` (
  `cart_cart_id` varchar(255) NOT NULL,
  `flight_flight_number` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Cart_Package` */

DROP TABLE IF EXISTS `Cart_Package`;

CREATE TABLE `Cart_Package` (
  `cart_cart_id` varchar(255) NOT NULL,
  `package_package_id` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `FAQ` */

DROP TABLE IF EXISTS `FAQ`;

CREATE TABLE `FAQ` (
  `question_id` varchar(255) NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `search_frequency` int(11) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Flight` */

DROP TABLE IF EXISTS `Flight`;

CREATE TABLE `Flight` (
  `flight_number` varchar(255) NOT NULL,
  `arrival_date` datetime NOT NULL,
  `departure_date` datetime NOT NULL,
  `isFull` tinyint(1) NOT NULL,
  `business_class_price` double NOT NULL,
  `economy_price` double NOT NULL,
  `first_class_price` double NOT NULL,
  `airline_airline_id` varchar(255) DEFAULT NULL,
  `arrivalIATA_IATACode` varchar(255) DEFAULT NULL,
  `departureIATA_IATACode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`flight_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Hotel` */

DROP TABLE IF EXISTS `Hotel`;

CREATE TABLE `Hotel` (
  `hotel_id` varchar(255) NOT NULL,
  `hasRestaurant` tinyint(1) NOT NULL,
  `hasSwimingPool` tinyint(1) NOT NULL,
  `isAirConditioned` tinyint(1) NOT NULL,
  `isWifiEnabled` tinyint(1) NOT NULL,
  `hotel_address` varchar(255) DEFAULT NULL,
  `deluxe_room` int(11) NOT NULL,
  `double_bed_room` int(11) NOT NULL,
  `single_bed_room` int(11) NOT NULL,
  `suite` int(11) NOT NULL,
  `hotel_name` varchar(255) DEFAULT NULL,
  `hotel_rating` varchar(255) DEFAULT NULL,
  `isRoomAvailable` tinyint(1) NOT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `IATA` */

DROP TABLE IF EXISTS `IATA`;

CREATE TABLE `IATA` (
  `IATA_code` varchar(255) NOT NULL,
  `IATA_name` varchar(255) NOT NULL,
  `airport_country` varchar(255) NOT NULL,
  `airport_city` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IATA_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Orders` */

DROP TABLE IF EXISTS `Orders`;

CREATE TABLE `Orders` (
  `order_id` varchar(255) NOT NULL,
  `order_date` datetime NOT NULL,
  `ticket_number` varchar(255) DEFAULT NULL,
  `promocode_promocode` varchar(255) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Orders_Packages` */

DROP TABLE IF EXISTS `Orders_Packages`;

CREATE TABLE `Orders_Packages` (
  `order_order_id` varchar(255) NOT NULL,
  `package_package_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Orders_Tickets` */

DROP TABLE IF EXISTS `Orders_Tickets`;

CREATE TABLE `Orders_Tickets` (
  `order_id` varchar(255) NOT NULL,
  `ticket_number` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Packages` */

DROP TABLE IF EXISTS `Packages`;

CREATE TABLE `Packages` (
  `package_id` varchar(11) NOT NULL,
  `available_packages` int(11) NOT NULL,
  `package_days` int(11) NOT NULL,
  `package_name` varchar(255) DEFAULT NULL,
  `package_price` double NOT NULL,
  `hotel_hotel_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Packages_Flight` */

DROP TABLE IF EXISTS `Packages_Flight`;

CREATE TABLE `Packages_Flight` (
  `package_package_id` int(11) NOT NULL,
  `flight_flight_number` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `PromoCode` */

DROP TABLE IF EXISTS `PromoCode`;

CREATE TABLE `PromoCode` (
  `promo_code` varchar(255) NOT NULL,
  `discount` double NOT NULL,
  PRIMARY KEY (`promo_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Survey` */

DROP TABLE IF EXISTS `Survey`;

CREATE TABLE `Survey` (
  `survey_id` varchar(255) NOT NULL,
  `agree` tinyint(1) NOT NULL,
  `disagree` tinyint(1) NOT NULL,
  `neutral` tinyint(1) NOT NULL,
  `strongly_agree` tinyint(1) NOT NULL,
  `strongly_disagree` tinyint(1) NOT NULL,
  `client_user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`survey_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `SurveyQuestions` */

DROP TABLE IF EXISTS `SurveyQuestions`;

CREATE TABLE `SurveyQuestions` (
  `question_id` varchar(255) NOT NULL,
  `question` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Ticket` */

DROP TABLE IF EXISTS `Ticket`;

CREATE TABLE `Ticket` (
  `ticket_number` varchar(255) NOT NULL,
  `ticket_price` double NOT NULL,
  `client_user_id` varchar(255) NOT NULL,
  `order_id` varchar(255) NOT NULL,
  PRIMARY KEY (`ticket_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `Ticket_Flight` */

DROP TABLE IF EXISTS `Ticket_Flight`;

CREATE TABLE `Ticket_Flight` (
  `ticket_ticket_number` varchar(255) NOT NULL,
  `flight_flight_number` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `User` */

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `user_id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `family_name` varchar(255) DEFAULT NULL,
  `given_name` varchar(255) DEFAULT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `isVerified` tinyint(1) NOT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL,
  `passport_expiry_date` datetime DEFAULT NULL,
  `passport_start_date` datetime DEFAULT NULL,
  `passport_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
