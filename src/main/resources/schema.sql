CREATE TABLE PET(
    id NUMERIC PRIMARY KEY AUTO_INCREMENT NOT NULL,
    userid NUMERIC,
    name VARCHAR,
    type VARCHAR,
    gender VARCHAR,
    hair VARCHAR,
    breed VARCHAR,
    age VARCHAR,
    size VARCHAR,
    longitude NUMERIC,
    latitude NUMERIC
);

CREATE TABLE USER(
    id NUMERIC PRIMARY KEY AUTO_INCREMENT NOT NULL,
    email VARCHAR,
    password VARCHAR
);