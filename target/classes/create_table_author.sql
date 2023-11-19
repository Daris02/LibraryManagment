DROP TABLE IF EXISTS "author";

CREATE TABLE IF NOT EXISTS "author" (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    name VARCHAR(100) NOT NULL,
    sex VARCHAR(1)
);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SELECT uuid_generate_v4();

INSERT INTO "author" (name, sex) values
('Paul Valéry', 'M'),
('Albert Camus', 'M'),
('Catherine Bernard', 'F');