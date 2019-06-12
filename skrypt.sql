-- MySQL Script generated by MySQL Workbench
-- Sun May 26 10:30:55 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema MySQLJavaProj
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `MySQLJavaProj` ;

-- -----------------------------------------------------
-- Schema MySQLJavaProj
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MySQLJavaProj` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `MySQLJavaProj` ;

-- -----------------------------------------------------
-- Table `MySQLJavaProj`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MySQLJavaProj`.`User` ;

CREATE TABLE IF NOT EXISTS `MySQLJavaProj`.`User` (
  `userID` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `password` VARCHAR(20) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `idUzytkownik_UNIQUE` (`userID` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 47
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `MySQLJavaProj`.`Question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MySQLJavaProj`.`Question` ;

CREATE TABLE IF NOT EXISTS `MySQLJavaProj`.`Question` (
  `questionID` INT(11) NOT NULL AUTO_INCREMENT,
  `userID` INT(11) NOT NULL,
  `question` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NULL DEFAULT NULL,
  `correctID` INT(11) NOT NULL,
  `DTYPE` INT NOT NULL,
  PRIMARY KEY (`questionID`),
  INDEX `ID_tworcy` (`userID` ASC) VISIBLE,
  CONSTRAINT `fk_Question_User1`
    FOREIGN KEY (`userID`)
    REFERENCES `MySQLJavaProj`.`User` (`userID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `MySQLJavaProj`.`Answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MySQLJavaProj`.`Answer` ;

CREATE TABLE IF NOT EXISTS `MySQLJavaProj`.`Answer` (
  `answerID` INT(11) NOT NULL AUTO_INCREMENT,
  `answer` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `questionID` INT(11) NULL,
  PRIMARY KEY (`answerID`),
  UNIQUE INDEX `idMozliwa_odpowiedz_UNIQUE` (`answerID` ASC) VISIBLE,
  INDEX `fk_Answer_Question1_idx` (`questionID` ASC) VISIBLE,
  CONSTRAINT `fk_Answer_Question1`
    FOREIGN KEY (`questionID`)
    REFERENCES `MySQLJavaProj`.`Question` (`questionID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `MySQLJavaProj`.`Description`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MySQLJavaProj`.`Description` ;

CREATE TABLE IF NOT EXISTS `MySQLJavaProj`.`Description` (
  `descID` INT(11) NOT NULL AUTO_INCREMENT,
  `topic` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `description` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  PRIMARY KEY (`descID`),
  UNIQUE INDEX `idOpis_UNIQUE` (`descID` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `MySQLJavaProj`.`Test`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MySQLJavaProj`.`Test` ;

CREATE TABLE IF NOT EXISTS `MySQLJavaProj`.`Test` (
  `testID` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `descriptionID` INT(11) NULL,
  `isPublic` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`testID`),
  UNIQUE INDEX `idTest_UNIQUE` (`testID` ASC) VISIBLE,
  INDEX `FK_Test_Uzytkownik` (`userId` ASC) VISIBLE,
  INDEX `FK_Test_Opis` (`descriptionID` ASC) VISIBLE,
  CONSTRAINT `fk_Test_Opis1`
    FOREIGN KEY (`descriptionID`)
    REFERENCES `MySQLJavaProj`.`Description` (`descID`),
  CONSTRAINT `fk_Test_Uzytkownik1`
    FOREIGN KEY (`userId`)
    REFERENCES `MySQLJavaProj`.`User` (`userID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci
COMMENT = '		';


-- -----------------------------------------------------
-- Table `MySQLJavaProj`.`Result`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MySQLJavaProj`.`Result` ;

CREATE TABLE IF NOT EXISTS `MySQLJavaProj`.`Result` (
  `resultID` INT(11) NOT NULL AUTO_INCREMENT,
  `prcntgOfUnderstanding` FLOAT NOT NULL,
  `points` FLOAT NOT NULL,
  PRIMARY KEY (`resultID`),
  UNIQUE INDEX `resultID_UNIQUE` (`resultID` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `MySQLJavaProj`.`CompletedTest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MySQLJavaProj`.`CompletedTest` ;

CREATE TABLE IF NOT EXISTS `MySQLJavaProj`.`CompletedTest` (
  `completedtestID` INT(11) NOT NULL AUTO_INCREMENT,
  `testID` INT(11) NOT NULL,
  `resultID` INT(11) NOT NULL,
  `userID` INT(11) NOT NULL,
  INDEX `FK_Wykonanie_Testu_Test` (`testID` ASC) VISIBLE,
  INDEX `fk_CompletedTest_Result1_idx` (`resultID` ASC) VISIBLE,
  PRIMARY KEY (`completedtestID`),
  CONSTRAINT `fk_Wykonanie_Testu_Test1`
    FOREIGN KEY (`testID`)
    REFERENCES `MySQLJavaProj`.`Test` (`testID`),
  CONSTRAINT `fk_Wykonanie_Testu_Uzytkownik1`
    FOREIGN KEY (`userID`)
    REFERENCES `MySQLJavaProj`.`User` (`userID`),
  CONSTRAINT `fk_CompletedTest_Result1`
    FOREIGN KEY (`resultID`)
    REFERENCES `MySQLJavaProj`.`Result` (`resultID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `MySQLJavaProj`.`Opinion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MySQLJavaProj`.`Opinion` ;

CREATE TABLE IF NOT EXISTS `MySQLJavaProj`.`Opinion` (
  `opinionID` INT(11) NOT NULL AUTO_INCREMENT,
  `userID` INT(11) NOT NULL,
  `opinion` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NULL DEFAULT NULL,
  `rate` FLOAT NULL DEFAULT NULL,
  `testID` INT(11) NOT NULL,
  PRIMARY KEY (`opinionID`),
  UNIQUE INDEX `idOpinia_UNIQUE` (`opinionID` ASC) VISIBLE,
  INDEX `FK_Opinia_Uzytkownik` (`userID` ASC) VISIBLE,
  INDEX `fk_Opinia_Test1_idx` (`testID` ASC) VISIBLE,
  CONSTRAINT `fk_Opinia_Test1`
    FOREIGN KEY (`testID`)
    REFERENCES `MySQLJavaProj`.`Test` (`testID`),
  CONSTRAINT `fk_Opinia_Uzytkownik1`
    FOREIGN KEY (`userID`)
    REFERENCES `MySQLJavaProj`.`User` (`userID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `MySQLJavaProj`.`QuestionInTest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MySQLJavaProj`.`QuestionInTest` ;

CREATE TABLE IF NOT EXISTS `MySQLJavaProj`.`QuestionInTest` (
  `questionInTestID` INT(11) NOT NULL AUTO_INCREMENT,
  `questionID` INT(11) NOT NULL,
  `testID` INT(11) NOT NULL,
  PRIMARY KEY (`questionInTestID`),
  INDEX `fk_QuestionInTest_Test1_idx` (`testID` ASC) VISIBLE,
  INDEX `fk_QuestionInTest_Question1_idx` (`questionID` ASC) VISIBLE,
  CONSTRAINT `fk_QuestionInTest_Question1`
    FOREIGN KEY (`questionID`)
    REFERENCES `MySQLJavaProj`.`Question` (`questionID`),
  CONSTRAINT `fk_QuestionInTest_Test1`
    FOREIGN KEY (`testID`)
    REFERENCES `MySQLJavaProj`.`Test` (`testID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
