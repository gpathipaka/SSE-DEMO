package com.ganga.springmvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ganga.springmvc.domain.ApplicationEventListener;
import com.ganga.springmvc.domain.Player;
import com.ganga.springmvc.domain.SubmissionEvent;

@RestController
public class HelloWorldRestController {

	@Autowired
	private ApplicationEventListener appEventLst;
	
	@RequestMapping("/hello/{player}")
	public Player message(@PathVariable String player) {
		Player message = new Player(player, "Hello.. " + player);
		//testing
		return message;
	}
	
	
	@RequestMapping("/welcom")
	public ModelAndView testThis() {
		ModelAndView mav = new ModelAndView("welcome");
		
		
		SseEmitter emitter = new SseEmitter();
		try {
			emitter.send("Got the reqeust");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//return "welcome";
		return mav;
	}
	
	@RequestMapping("publishEvent")
	public String publishEvent() {
		try {
			appEventLst.submissionEventHandler(new SubmissionEvent(this, 123456789, "Message from Server to you..."));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "done";
	}
	
	
	  @RequestMapping("/sse")
	    public SseEmitter getSseEmitter() {
		  System.out.println("got the request....");
	        SseEmitter sseEmitter = new SseEmitter();
	            try {
	            	appEventLst.addSseEmitters(123456789, sseEmitter);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        return sseEmitter;
	    }
	  
}