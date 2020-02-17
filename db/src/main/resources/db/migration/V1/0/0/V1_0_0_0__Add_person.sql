CREATE TABLE person (
    id            SERIAL      NOT NULL PRIMARY KEY,
    login         VARCHAR(64) NOT NULL,
    password_hash VARCHAR(64) NOT NULL,
    active        BOOLEAN     NOT NULL DEFAULT TRUE,
    root          BOOLEAN     NOT NULL DEFAULT FALSE,
    date_add      TIMESTAMPTZ NOT NULL DEFAULT current_timestamp
);

CREATE TABLE market (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL
);

CREATE TABLE carBrand (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL,
    FOREIGN KEY(marketID) REFERENCES market(id)
);

CREATE TABLE fuelType (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL,
    FOREIGN KEY(carBrandID) REFERENCES carBrand(id),
    FOREIGN KEY(ecuTypeID) REFERENCES ecuType(id)
    
);

CREATE TABLE ecuType (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL,
    
);

CREATE TABLE carModel (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL,
    FOREIGN KEY(ecuTypeID) REFERENCES ecuType(id),
    FOREIGN KEY(gearboxTypeID) REFERENCES gearboxType(id)    
);

CREATE TABLE gearboxType (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL
);

CREATE TABLE gearboxType (
    id            SERIAL      NOT NULL PRIMARY KEY,
    add_date      TIMESTAMP   NOT NULL DEFAULT current_timestamp,
    HW_id         VARCHAR(64) NOT NULL,
    SW_id         VARCHAR(64) NOT NULL,
    SW_number     VARCHAR(64) NOT NULL,
    file_name     VARCHAR(64) NOT NULL,
    size          INTEGER     NOT NULL,
    author        VARCHAR(64) NOT NULL,
    CRC32         INTEGER     NOT NULL
    FOREIGN KEY(gearboxTypeID) REFERENCES gearboxType(id),
    FOREIGN KEY(ecuTypeID) REFERENCES ecuType(id)        
);

CREATE TABLE accessRequest (
    id            SERIAL      NOT NULL PRIMARY KEY,
    approved      BOOLEAN     NOT NULL DEFAULT FALSE,
    FOREIGN KEY(personID) REFERENCES person(id),
    FOREIGN KEY(firmwareID) REFERENCES firmware(id)       
);
