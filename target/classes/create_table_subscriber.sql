DROP TABLE IF EXISTS "subscriber";

CREATE TABLE IF NOT EXISTS "subscriber" (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    name VARCHAR(100) NOT NULL,
    reference VARCHAR(100)
);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SELECT uuid_generate_v4();

INSERT INTO "subscriber" (name, reference) values
 ('Christian', '034 09 123 21'),
 ('Clark', '032 12 504 13'),
 ('Anny', '034 75 324 08');