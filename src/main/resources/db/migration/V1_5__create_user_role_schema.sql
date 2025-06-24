CREATE TABLE IF NOT EXISTS User_Role (
    user_id INT REFERENCES Users(id),
    role_id INT REFERENCES Role(id),
    CONSTRAINT user_role_pk PRIMARY KEY(user_id, role_id)
);