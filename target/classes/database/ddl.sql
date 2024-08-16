DROP DATABASE IF EXISTS farmacy;

CREATE DATABASE farmacy;

USE farmacy_db;

CREATE TABLE country (
    codecountry VARCHAR(5) PRIMARY KEY,
    namecountry VARCHAR(50) NOT NULL
);

CREATE TABLE region (
    codereg VARCHAR(5) PRIMARY KEY,
    namereg VARCHAR(50) NOT NULL,
    codecountry VARCHAR(5) NOT NULL,
    CONSTRAINT fk_country FOREIGN KEY (codecountry) REFERENCES country(codecountry)
);

CREATE TABLE laboratory (
    idlab INT AUTO_INCREMENT PRIMARY KEY,
    namelab VARCHAR(50) NOT NULL,
    codereg VARCHAR(5) NOT NULL,
    CONSTRAINT fk_region FOREIGN KEY (codereg) REFERENCES region(codereg)
);

CREATE TABLE activeprinciple (
    idap INT AUTO_INCREMENT PRIMARY KEY,
    nameap VARCHAR(50) NOT NULL
);

CREATE TABLE unitmeasurement (
    idum INT AUTO_INCREMENT PRIMARY KEY,
    nameum VARCHAR(50) NOT NULL
);

CREATE TABLE modeadministration (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descriptionmode VARCHAR(60) NOT NULL
);

CREATE TABLE medicine (
    id INT AUTO_INCREMENT PRIMARY KEY,
    proceedings VARCHAR(100) NOT NULL,
    namemedic VARCHAR(100) NOT NULL,
    healthregister VARCHAR(20),
    description VARCHAR(50),
    codecomposition VARCHAR(10),
    idap INT,
    idlab INT,
    codeum INT,
    namerol VARCHAR(50),
    CONSTRAINT fk_activeprinciple FOREIGN KEY (idap) REFERENCES activeprinciple(idap),
    CONSTRAINT fk_laboratory FOREIGN KEY (idlab) REFERENCES laboratory(idlab),
    CONSTRAINT fk_unitmeasurement FOREIGN KEY (codeum) REFERENCES unitmeasurement(idum)
);

CREATE TABLE city (
    codecity VARCHAR(5) PRIMARY KEY,
    namecity VARCHAR(50) NOT NULL,
    codereg VARCHAR(5),
    CONSTRAINT fk_region_city FOREIGN KEY (codereg) REFERENCES region(codereg)
);

CREATE TABLE customer (
    idcustomer VARCHAR(20) PRIMARY KEY,
    namecustomer VARCHAR(50) NOT NULL,
    lastnamecustomer VARCHAR(50) NOT NULL,
    codecitycustomer VARCHAR(5),
    emailcustomer VARCHAR(100),
    brrdate DATE,
    latitud FLOAT,
    longitud FLOAT,
    CONSTRAINT fk_city_customer FOREIGN KEY (codecitycustomer) REFERENCES city(codecity)
);

CREATE TABLE pharmacy (
    idfarmacy INT AUTO_INCREMENT PRIMARY KEY,
    namefarmacy VARCHAR(60) NOT NULL,
    addressfarmacy VARCHAR(50),
    latfarmacy FLOAT,
    longfarmacy FLOAT,
    codecityfarm VARCHAR(5),
    logo_farmacy VARCHAR(50),
    CONSTRAINT fk_city_pharmacy FOREIGN KEY (codecityfarm) REFERENCES city(codecity)
);

CREATE TABLE pharmacymedicine (
    idfarmacy INT,
    idmedicinefarm INT,
    price FLOAT NOT NULL,
    PRIMARY KEY (idfarmacy, idmedicinefarm),
    CONSTRAINT fk_pharmacy FOREIGN KEY (idfarmacy) REFERENCES pharmacy(idfarmacy),
    CONSTRAINT fk_medicine FOREIGN KEY (idmedicinefarm) REFERENCES medicine(id)
);
