package com.scifisoft.MyWebApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scifisoft.MyWebApp.entities.Employee;
import com.scifisoft.MyWebApp.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByEmployees(Employee employee);

}
