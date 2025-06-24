CREATE TABLE IF NOT EXISTS Users (
    id serial PRIMARY KEY,
    username varchar(50) NOT NULL UNIQUE,
    email varchar(50) NOT NULL UNIQUE,
    password varchar(200) NOT NULL, --chkpass check if can use
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

