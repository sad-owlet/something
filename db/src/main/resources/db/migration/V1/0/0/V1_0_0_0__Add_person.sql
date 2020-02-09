CREATE TABLE person (
    id            SERIAL      NOT NULL PRIMARY KEY,
    login         VARCHAR(64) NOT NULL,
    password_hash VARCHAR(64) NOT NULL,
    active        BOOLEAN     NOT NULL DEFAULT TRUE,
    root          BOOLEAN     NOT NULL DEFAULT FALSE,
    date_add      TIMESTAMPTZ NOT NULL DEFAULT current_timestamp
);
