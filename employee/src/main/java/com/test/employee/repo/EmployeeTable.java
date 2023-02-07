package com.test.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.employee.Model.Employee;
@Repository
public interface EmployeeTable extends JpaRepository<Employee,Long> {

}

