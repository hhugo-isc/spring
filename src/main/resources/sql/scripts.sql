create schema easybank;

use easybank;

CREATE TABLE users(
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(45) NOT NULL,
	enabled INT NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE authorities(
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE customer(
	id INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(45) NOT NULL,
	pwd VARCHAR(45) NOT NULL,
	role INT NOT NULL,
	PRIMARY KEY(id)
);

insert into customer VALUES (NULL, "johndoeq@gmail.com","password","admin")


INSERT INTO users VALUES (NULL, "admin", "password",1);
INSERT INTO authorities VALUES (NULL, "admin", "admin");