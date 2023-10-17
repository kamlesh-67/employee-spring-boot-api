package com.employee.employee.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.Services.EmployeeServices;
import com.employee.employee.enities.Employee;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee() {

        List<Employee> emp_list = this.employeeServices.getAllEmployee();
        if (emp_list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(emp_list);
        }
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {

        Employee employee = this.employeeServices.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok().body(employee);
        }
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<Employee> addEemployee(@RequestBody Employee employee) {
        Employee emp = null;
        try {
            emp = this.employeeServices.addEmployee(employee);
            return ResponseEntity.of(Optional.of(emp));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<Void> deleteEemployee(@PathVariable("id") int id) {

        try {
            this.employeeServices.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        // return null;
    }

    @DeleteMapping(value = "/employees")
    public ResponseEntity<Void> deteteAllEemployee() {
        try {
            this.employeeServices.deteteAllEmployee();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        try {
            this.employeeServices.updateEmployee(employee, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

}
