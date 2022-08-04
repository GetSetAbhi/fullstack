create database STUDENT;

use STUDENT;

CREATE TABLE STUDENT (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  age INT NOT NULL
);

insert into STUDENT(id,name,age) values (1,'Abhishek', 25);
insert into STUDENT(id,name,age) values (2,'Raina', 25);
insert into STUDENT(id,name,age) values (3,'Abhi', 25);


create database TEACHER;

use TEACHER;

CREATE TABLE TEACHER (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  age INT NOT NULL
);

insert into TEACHER(id,name,age) values (1,'Archana', 25);
insert into TEACHER(id,name,age) values (2,'Nirmal', 25);
insert into TEACHER(id,name,age) values (3,'Rathore', 25);