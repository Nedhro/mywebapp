package com.scifisoft.MyWebApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scifisoft.MyWebApp.entities.Employee;
import com.scifisoft.MyWebApp.entities.Task;
import com.scifisoft.MyWebApp.services.EmployeeService;
import com.scifisoft.MyWebApp.services.TaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyWebAppApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private TaskService taskService;

	@Before
	public void initDb() {
		{
			Employee newEmployee = new Employee("testEmployee@gmail.com", "testEmployee", "123456", "Mohammadpur");
			employeeService.createEmployee(newEmployee);
		}
		{
			Employee newAdmin = new Employee("testAdmin@gmail.com", "testAdmin", "123456", "Mohammadpur");
			employeeService.createAdmin(newAdmin);
		}
		{
			Task empTask = new Task("03/01/2019", "00:11", "11:00", "You need to work today");
			Employee employee = employeeService.findOne("testEmployee@gmail.com");
			taskService.addTask(empTask, employee);
		}
	}

	@Test
	public void testTask() {
		Employee employee = employeeService.findOne("testEmployee@gmail.com");
		List<Task> tasks = taskService.findEmployeeTask(employee);
		assertNotNull(tasks);
	}

	@Test
	public void testEmployee() {
		Employee emp = employeeService.findOne("testEmployee@gmail.com");
		assertNotNull(emp);
		Employee admin = employeeService.findOne("testAdmin@gmail.com");
		assertEquals(admin.getEmail(), "testAdmin@gmail.com");
	}

}
