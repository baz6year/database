-- Создание схемы, если не существует
CREATE SCHEMA IF NOT EXISTS test;
SET search_path TO test;

-- Таблица schedule
DROP TABLE IF EXISTS schedule;
CREATE TABLE schedule (
    id SERIAL PRIMARY KEY,
    event_name VARCHAR(80),
    event_date VARCHAR(100),
    event_time VARCHAR(100),
    location VARCHAR(100),
    leader VARCHAR(100)
);

-- Вставка данных в таблицу schedule
INSERT INTO schedule(event_name, event_date, event_time, location, leader)
VALUES
    ('Lecture', '13 May', '12:00', 'B205', 'Mr Evans'),
    ('Conference', '20 May', '13:00', 'B200', 'Mrs Brown'),
    ('Meeting', '17 May', '14:00', 'B210', 'Mrs Smith'),
    ('Concert', '20 May', '17:00', 'Hall', 'Mr Evans'),
    ('Presentation', '19 May', '15:00', 'B204', 'Mrs Young');

-- Таблица profile
DROP TABLE IF EXISTS profile;
CREATE TABLE profile (
    id SERIAL PRIMARY KEY,
    name VARCHAR(80),
    status VARCHAR(100)
);

-- Вставка данных в таблицу profile
INSERT INTO profile(name, status)
VALUES
    ('Ivan Ivanov', 'Administrator'),
    ('Maxim Kim', 'Student'),
    ('Alex Novak', 'Teacher'),
    ('Pavel Durov', 'Organizer');

-- Таблица registration
DROP TABLE IF EXISTS registration;
CREATE TABLE registration (
    id SERIAL PRIMARY KEY,
    event VARCHAR(100),
    name VARCHAR(80)
);

-- Вставка данных в таблицу registration
INSERT INTO registration(event, name)
VALUES
    ('Lecture', 'Maxim Kim'),
    ('Conference', 'Pasha Popov'),
    ('Concert', 'Samira Johnson'),
    ('Presentation', 'Mila Smith');

-- Таблица progress
DROP TABLE IF EXISTS progress;
CREATE TABLE progress (
    id SERIAL PRIMARY KEY,
    event_name VARCHAR(80),
    status VARCHAR(100)
);

-- Вставка данных в таблицу progress
INSERT INTO progress(event_name, status)
VALUES
    ('Lecture', 'In progress...'),
    ('Conference', 'Done'),
    ('Meeting', 'In progress'),
    ('Concert', 'Done'),
    ('Presentation', 'In progress');

-- Таблица rating
DROP TABLE IF EXISTS rating;
CREATE TABLE rating (
    id SERIAL PRIMARY KEY,
    event_name VARCHAR(80),
    score INTEGER
);

-- Вставка данных в таблицу rating
INSERT INTO rating(event_name, score)
VALUES
    ('Lecture', 95),
    ('Conference', 90),
    ('Meeting', 100),
    ('Concert', 78),
    ('Presentation', 87);
