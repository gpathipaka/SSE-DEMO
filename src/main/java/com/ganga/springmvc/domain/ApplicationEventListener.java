package com.ganga.springmvc.domain;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class ApplicationEventListener {
    @EventListener
    public void submissionEventHandler(SubmissionEvent event) throws IOException {
        long submissionId = event.getSubmissionId();
        String message = event.getMessage();
        SseEmitter sseEmitter = sseEmitters.get(submissionId);
 
        if ( sseEmitter == null ) {
           System.out.println("SSE Emitter is null " +submissionId);
            return;
        }
		sseEmitter.send("Sending 5 messages .....");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			sseEmitter.send(message + " " + (i + 1));

		}
    }
    
    public void addSseEmitters(long submissionId, SseEmitter sseEmitter) {
        sseEmitters.put(submissionId, sseEmitter);
    }
 
    private static Map<Long, SseEmitter> sseEmitters = new Hashtable<Long, SseEmitter>();


}
