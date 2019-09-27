package com.scifisoft.MyWebApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String date;
	@NotEmpty
	private String startTime;
	@NotEmpty
	private String endTime;
	@NotEmpty
	private String description;
	@ManyToOne
	@JoinColumn(name = "EMAIL")
	private Employee employees;

	public Task() {

	}

	public Task(Long id, String date, String startTime, String endTime, String description) {
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

	public Task(String date, String startTime, String endTime, String description) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", description=" + description + ", employees=" + employees + "]";
	}

}
