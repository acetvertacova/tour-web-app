CREATE TABLE IF NOT EXISTS Users (
    id serial PRIMARY KEY,
    username varchar(50) NOT NULL UNIQUE,
    email varchar(50) NOT NULL UNIQUE,
    password varchar(200) NOT NULL --chkpass check if can use
);

INSERT INTO Users (username, email, password) VALUES
('alice', 'alice@example.com', 'hashed_password_1'),
('bob', 'bob@example.com', 'hashed_password_2');
