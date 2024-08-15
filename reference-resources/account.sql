
CREATE TABLE bankmanagementsystems.account (
  accountNumber INT NOT NULL,
  accountHolderName VARCHAR(45) NULL,
 balance DOUBLE NULL,
  customer VARCHAR(45) NULL,
  PRIMARY KEY (accountNumber));


CREATE TABLE `bankmanagementsystems`.`customer` (
  `customerId` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `mobileNo` INT(10) NULL,
  `address` VARCHAR(45) NULL,
  `emailId` VARCHAR(45) NULL,
  `aadhaarNo` INT(12) NULL,
  PRIMARY KEY (`customerId`));


CREATE TABLE `bankmanagementsystems`.`deposit` (
  `accountNumber` INT NOT NULL,
  `amount` DOUBLE NOT NULL,
  PRIMARY KEY (`accountNumber`));