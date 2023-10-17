package com.employee.employee.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.employee.employee.enities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    public Employee findById(int id);
}
