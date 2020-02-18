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

CREATE TABLE car_brand (
    id            SERIAL      NOT NULL PRIMARY KEY,
    market        INTEGER     NOT NULL REFERENCES market(id) ON DELETE CASCADE,
    name          VARCHAR(64) NOT NULL
);

CREATE TABLE ecu_type (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL
);

CREATE TABLE fuel_type (
    id            SERIAL      NOT NULL PRIMARY KEY,
    car_brand     INTEGER     NOT NULL REFERENCES car_brand(id) ON DELETE CASCADE,
    ecu_type      INTEGER     NOT NULL REFERENCES ecu_type(id) ON DELETE CASCADE,
    name          VARCHAR(64) NOT NULL
);

CREATE TABLE gearbox_type (
    id            SERIAL      NOT NULL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL
);

CREATE TABLE car_model (
    id            SERIAL      NOT NULL PRIMARY KEY,
    ecu_type      INTEGER     NOT NULL REFERENCES ecu_type(id) ON DELETE CASCADE,
    gearbox_type  INTEGER     NOT NULL REFERENCES gearbox_type(id) ON DELETE CASCADE,
    name          VARCHAR(64) NOT NULL    
);

CREATE TABLE firmware (
    id            SERIAL      NOT NULL PRIMARY KEY,
    gearbox_type  INTEGER     NOT NULL REFERENCES gearbox_type(id) ON DELETE CASCADE,
    ecu_type      INTEGER     NOT NULL REFERENCES ecu_type(id) ON DELETE CASCADE,
    add_date      TIMESTAMP   NOT NULL DEFAULT current_timestamp,
    HW_id         VARCHAR(64) NOT NULL,
    SW_id         VARCHAR(64) NOT NULL,
    SW_number     VARCHAR(64) NOT NULL,
    file_name     VARCHAR(64) NOT NULL,
    size          INTEGER     NOT NULL,
    author        VARCHAR(64) NOT NULL,
    CRC32         INTEGER     NOT NULL       
);

CREATE TABLE access_request (
    id            SERIAL      NOT NULL PRIMARY KEY,
    person        INTEGER     NOT NULL REFERENCES person(id) ON DELETE CASCADE,
    firmware      INTEGER     NOT NULL REFERENCES firmware(id) ON DELETE CASCADE,
    approved      BOOLEAN     NOT NULL DEFAULT FALSE       
);
