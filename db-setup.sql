CREATE DATABASE IF NOT EXISTS `hr`;
USE `hr`;

CREATE TABLE IF NOT EXISTS `employees` (
  `employee_id` bigint(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email_address` varchar(80),
  `job_id` varchar(5),
  `department_id` varchar(5),
  `salary` varchar(10)
);

INSERT INTO `employees` (`employee_id`, `first_name`, `last_name`, `salary`) VALUES
	(1, 'Tom', 'The Cat', 500),
	(2, 'Jerry', 'The Mouse', 350);

