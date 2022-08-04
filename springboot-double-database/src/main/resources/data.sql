DROP TABLE IF EXISTS student cascade;
DROP TABLE IF EXISTS teacher cascade;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  age INT NOT NULL,
  department VARCHAR(250) NOT NULL,
  salary INT NOT NULL
);

insert into employees(id,name,age, department, salary) values(1,'Abhishek', 25 , 'Engineer', 2500);
insert into employees(id,name,age, department, salary) values(2,'Raina', 25, 'PM', 2000);
insert into employees(id,name,age, department, salary) values(3,'Misc', 25, 'Management', 3000);