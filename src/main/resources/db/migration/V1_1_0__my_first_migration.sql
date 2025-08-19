BEGIN;

CREATE TABLE students
(
    id         SERIAL PRIMARY KEY,
    full_name  VARCHAR(100) NOT NULL,
    grade      DECIMAL(4,2) NOT NULL CHECK (grade >=0 AND GRADE <=10),
    study_year INT NOT NULL,
    faculty    VARCHAR(50) NOT NULL
);

CREATE TABLE disciplines
(
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    category VARCHAR(20) NOT NULL,
    study_year INT NOT NULL,
    max_students INT NOT NULL,
    teacher VARCHAR(100) NOT NULL
);

CREATE TABLE preferences
(
    id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES students(id) ON DELETE CASCADE,
    discipline_id INT NOT NULL REFERENCES disciplines(id) ON DELETE CASCADE,
    preference_rank INT NOT NULL,
    UNIQUE(student_id, discipline_id),
    UNIQUE(student_id, preference_rank)
);

CREATE TABLE enrollments
(
    id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES students(id) ON DELETE CASCADE,
    discipline_id INT NOT NULL REFERENCES disciplines(id) ON DELETE CASCADE,
    UNIQUE(student_id, discipline_id)
);

COMMIT;