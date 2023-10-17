package com.employee.employee.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.employee.Repositories.DepartmentRepository;
import com.employee.employee.enities.Department;

@Component
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment() {
        List<Department> list = (List<Department>) this.departmentRepository.findAll();

        return list;
    }

    public Department getDepartmentById(int id) {
        Department dept = null;
        try {
            dept = this.departmentRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dept;
    }

    // Add Department
    public Department addDepartment(Department department) {
        Department dept = null;
        try {
            dept = this.departmentRepository.save(department);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dept;

    }

    // Delete the Department
    public void deleteEmployeeById(int id) {
        this.departmentRepository.deleteById(id);
    }

    // Update the Depatrment
    public void updateDepartment(Department department, int id) {
        department.setDept_id(id);
        this.departmentRepository.save(department);

    }

    public void deleteAllDepartment() {
        this.departmentRepository.deleteAll(getAllDepartment());
    }
}
