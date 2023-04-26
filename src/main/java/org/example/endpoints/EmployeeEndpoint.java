package org.example.endpoints;

import org.example.crud_ws.*;

import org.example.entity.Employee;
import org.example.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;


@Endpoint
public class EmployeeEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.org/employee-ws";
    @Autowired
    private IEmployeeService employeeService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
    @ResponsePayload
    public GetEmployeeByIdResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
        GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()), employeeInfo);
        response.setEmployeeInfo(employeeInfo);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmployeesRequest")
    @ResponsePayload
    public GetAllEmployeesResponse getAllEmployees() {
        GetAllEmployeesResponse response = new GetAllEmployeesResponse();
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();
        List<Employee> employeeList = employeeService.getAllEmployees();
        for (Employee employee : employeeList) {
            EmployeeInfo ob = new EmployeeInfo();
            BeanUtils.copyProperties(employee, ob);
            employeeInfoList.add(ob);
        }
        response.getEmployeeInfo().addAll(employeeInfoList);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
    @ResponsePayload
    public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
        AddEmployeeResponse response = new AddEmployeeResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Employee employee = new Employee();
        employee.setFirstname(request.getFirstname());
        employee.setLastname(request.getLastname());
        employee.setEmail(request.getEmail());
        boolean flag = employeeService.addEmployee(employee);
        if (!flag) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Employee Already Available");
            response.setServiceStatus(serviceStatus);
        } else {
            EmployeeInfo employeeInfo = new EmployeeInfo();
            BeanUtils.copyProperties(employee, employeeInfo);
            response.setEmployeeInfo(employeeInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Employee Added Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
        employeeService.updateEmployee(employee);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Employee Updated Successfully");
        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
        Employee employee = employeeService.getEmployeeById(request.getEmployeeId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (employee == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Employee Not Available");
        } else {
            employeeService.deleteEmployee(employee);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Employee Deleted Successfully");
        }
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}

