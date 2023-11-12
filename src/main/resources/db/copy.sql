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

UPDATE student_data
SET average_grade = (physics + mathematics + rus + literature + geometry + informatics) / 6;

INSERT INTO curricula (subjects)
SELECT ARRAY ['physics', 'mathematics', 'rus', 'literature', 'geometry', 'informatics']
FROM generate_series(1, 12);

INSERT INTO classes (class_group)
SELECT DISTINCT class
FROM student_data;

UPDATE classes
SET class_group = id
WHERE id != class_group;

INSERT INTO student (id, family, name, age, class_id)
SELECT student_data.id, family, name, age, classes.id
FROM student_data
JOIN classes ON student_data.class = classes.class_group;

INSERT INTO grades (physics, mathematics, rus, literature, geometry, informatics, student_id)
SELECT physics, mathematics, rus, literature, geometry, informatics, student.id
FROM student_data
         JOIN student ON student_data.id = student.id;

-- UPDATE grades
-- SET student_id = id
-- WHERE id != grades.student_id;

UPDATE grades
SET average_grade = (physics + mathematics + rus + literature + geometry + informatics) / 6;

ALTER TABLE student_data RENAME COLUMN "class" TO "classes_group";

