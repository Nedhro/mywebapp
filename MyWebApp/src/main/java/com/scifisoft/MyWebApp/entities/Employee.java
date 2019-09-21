package com.scifisoft.MyWebApp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String name;
	@Size(min = 4)
	private String password;
	private String address;
	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	private List<Task> tasks;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ROLES", joinColumns = {
			@JoinColumn(name = "EMAIL", referencedColumnName = "email") }, inverseJoinColumns = {
					@JoinColumn(name = "NAME", referencedColumnName = "name") })
	private List<Role> roles;

	public Employee() {
	}

	public Employee(@Email @NotEmpty String email, @NotEmpty String name, @Size(min = 4) String password,
			String address) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", tasks=" + tasks + ", roles=" + roles + "]";
	}

}
