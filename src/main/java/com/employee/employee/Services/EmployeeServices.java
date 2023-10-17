package com.employee.employee.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.employee.Repositories.EmployeeRepository;
import com.employee.employee.enities.Employee;

@Component
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {

        List<Employee> list = (List<Employee>) this.employeeRepository.findAll();

        return list;
    }

    public Employee getEmployeeById(int id) {
        Employee emp = null;
        try {
            emp = this.employeeRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    // Add Employee
    public Employee addEmployee(Employee employee) {
        Employee result = null;
        try {
            result = this.employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Delete the Employee
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteById(id);
    }

    // Update the Employee
    public void updateEmployee(Employee employee, int id) {

        employee.setEmp_Id(id);
        this.employeeRepository.save(employee);

    }

    public void deteteAllEmployee() {
        this.employeeRepository.deleteAll(getAllEmployee());
    }

}
