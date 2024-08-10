CREATE TABLE bankmanagementsystems.customer (
  accountHolderName VARCHAR(55) NULL,
  gender VARCHAR(45) NULL,
  mobileNo INT NULL,
  dob VARCHAR(45) NULL,
  address VARCHAR(45) NULL,
  emailId VARCHAR(45) NULL,
  Customercol VARCHAR(45) NULL,
  aadhaarNo INT NULL);


SELECT * FROM bankmanagementsystems.customer;

ALTER TABLE bankmanagementsystems.customer` 
DROP COLUMN Customercol;
