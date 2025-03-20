package com.example.Entity;

import java.time.LocalDateTime;
import java.util.Optional;

public class Approval {
	
	private Long id;
    private Task task;
    private Optional<User> approver;
    private ApprovalStatus status = ApprovalStatus.PENDING;
    private String comment;
    private LocalDateTime approvedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Optional<User> getApprover() {
		return approver;
	}
	public void setApprover(Optional<User> approver2) {
		this.approver = approver2;
	}
	public ApprovalStatus getStatus() {
		return status;
	}
	public void setStatus(ApprovalStatus status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getApprovedAt() {
		return approvedAt;
	}
	public void setApprovedAt(LocalDateTime approvedAt) {
		this.approvedAt = approvedAt;
	}
    
    
}
