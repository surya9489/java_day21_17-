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

TRUNCATE TABLE Student;

-----------------------------------------------------------------

USE callable;

DELIMITER //

CREATE PROCEDURE addStudent(
    IN sid INT,
    IN sname VARCHAR(100),
    IN smarks INT
)
BEGIN
    INSERT INTO Student VALUES (sid, sname, smarks);
END //

DELIMITER ;

---------------------------------------------------------------------

USE callable;

DELIMITER //

CREATE PROCEDURE getStudentById(IN sid INT)
BEGIN
    SELECT * FROM Student
    WHERE id = sid;
END //

DELIMITER ;

DROP PROCEDURE IF EXISTS getStudentById;

