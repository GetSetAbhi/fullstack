ALTER TABLE IF EXISTS email DROP CONSTRAINT IF EXISTS FK_EID;

DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  designation VARCHAR(250) NOT NULL
);

CREATE TABLE email (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  eid INT NOT NULL,
  CONSTRAINT FK_EID FOREIGN KEY (eid) REFERENCES employees(id)
);

insert into employees(id,name,designation) values(1,'CAP','Er');
insert into employees(id,name,designation) values(2,'Hulk','Dr');
insert into employees(id,name,designation) values(3,'Stark','Prof.');

insert into email(id,email,eid) values(1,'cap@am.com',1);
insert into email(id,email,eid) values(2,'steve.r@avengers.com',1);
insert into email(id,email,eid) values(3,'tony.s@avengers.com',3);
insert into email(id,email,eid) values(4,'iron_man@avengers.com',3);