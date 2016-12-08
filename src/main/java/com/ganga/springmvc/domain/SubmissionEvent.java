package com.ganga.springmvc.domain;

import org.springframework.context.ApplicationEvent;

public class SubmissionEvent extends ApplicationEvent{

	
	public SubmissionEvent(Object source, long submissionId, String message) {
        super(source);
        this.submissionId = submissionId;
        this.message = message;
    }
 
    // getters and setters
 
    private final long submissionId;
 
    private final String message;

	public long getSubmissionId() {
		return submissionId;
	}

	public String getMessage() {
		return message;
	}
    
    
}
