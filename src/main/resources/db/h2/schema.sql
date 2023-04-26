DROP TABLE employees IF EXISTS;

CREATE TABLE employees (
  employee_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email_address VARCHAR(80),
  job_id VARCHAR(5),
  department_id VARCHAR(5),
  salary VARCHAR(10)
);