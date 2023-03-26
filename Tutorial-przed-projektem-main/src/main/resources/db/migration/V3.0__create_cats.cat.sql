DROP SCHEMA IF EXISTS cats CASCADE;
CREATE SCHEMA cats;

DROP TABLE IF EXISTS cats.cat CASCADE;

CREATE TABLE cats.cat (
    id             bigserial NOT NULL,
    imie          VARCHAR(255) NOT NULL,
    wiek          INTEGER NOT NULL,
    iloscszczurow       INTEGER NOT NULL
);
ALTER TABLE cats.cat ADD CONSTRAINT cat_pk PRIMARY KEY ( id );