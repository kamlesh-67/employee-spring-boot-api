package com.employee.employee.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.employee.employee.enities.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    public Department findById(int id);

}
