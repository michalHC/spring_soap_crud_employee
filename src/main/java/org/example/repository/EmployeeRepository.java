package org.example.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.example.entity.Employee;
public interface EmployeeRepository extends CrudRepository<Employee, Long>  {
    Employee findByEmployeeId(long employeeId);
    List<Employee> findByDepartmentId(Integer departmentId);
}
