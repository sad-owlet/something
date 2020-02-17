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
    FOREIGN KEY(id) REFERENCES market(id)
);

CREATE TABLE ecuType (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL
);

CREATE TABLE fuelType (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL,
    FOREIGN KEY(id) REFERENCES carBrand(id),
    FOREIGN KEY(id) REFERENCES ecuType(id)
    
);

CREATE TABLE gearboxType (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL
);

CREATE TABLE carModel (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL,
    FOREIGN KEY(id) REFERENCES ecuType(id),
    FOREIGN KEY(id) REFERENCES gearboxType(id)    
);

CREATE TABLE firmware (
    id            SERIAL      NOT NULL PRIMARY KEY,
    add_date      TIMESTAMP   NOT NULL DEFAULT current_timestamp,
    HW_id         VARCHAR(64) NOT NULL,
    SW_id         VARCHAR(64) NOT NULL,
    SW_number     VARCHAR(64) NOT NULL,
    file_name     VARCHAR(64) NOT NULL,
    size          INTEGER     NOT NULL,
    author        VARCHAR(64) NOT NULL,
    CRC32         INTEGER     NOT NULL,
    FOREIGN KEY(id) REFERENCES gearboxType(id),
    FOREIGN KEY(id) REFERENCES ecuType(id)        
);

CREATE TABLE accessRequest (
    id            SERIAL      NOT NULL PRIMARY KEY,
    approved      BOOLEAN     NOT NULL DEFAULT FALSE,
    FOREIGN KEY(id) REFERENCES person(id),
    FOREIGN KEY(id) REFERENCES firmware(id)       
);
