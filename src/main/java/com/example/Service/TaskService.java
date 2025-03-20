package com.example.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Entity.Approval;
import com.example.Entity.ApprovalStatus;
import com.example.Entity.Task;
import com.example.Entity.TaskStatus;
import com.example.Entity.User;
import com.example.Respository.ApprovalRepository;
import com.example.Respository.TaskRepository;
import com.example.Respository.UserRepository;

public class TaskService {
	@Autowired
	 private UserRepository userRepository;
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private ApprovalRepository approvalRepository;
	private int usercount=0;
	public Task createTask(String title,String description,Long Id,List<Long> approvers)throws Exception {
		
		//int count=0;
        User creater = userRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
       task.setTitle(title);
        task.setDescription(description);
        task.setCreatedBy(creater);
        usercount++;
        task = taskRepository.save(task);

        for (Long approverId : approvers) {
            Optional<User> approver = userRepository.findById(approverId);
             if(approver.isEmpty()) {
            	 throw new RuntimeException("Approver not found......");
             }
            Approval app = new Approval();
            app.setTask(task);
            app.setApprover(approver);
            approvalRepository.save(app);
        }

        return task;
    }

   public void approveTask(Long taskId,Long approverId,String comment)throws Exception {
        Optional<Approval> approvals = approvalRepository.findById(taskId);
        Approval approval = approvals.stream()
                .filter(a -> a.getApprover().get().equals(approverId) )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Approval not found"));

        approval.setStatus(ApprovalStatus.APPROVED);
        
        approval.setComment(comment);
       approval.setApprovedAt(LocalDateTime.now());
        approvalRepository.save(approval);

        if (approvals.stream().allMatch(a -> a.getStatus() == ApprovalStatus.APPROVED)) {
            Task task = approval.getTask();
            task.setStatus(TaskStatus.APPROVED);
            taskRepository.save(task);
        }
    }

public Task createTask(String title, String description, User createdBy) {
	// TODO Auto-generated method stub
	return null;
}

}
