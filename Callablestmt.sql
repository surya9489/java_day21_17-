CREATE SCHEMA callable;
USE callable;

CREATE TABLE Student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    marks INT
);

SHOW TABLES;
DESC Student;
SELECT * FROM Student;