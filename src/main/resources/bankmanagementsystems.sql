CREATE SCHEMA bankmanagementsystems ;
SELECT * FROM bankmanagementsystems.card;

CREATE TABLE bankmanagementsystems.card (
  cardId INT NOT NULL,
  cardNo INT NOT NULL,
  accountNo INT NULL,
  accountHolderName` VARCHAR(45) NULL,
  cvv INT NULL,
  cardType VARCHAR(45) NULL,
  PRIMARY KEY (cardId, cardNo));
