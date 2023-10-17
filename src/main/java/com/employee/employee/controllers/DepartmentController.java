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

import com.employee.employee.Services.DepartmentServices;
import com.employee.employee.enities.Department;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServices departmentServices;

    @GetMapping(value = "/department")
    public ResponseEntity<List<Department>> getAllDepartment() {
        List<Department> dept_list = this.departmentServices.getAllDepartment();
        if (dept_list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(dept_list);
        }
    }

    @GetMapping(value = "/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id) {

        Department dept = this.departmentServices.getDepartmentById(id);
        if (dept == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok().body(dept);
        }
    }

    @PostMapping(value = "/department")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department dept = null;
        try {
            dept = this.departmentServices.addDepartment(department);
            return ResponseEntity.of(Optional.of(dept));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/department/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") int id) {

        try {
            this.departmentServices.deleteEmployeeById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        // return null;
    }

    @DeleteMapping(value = "/department")
    public ResponseEntity<Void> deteteAllDepartment() {
        try {
            this.departmentServices.deleteAllDepartment();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @PutMapping(value = "/department/{id}")
    public ResponseEntity<Void> updateDepartment(@RequestBody Department department, @PathVariable("id") int id) {
        try {
            this.departmentServices.updateDepartment(department, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

}
