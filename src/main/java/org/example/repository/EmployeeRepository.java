package org.example.repository;

import org.example.entity.Employee;
// import org.springframework.data.repository.CrudRepository;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

import java.util.List;

public interface EmployeeRepository extends DatastoreRepository<Employee, Long>  {
    Employee findByEmployeeId(Long employeeId);
    //List<Employee> findByDepartmentId(Integer departmentId);
    List<Employee> findByFirstnameAndLastname(String firstname, String lastname);
}
