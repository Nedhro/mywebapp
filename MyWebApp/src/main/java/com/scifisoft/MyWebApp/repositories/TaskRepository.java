package com.scifisoft.MyWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scifisoft.MyWebApp.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
