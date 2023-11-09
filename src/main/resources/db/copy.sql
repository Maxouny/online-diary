COPY student_data (family,
                   name,
                   age,
                   class,
                   physics,
                   mathematics,
                   rus,
                   literature,
                   geometry,
                   informatics)
    FROM '/students.csv' DELIMITER ';' CSV HEADER;

INSERT INTO curricula (subjects)
SELECT ARRAY ['physics', 'mathematics', 'rus', 'literature', 'geometry', 'informatics']
FROM generate_series(1, 12);

INSERT INTO classes (class_group)
SELECT DISTINCT class
FROM student_data;

INSERT INTO student (id, family, name, age, class_id)
SELECT student_data.id, family, name, age, class_group
FROM student_data
JOIN classes ON student_data.class = classes.class_group;

INSERT INTO grades (physics, mathematics, rus, literature, geometry, informatics, student_id)
SELECT physics, mathematics, rus, literature, geometry, informatics, student.id
FROM student_data
         JOIN student ON student_data.id = student.id;

UPDATE grades
SET average_grade = (physics + mathematics + rus + literature + geometry + informatics) / 6;
DROP TABLE student_data;

