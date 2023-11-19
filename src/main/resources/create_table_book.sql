DROP TABLE IF EXISTS "book";
DROP TYPE IF EXISTS topic;

CREATE TYPE topic AS ENUM ('COMEDY', 'ROMANCE', 'OTHER');

CREATE TABLE IF NOT EXISTS "book" (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    bookName VARCHAR(100) NOT NULL,
    releaseDate DATE,
    idAuthor uuid REFERENCES "author"(id),
    topic topic
);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SELECT uuid_generate_v4();

INSERT INTO "book" (bookName, releaseDate, idAuthor, topic) values
('Harry Potter', '2000-01-01', 'e9aafb2f-8627-41fe-9111-ca141446b354', 'COMEDY'),
('Poirot', '1990-07-11', 'a9ea116d-dd2d-4ca3-a099-434f37c34319', 'OTHER'),
('Dracula', '2018-11-23', 'ae8e386f-fd04-4434-a718-fa41733e7408', 'ROMANCE');