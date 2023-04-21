package org.example.entity;

import org.springframework.data.annotation.Id;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;

@Entity(name="employees")
public class Employee{
    //private static final Long serialVersionUID = 1L;
    @Id
    private Long employeeId;

    private String firstname;
    
    private String lastname;

    private String email;
    
    private String jobId;

    private String departmentId;

    private String salary;

    public Employee(){
        this.firstname = "Sample";
        this.lastname = "Employee";
    };
    public Employee(String firstname, String lastname, String email, String jobId, String departmentId, String salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.jobId = jobId;
        this.departmentId = departmentId;
        this.salary = salary;
      }

    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId){
        this.employeeId = employeeId;
    }
    public String getFirstname(){
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname(){
        return this.lastname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public String getJobId() {
        return this.jobId;
    }

    public String getSalary() {
        return this.salary;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


}
