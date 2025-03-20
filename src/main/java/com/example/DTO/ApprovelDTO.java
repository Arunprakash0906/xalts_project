package com.example.DTO;

import java.time.LocalDateTime;

import com.example.Entity.ApprovalStatus;
import com.example.Entity.Task;
import com.example.Entity.User;

public class ApprovelDTO {
	private Long id;
    private Task task;
    private User approver;
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
	public User getApprover() {
		return approver;
	}
	public void setApprover(User approver) {
		this.approver = approver;
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
