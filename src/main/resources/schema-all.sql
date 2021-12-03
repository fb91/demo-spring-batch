DROP TABLE person IF EXISTS;

CREATE TABLE person(
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    firstName VARCHAR(255),
    surname VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    age INT
);