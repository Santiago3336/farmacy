CREATE TABLE country (
    codecountry VARCHAR(5),
    namecountry VARCHAR(50),
    CONSTRAINT pk_codecountry PRIMARY KEY (codecountry)
);

CREATE TABLE region (
    codereg VARCHAR(5),
    namereg VARCHAR(50),
    codecountry VARCHAR(5),
    CONSTRAINT pk_codereg PRIMARY KEY (codereg),
    CONSTRAINT fk_codecountry_country FOREIGN KEY (codecountry) REFERENCES country(codecountry)
);

CREATE TABLE laboratory (
    idlab SERIAL,
    namelab VARCHAR(50),
    codereg VARCHAR(5),
    CONSTRAINT pk_idlab PRIMARY KEY (idlab),
    CONSTRAINT fk_codereg_region FOREIGN KEY (codereg) REFERENCES region(codereg)
);

CREATE TABLE activeprinciple (
    idap SERIAL,
    nameap VARCHAR(50),
    CONSTRAINT pk_idap PRIMARY KEY (idap)
);

CREATE TABLE unitmeasurement (
    idum SERIAL,
    nameum VARCHAR(50),
    CONSTRAINT pk_idum PRIMARY KEY (idum)
);

CREATE TABLE modeadministration (
    id SERIAL PRIMARY KEY,
    descriptionmode VARCHAR(60),
    CONSTRAINT pk_id PRIMARY KEY (id)
);

CREATE TABLE medicine (
    id SERIAL PRIMARY KEY,
    proceedings VARCHAR(100),
    namemedic VARCHAR(100),
    healthregister VARCHAR(20),
    description VARCHAR(50),
    codecomposition VARCHAR(10),
    idap INT,
    idlab INT,
    codeum INT,
    namerol VARCHAR(50),
    CONSTRAINT pk_id PRIMARY KEY (id),
    CONSTRAINT fk_idap_activeprinciple FOREIGN KEY (idap) REFERENCES activeprinciple(idap),
    CONSTRAINT fk_idlab_laboratory FOREIGN KEY (idlab) REFERENCES laboratory(idlab),
    CONSTRAINT fk_codeum_unitmeasurement FOREIGN KEY (codeum) REFERENCES unitmeasurement(idum)
);

CREATE TABLE customer (
    idcustomer VARCHAR(20),
    namecustomer VARCHAR(50),
    lastnamecustomer VARCHAR(50),
    codecitycustomer VARCHAR(5),
    emailcustomer VARCHAR(100),
    brrdate DATE,
    latitude FLOAT(8),
    longitude FLOAT(8),
    CONSTRAINT pk_idcustomer PRIMARY KEY (idcustomer)
);

CREATE TABLE pharmacy (
    idfarmacy SERIAL,
    namefarmacy VARCHAR(60),
    addressfarmacy VARCHAR(50),
    latfarmacy FLOAT(8),
    longfarmacy FLOAT(8),
    codecityfarm VARCHAR(5),
    logo_farmacy VARCHAR(50),
    CONSTRAINT pk_idfarmacy PRIMARY KEY (idfarmacy)
);

CREATE TABLE pharmacymedicine (
    idfarmacy INT,
    idmedicinefarm INT,
    price FLOAT(8),
    CONSTRAINT pk_idfarmacy_idmedicinefarm PRIMARY KEY (idfarmacy, idmedicinefarm),
    CONSTRAINT fk_idfarmacy_pharmacy FOREIGN KEY (idfarmacy) REFERENCES pharmacy(idfarmacy),
    CONSTRAINT fk_idmedicinefarm_medicine FOREIGN KEY (idmedicinefarm) REFERENCES medicine(id)
);

CREATE TABLE city (
    codecity VARCHAR(5),
    namecity VARCHAR(50),
    codereg VARCHAR(5),
    CONSTRAINT pk_codecity PRIMARY KEY (codecity),
    CONSTRAINT fk_codereg_region FOREIGN KEY (codereg) REFERENCES public.region(codereg)
);
