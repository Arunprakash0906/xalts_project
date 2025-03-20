package com.example.APIController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Entity.Approval;
import com.example.Entity.Task;
import com.example.Service.TaskService;

public class TaskController {
	@Autowired
	private TaskService taskService;
	 @PostMapping()
	    public ResponseEntity<Task> createTask(@RequestBody Task request) {
	        Task task = taskService.createTask(request.getTitle(),request.getDescription(),
	                request.getCreatedBy(), request.getApprovers());
	        return ResponseEntity.ok(task);
	    }

	    @PostMapping("/{taskId}/approve")
	    public ResponseEntity<String> approveTask(@PathVariable Long taskId, @RequestBody Approval request) {
	        taskService.approveTask(taskId, request.getApprovedAt(), request.getComment());
	        return ResponseEntity.ok("Approval recorded");
	    }
}
