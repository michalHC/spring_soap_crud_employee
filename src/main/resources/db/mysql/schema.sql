CREATE TABLE IF NOT EXISTS employees (
  employee_id bigint(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  email_address varchar(80),
  job_id varchar(5),
  department_id varchar(5),
  salary varchar(10)
);