package com.scifisoft.MyWebApp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<Employee> employees;

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public Role(String name, List<Employee> employees) {
		this.name = name;
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", employees=" + employees + "]";
	}

}
