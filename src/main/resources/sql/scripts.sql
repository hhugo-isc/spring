DROP SCHEMA IF EXISTS springsecurity;

CREATE SCHEMA IF NOT EXISTS springsecurity;

USE springsecurity;

CREATE TABLE IF NOT EXISTS users(
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(500) NOT NULL,
	enabled INT NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS  authorities(
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS customer(
	id INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(45) NOT NULL,
	pwd VARCHAR(500) NOT NULL,
	role VARCHAR(50) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO customer VALUES (NULL, "johndoe@gmail.com","{bcrypt}$2a$10$I4eGCgvSlXWma/lpfO9Kqe7Y80AGTqfdPGdHv8XAoFXj4d9AdsXSq","admin");
INSERT INTO users VALUES (NULL, "admin", "{bcrypt}$2a$10$I4eGCgvSlXWma/lpfO9Kqe7Y80AGTqfdPGdHv8XAoFXj4d9AdsXSq",1);
INSERT INTO authorities VALUES (NULL, "admin", "admin");