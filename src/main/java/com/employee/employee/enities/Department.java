package com.employee.employee.enities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dept_id;
    private String dept_Name;

    public Department() {
    }

    public Department(int dept_id, String dept_Name) {
        this.dept_id = dept_id;
        this.dept_Name = dept_Name;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_Name() {
        return dept_Name;
    }

    public void setDept_Name(String dept_Name) {
        this.dept_Name = dept_Name;
    }

    @Override
    public String toString() {
        return "Department [dept_id=" + dept_id + ", dept_Name=" + dept_Name + "]";
    }

}
