package org.example.service;

import java.util.List;
import org.example.entity.Employee;
public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long employeeId);
}
