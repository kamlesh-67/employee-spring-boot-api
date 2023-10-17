package com.employee.employee.enities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_Id;
    private String emp_Name;
    private String emp_Add;
    private String emp_Phone;
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    private Department Department;

    public Employee() {
    }

    public Employee(int emp_Id, String emp_Name, String emp_Add, String emp_Phone, double salary,
            com.employee.employee.enities.Department department) {
        this.emp_Id = emp_Id;
        this.emp_Name = emp_Name;
        this.emp_Add = emp_Add;
        this.emp_Phone = emp_Phone;
        this.salary = salary;
        Department = department;
    }

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_No) {
        this.emp_Id = emp_No;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public String getEmp_Add() {
        return emp_Add;
    }

    public void setEmp_Add(String emp_Add) {
        this.emp_Add = emp_Add;
    }

    public String getEmp_Phone() {
        return emp_Phone;
    }

    public void setEmp_Phone(String emp_Phone) {
        this.emp_Phone = emp_Phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return Department;
    }

    public void setDepartment(Department department) {
        Department = department;
    }

    @Override
    public String toString() {
        return "Employee [emp_Id=" + emp_Id + ", emp_Name=" + emp_Name + ", emp_Add=" + emp_Add + ", emp_Phone="
                + emp_Phone + ", salary=" + salary + ", Department=" + Department + "]";
    }

}
