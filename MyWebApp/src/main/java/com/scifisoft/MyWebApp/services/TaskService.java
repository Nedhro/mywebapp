package com.scifisoft.MyWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scifisoft.MyWebApp.entities.Employee;
import com.scifisoft.MyWebApp.entities.Task;
import com.scifisoft.MyWebApp.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public void addTask(Task task, Employee employee) {
		task.setEmployees(employee);
		taskRepository.save(task);
	}

	public List<Task> findEmployeeTask(Employee employee) {
		return taskRepository.findByEmployees(employee);

	}

}
