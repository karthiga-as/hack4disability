package com.cts.outreach.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect

@Component

public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution (* com.cts.outreach.controller.EventController.registerEvent(..))")
	public void addEvent(JoinPoint jointpoint) {
		logger.info("Before Creating the Event");
	}
	
	@Before("execution (* com.cts.outreach.controller.EventController.getAllEvents(..))")
	public void getAllEvents(JoinPoint jointpoint) {
		logger.info("Before Getting all the Events");
	}

	@Before("execution (* com.cts.outreach.controller.EventController.updateEvent(..))")
	public void updateEvent(JoinPoint jointpoint) {
		logger.info("Before Updating the Event");
	}

	@Before("execution (* com.cts.outreach.controller.EventController.deleteEvent(..))")
	public void deleteEvent() {
		logger.info("Before deleting the Event");
	}

	@Before("execution (* com.cts.outreach.controller.EventController.fetchEventDetails(..))")
	public void fetchEventDetails() {
		logger.info("Before fetching the Event details");
	}

	@After("execution (* com.cts.outreach.controller.EventController.registerEvent(..))")
	public void addEventAfter(JoinPoint jointpoint) {
		logger.info("After Creating the Event");
	}
	
	@After("execution (* com.cts.outreach.controller.EventController.getAllEvents(..))")
	public void getAllEventsAfter(JoinPoint jointpoint) {
		logger.info("After Getting All the Events");
	}

	@After("execution (* com.cts.outreach.controller.EventController.updateEvent(..))")
	public void updateEventAfter(JoinPoint jointpoint) {
		logger.info("After Updating the Event");
	}

	@After("execution (* com.cts.outreach.controller.EventController.deleteEvent(..))")
	public void deleteEventAfter() {
		logger.info("After deleting the Event");
	}

	@After("execution (* com.cts.outreach.controller.EventController.fetchEventDetails(..))")
	public void fetchEventDetailsAfter() {
		logger.info("After fetching the Event details");
	}

}