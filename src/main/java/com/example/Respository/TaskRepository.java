package com.example.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
