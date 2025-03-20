CREATE TABLE users
(
    id        SERIAL PRIMARY KEY,
    uid       varchar(200),
    type      varchar(100),
    is_active boolean
);