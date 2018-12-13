INSERT INTO country (name) VALUES ('Италия');
INSERT INTO country (name) VALUES ('Испания');
INSERT INTO country (name) VALUES ('Германия');
INSERT INTO country (name) VALUES ('США');
INSERT INTO country (name) VALUES ('Великобритания');
INSERT INTO country (name) VALUES ('Япония');
INSERT INTO country (name) VALUES ('Франция');


INSERT INTO genre (name) VALUES ('драма');
INSERT INTO genre (name) VALUES ('криминал');
INSERT INTO genre (name) VALUES ('фэнтези');
INSERT INTO genre (name) VALUES ('детектив');
INSERT INTO genre (name) VALUES ('мелодрама');
INSERT INTO genre (name) VALUES ('биография');
INSERT INTO genre (name) VALUES ('комедия');
INSERT INTO genre (name) VALUES ('фантастика');
INSERT INTO genre (name) VALUES ('боевик');
INSERT INTO genre (name) VALUES ('триллер');
INSERT INTO genre (name) VALUES ('приключения');
INSERT INTO genre (name) VALUES ('аниме');
INSERT INTO genre (name) VALUES ('мультфильм');
INSERT INTO genre (name) VALUES ('семейный');
INSERT INTO genre (name) VALUES ('вестерн');
commit;

insert into movie (
  name_russian
, name_native
, description
, year_of_release
, price
, rating
, picture_path
)
values (
'Джанго освобожденный',
'Django Unchained',
'Эксцентричный охотник за головами, также известный как «Дантист», промышляет отстрелом самых опасных преступников. Работенка пыльная, и без надежного помощника ему не обойтись. Но как найти такого и желательно не очень дорогого? Беглый раб по имени Джанго — прекрасная кандидатура. Правда, у нового помощника свои мотивы — кое с чем надо разобраться…',
2012,
170,
8.5,
'https://upload.wikimedia.org/wikipedia/ru/b/ba/Django_Unchained.jpg'
);

insert into movie (
  name_russian
, name_native
, description
, year_of_release
, price
, rating
, picture_path
)
values (
'Джанго освобожденный',
'Django Unchained',
'Эксцентричный охотник за головами, также известный как «Дантист», промышляет отстрелом самых опасных преступников. Работенка пыльная, и без надежного помощника ему не обойтись. Но как найти такого и желательно не очень дорогого? Беглый раб по имени Джанго — прекрасная кандидатура. Правда, у нового помощника свои мотивы — кое с чем надо разобраться…',
2012,
170,
8.5,
'https://upload.wikimedia.org/wikipedia/ru/b/ba/Django_Unchained.jpg'
);

insert into movie (
  name_russian
, name_native
, description
, year_of_release
, price
, rating
, picture_path
)
values (
'Начало',
'Inception',
'Кобб — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим. Редкие способности Кобба сделали его ценным игроком в привычном к предательству мире промышленного шпионажа, но они же превратили его в извечного беглеца и лишили всего, что он когда-либо любил. ',
2010,
130,
8.6,
'https://upload.wikimedia.org/wikipedia/ru/b/bc/Poster_Inception_film_2010.jpg'
);

insert into movie (
  name_russian
, name_native
, description
, year_of_release
, price
, rating
, picture_path
)
values (
'Начало 1',
'Inception 1',
'Кобб 1 — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим. Редкие способности Кобба сделали его ценным игроком в привычном к предательству мире промышленного шпионажа, но они же превратили его в извечного беглеца и лишили всего, что он когда-либо любил. ',
2011,
131,
8.7,
'https://upload.wikimedia.org/wikipedia/ru/b/bc/Poster_Inception_film_2011.jpg'
);

insert into movie (
  name_russian
, name_native
, description
, year_of_release
, price
, rating
, picture_path
)
values (
'Начало 2',
'Inception 2',
'Кобб 2 — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим. Редкие способности Кобба сделали его ценным игроком в привычном к предательству мире промышленного шпионажа, но они же превратили его в извечного беглеца и лишили всего, что он когда-либо любил. ',
2012,
132,
8.8,
'https://upload.wikimedia.org/wikipedia/ru/b/bc/Poster_Inception_film_2012.jpg'
);

insert into movie (
  name_russian
, name_native
, description
, year_of_release
, price
, rating
, picture_path
)
values (
'Начало 3',
'Inception 3',
'Кобб 3 — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим. Редкие способности Кобба сделали его ценным игроком в привычном к предательству мире промышленного шпионажа, но они же превратили его в извечного беглеца и лишили всего, что он когда-либо любил. ',
2013,
133,
8.9,
'https://upload.wikimedia.org/wikipedia/ru/b/bc/Poster_Inception_film_2019.jpg'
);

insert into movie_2_genre (movie_id, genre_id) values(1, 1);
insert into movie_2_genre (movie_id, genre_id) values(1, 15);
insert into movie_2_genre (movie_id, genre_id) values(1, 11);
insert into movie_2_genre (movie_id, genre_id) values(1, 7);
insert into movie_2_genre (movie_id, genre_id) values(2, 8);
insert into movie_2_genre (movie_id, genre_id) values(2, 9);
insert into movie_2_genre (movie_id, genre_id) values(2, 10);
insert into movie_2_genre (movie_id, genre_id) values(2, 1);
insert into movie_2_genre (movie_id, genre_id) values(2, 4);


insert into movie_2_country (movie_id, country_id) values(1, 4);
insert into movie_2_country (movie_id, country_id) values(1, 5);
insert into movie_2_country (movie_id, country_id) values(2, 4);
