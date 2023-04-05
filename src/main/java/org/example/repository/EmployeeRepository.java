package org.example.repository;

import org.example.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>  {
    Employee findByEmployeeId(long employeeId);
    //List<Employee> findByDepartmentId(Integer departmentId);
    List<Employee> findByFirstnameAndLastname(String firstname, String lastname);
}
