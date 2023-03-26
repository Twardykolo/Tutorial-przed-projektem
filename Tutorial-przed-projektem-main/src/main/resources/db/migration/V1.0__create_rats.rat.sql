DROP SCHEMA IF EXISTS rats CASCADE;
CREATE SCHEMA rats;

DROP TABLE IF EXISTS rats.rat CASCADE;

CREATE TABLE rats.rat (
    id             bigserial NOT NULL,
    imie          VARCHAR(255) NOT NULL,
    wiek          INTEGER NOT NULL,
    czyzyje       boolean NOT NULL
);
ALTER TABLE rats.rat ADD CONSTRAINT rat_pk PRIMARY KEY ( id );