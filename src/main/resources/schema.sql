#customer
CREATE DATABASE IF NOT EXISTS `db_dev`;

USE `db_dev`;

CREATE TABLE IF NOT EXISTS `customer` (
  id         INTEGER PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(64) NOT NULL,
  last_name  VARCHAR(64) NOT NULL
);