CREATE TABLE IF NOT EXISTS T_TOURS (

    ID uuid PRIMARY KEY,
    COUNTRY varchar(50),
    CITY varchar(50),
    CHECK_IN_DATE date,
    CHECK_OUT_DATE date,
    FOOD_TYPE varchar(50),
    PRICE decimal,
    HOTEL varchar(50),
    STARS int,
    DEPARTURE_THERE_DATE date,
    DEPARTURE_BACK_DATE date
);


