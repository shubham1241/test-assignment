package com.test.employee.controller;

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

import com.test.employee.Model.Employee;
import com.test.employee.repo.EmployeeTable;

@RestController
public class Controller {
	
//	@Autowired
//	Employee employee;
	
	@Autowired
	EmployeeTable table;
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return table.findAll();	
		}
	
	@PostMapping("/post")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			Employee emp=table.save(employee);
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		Optional<Employee> emp = table.findById(id);

		if (emp.isPresent()) {
			Employee emp1 = emp.get();
			emp1.setName(employee.getName());
			emp1.setDepartment(employee.getDepartment());
			emp1.setLocation(employee.getLocation());
			return new ResponseEntity<>(table.save(emp1), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
		try {
			table.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}