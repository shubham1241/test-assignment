package com.test.employee.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String location;
	
	@Column
	private String department;
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee( String name, String location, String department) {
		super();
	
		this.name = name;
		this.location = location;
		this.department = department;
	}


	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", location=" + location + ", department=" + department + "]";
	}

}

