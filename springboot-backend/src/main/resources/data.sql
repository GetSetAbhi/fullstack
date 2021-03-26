DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  designation VARCHAR(250) NOT NULL
);

insert into employees(id,name,designation) values(1,'CAP','Er');
insert into employees(id,name,designation) values(2,'Hulk','Dr');
insert into employees(id,name,designation) values(3,'Stark','Prof.');