package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {
	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendTaskApprovalRequest(String to, String taskTitle) {
	    	
	        SimpleMailMessage message = new SimpleMailMessage();
	         message.setTo(to);
	        message.setSubject("Task Approval Request");
	        message.setText("You have been assigned to approve the task: " + taskTitle);
	        mailSender.send(message);
	        
	    }
}
