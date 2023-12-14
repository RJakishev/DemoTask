DROP TABLE IF EXISTS "event";

CREATE TABLE IF NOT EXISTS "event" (
    id SERIAL PRIMARY KEY,
    name varchar(100) NULL,
    a FLOAT NOT NULL,
    b FLOAT NOT NULL,
    c FLOAT NOT NULL,
    is_distance_unit BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS athlet;

CREATE TABLE IF NOT EXISTS athlet (
    id SERIAL PRIMARY KEY,
    firstname varchar(50) NULL,
    lastname varchar(50) NULL
);

CREATE TABLE IF NOT EXISTS result (
    id SERIAL PRIMARY KEY,
    event_id SERIAL NOT NULL,
    points FLOAT NOT NULL,
    event_result FLOAT NOT NULL,
    athlet_id SERIAL NOT NULL
);
