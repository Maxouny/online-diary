-- Создаем таблицу для хранения данных из CSV с заголовками
CREATE TABLE student_data
(
    id            SERIAL PRIMARY KEY, -- Добавляем уникальный идентификатор
    family        VARCHAR,
    name          VARCHAR,
    age           INT,
    class       INT,
    physics       INT,
    mathematics   INT,
    rus           INT,
    literature    INT,
    geometry      INT,
    informatics   INT,
    average_grade double precision
);


CREATE TABLE curricula
(
    id      SERIAL PRIMARY KEY,
    subjects TEXT[]
);

CREATE TABLE classes
(
    id           SERIAL PRIMARY KEY,
    class_group  INT,
    curricula_id SERIAL,
    FOREIGN KEY (curricula_id) REFERENCES curricula (id)
);

CREATE TABLE student
(
    id       SERIAL PRIMARY KEY,
    family   VARCHAR,
    name     VARCHAR,
    age      INT,
    class_id INT,
    FOREIGN KEY (class_id) REFERENCES classes (id)
);


CREATE TABLE grades
(
    id            SERIAL PRIMARY KEY,
    physics       INT,
    mathematics   INT,
    rus           INT,
    literature    INT,
    geometry      INT,
    informatics   INT,
    average_grade double precision,
    student_id    SERIAL,
    FOREIGN KEY (student_id) REFERENCES student (id)
);





