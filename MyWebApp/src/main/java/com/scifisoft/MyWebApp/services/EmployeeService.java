package com.scifisoft.MyWebApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.scifisoft.MyWebApp.entities.Employee;
import com.scifisoft.MyWebApp.entities.Role;
import com.scifisoft.MyWebApp.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void createEmployee(Employee employee) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		employee.setPassword(encoder.encode(employee.getPassword()));
		Role empRole = new Role("EMPLOYEE");
		List<Role> roles = new ArrayList<>();
		roles.add(empRole);
		employee.setRoles(roles);
		employeeRepository.save(employee);
	}

	public void createAdmin(Employee employee) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		employee.setPassword(encoder.encode(employee.getPassword()));
		Role empRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(empRole);
		employee.setRoles(roles);
		employeeRepository.save(employee);
	}

	public Employee findOne(String email) {
		return employeeRepository.findByEmail(email);
	}

	public boolean isEmployeePresent(String email) {
		Employee emp = employeeRepository.findByEmail(email);
		if (emp != null)
			return true;

		return false;
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
