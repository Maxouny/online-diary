-- Создаем таблицу для хранения данных из CSV с заголовками
CREATE TABLE student_data
(
    id          SERIAL PRIMARY KEY, -- Добавляем уникальный идентификатор
    family      VARCHAR,
    name        VARCHAR,
    age         INT,
    class       INT,
    physics     INT,
    mathematics INT,
    rus         INT,
    literature  INT,
    geometry    INT,
    informatics INT
);

-- Создаем таблицу для хранения списка учеников
CREATE TABLE curricula
(
    id      SERIAL PRIMARY KEY,
    subjects TEXT[]
);

-- Создаем таблицу для хранения списка учебных групп
CREATE TABLE classes
(
    id           SERIAL PRIMARY KEY, -- Внешний ключ
    class_group  INT,
    curricula_id SERIAL,
    FOREIGN KEY (curricula_id) REFERENCES curricula (id)
);

-- Создаем таблицу для хранения учебных планов
CREATE TABLE student
(
    id       SERIAL PRIMARY KEY, -- Внешний ключ
    family   VARCHAR,
    name     VARCHAR,
    age      INT,
    class_id SERIAL,
    FOREIGN KEY (class_id) REFERENCES classes (id)
);


-- Создаем таблицу для хранения успеваемости учеников
CREATE TABLE grades
(
    id            SERIAL PRIMARY KEY, -- Внешний ключ
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





