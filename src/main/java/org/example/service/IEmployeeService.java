package org.example.service;

import org.example.entity.Employee;

import java.util.List;
public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long employeeId);
    boolean addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
