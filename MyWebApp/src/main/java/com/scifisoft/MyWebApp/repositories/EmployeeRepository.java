package com.scifisoft.MyWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scifisoft.MyWebApp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	Employee findByEmail(String email);

}
