package org.example.service;

import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(long employeeId){
        Employee obj = employeeRepository.findByEmployeeId(employeeId);
        return obj;
    }
    @Override
    public List<Employee> getAllEmployees(){
        List<Employee> list = new ArrayList<>();
        employeeRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public synchronized boolean addEmployee(Employee employee){
        List<Employee> list = employeeRepository.findByFirstnameAndLastname(employee.getFirstname(), employee.getLastname());
        if(list.size() > 0){
            return false;
        } else {
            employee = employeeRepository.save(employee);
            return true;
        }
    }
    @Override
    public void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    @Override
    public void deleteEmployee(Employee employee){
        employeeRepository.delete(employee);
    }

}
