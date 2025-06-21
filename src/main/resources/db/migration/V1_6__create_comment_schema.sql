CREATE TABLE IF NOT EXISTS Comment (
    id SERIAL PRIMARY KEY,
    content text NOT NULL,
    user_id int REFERENCES Users(id),
    tour_id int REFERENCES Tour(id),
    created_at date DEFAULT CURRENT_DATE
);

INSERT INTO Comment (content, user_id, tour_id) VALUES
('Amazing experience, loved every moment!', 1, 1),
('Great trip but a bit cold for me.', 2, 2);