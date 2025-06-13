CREATE TABLE IF NOT EXISTS Tour (
    id serial PRIMARY KEY,
    name varchar(100) not null, --new
    country varchar(50),
    city varchar(50),
    check_in_date date,
    check_out_date date,
    duration int, --new
    max_capacity int default 20, --new
    available_spots int, --new
    price decimal,
    hotel varchar(50),
    rating int,
    description text,
    activities text[], --new
    images_url text[] --new
);

