CREATE TABLE country (
  id SERIAL PRIMARY KEY
, name VARCHAR(256) NOT NULL
);

CREATE TABLE genre (
  id SERIAL PRIMARY KEY
, name VARCHAR(256) NOT NULL
);

CREATE TABLE movie (
  id SERIAL PRIMARY KEY
, name_russian VARCHAR(256) NOT NULL
, name_native VARCHAR(256) NOT NULL
, description VARCHAR(1000) NOT NULL
, year_of_release INT NOT NULL
, price FLOAT DEFAULT 0
, rating FLOAT DEFAULT 0
, last_update_date TIMESTAMP DEFAULT NOW()
, picture_path VARCHAR(256)
);

CREATE TABLE movie_2_genre (
  id SERIAL PRIMARY KEY
, movie_id INTEGER REFERENCES movie(id)
, genre_id INTEGER REFERENCES genre(id));


CREATE TABLE movie_2_country (
  id SERIAL PRIMARY KEY
, movie_id INTEGER REFERENCES movie(id)
, country_id INTEGER REFERENCES country(id));
