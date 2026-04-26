DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50),
    age INT,
    city VARCHAR(50)
);

insert into customer(name, age, city)
values
    ('sam', 23, 'atlanta'),
    ('john', 24, 'maimi'),
    ('kk', 34, 'india'),
    ('ram', 28, 'usa');
