CREATE SCHEMA IF NOT EXISTS test;
SET search_path TO test;

DROP TABLE IF EXISTS schedule;
CREATE TABLE schedule (
    id SERIAL PRIMARY KEY,
    event_name VARCHAR(80),
    event_date VARCHAR(100),
    event_time VARCHAR(100),
    location VARCHAR(100),
    leader VARCHAR(100)
);

INSERT INTO schedule(event_name, event_date, event_time, location, leader)
VALUES
    ('Lecture', '13 May', '12:00', 'B205', 'Mr Evans'),
    ('Conference', '20 May', '13:00', 'B200', 'Mrs Brown'),
    ('Meeting', '17 May', '14:00', 'B210', 'Mrs Smith'),
    ('Concert', '20 May', '17:00', 'Hall', 'Mr Evans'),
    ('Presentation', '19 May', '15:00', 'B204', 'Mrs Young');

DROP TABLE IF EXISTS profile;
CREATE TABLE profile (
    id SERIAL PRIMARY KEY,
    name VARCHAR(80),
    status VARCHAR(100)
);

INSERT INTO profile(name, status)
VALUES
    ('Ivan Ivanov', 'Administrator'),
    ('Maxim Kim', 'Student'),
    ('Alex Novak', 'Teacher'),
    ('Pavel Durov', 'Organizer');

DROP TABLE IF EXISTS registration;
CREATE TABLE registration (
    id SERIAL PRIMARY KEY,
    event VARCHAR(100),
    name VARCHAR(80)
);

INSERT INTO registration(event, name)
VALUES
    ('Lecture', 'Maxim Kim'),
    ('Conference', 'Pasha Popov'),
    ('Concert', 'Samira Johnson'),
    ('Presentation', 'Mila Smith');

DROP TABLE IF EXISTS progress;
CREATE TABLE progress (
    id SERIAL PRIMARY KEY,
    event_name VARCHAR(80),
    status VARCHAR(100)
);

INSERT INTO progress(event_name, status)
VALUES
    ('Lecture', 'In progress...'),
    ('Conference', 'Done'),
    ('Meeting', 'In progress'),
    ('Concert', 'Done'),
    ('Presentation', 'In progress');

DROP TABLE IF EXISTS rating;
CREATE TABLE rating (
    id SERIAL PRIMARY KEY,
    event_name VARCHAR(80),
    score INTEGER
);

INSERT INTO rating(event_name, score)
VALUES
    ('Lecture', 95),
    ('Conference', 90),
    ('Meeting', 100),
    ('Concert', 78),
    ('Presentation', 87);
