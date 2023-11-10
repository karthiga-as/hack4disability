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

	@Before("execution (* com.cts.outreach.controller.VolunteerController.registerVolunteer(..))")
	public void addVolunteer(JoinPoint jointpoint) {
		logger.info("Before Creating the Volunteer");
	}
	
	@Before("execution (* com.cts.outreach.controller.VolunteerController.getAllVolunteers(..))")
	public void getAllVolunteers(JoinPoint jointpoint) {
		logger.info("Before Getting all the Volunteers");
	}

	@Before("execution (* com.cts.outreach.controller.VolunteerController.updateVolunteer(..))")
	public void updateVolunteer(JoinPoint jointpoint) {
		logger.info("Before Updating the Volunteer");
	}

	@Before("execution (* com.cts.outreach.controller.VolunteerController.deleteVolunteer(..))")
	public void deleteVolunteer() {
		logger.info("Before deleting the Volunteer");
	}

	@Before("execution (* com.cts.outreach.controller.VolunteerController.fetchVolunteerDetails(..))")
	public void fetchVolunteerDetails() {
		logger.info("Before fetching the Volunteer details");
	}

	@After("execution (* com.cts.outreach.controller.VolunteerController.registerVolunteer(..))")
	public void addVolunteerAfter(JoinPoint jointpoint) {
		logger.info("After Creating the Volunteer");
	}
	
	@After("execution (* com.cts.outreach.controller.VolunteerController.getAllVolunteers(..))")
	public void getAllVolunteersAfter(JoinPoint jointpoint) {
		logger.info("After Getting All the Volunteers");
	}

	@After("execution (* com.cts.outreach.controller.VolunteerController.updateVolunteer(..))")
	public void updateVolunteerAfter(JoinPoint jointpoint) {
		logger.info("After Updating the Volunteer");
	}

	@After("execution (* com.cts.outreach.controller.VolunteerController.deleteVolunteer(..))")
	public void deleteVolunteerAfter() {
		logger.info("After deleting the Volunteer");
	}

	@After("execution (* com.cts.outreach.controller.VolunteerController.fetchVolunteerDetails(..))")
	public void fetchVolunteerDetailsAfter() {
		logger.info("After fetching the Volunteer details");
	}

}