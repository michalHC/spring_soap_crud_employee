package org.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="employees")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    private long employeeId;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="email_address")
    private String email;
    @Column(name="job_id")
    private String jobId;
    @Column(name="department_id")
    private String departmentId;
    @Column(name="salary")
    private String salary;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId){
        this.employeeId = employeeId;
    }
    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getJobId() {
        return jobId;
    }

    public String getSalary() {
        return salary;
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
