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

	@Before("execution (* com.cts.outreach.controller.UserController.registerUser(..))")

	public void addUser(JoinPoint jointpoint) {

		logger.info("Before Creating the User");

	}

	@Before("execution (* com.cts.outreach.controller.UserController.updateUser(..))")

	public void updateUser(JoinPoint jointpoint) {

		logger.info("Before Updating the User");

	}

	@Before("execution (* com.cts.outreach.controller.UserController.deleteUser(..))")

	public void deleteUser() {

		logger.info("Before deleting the User");

	}

	@Before("execution (* com.cts.outreach.controller.UserController.fetchUserDetails(..))")

	public void fetchUserDetails() {

		logger.info("Before fetching the user details");

	}

	@After("execution (* com.cts.outreach.controller.UserController.registerUser(..))")

	public void addUserAfter(JoinPoint jointpoint) {

		logger.info("After Creating the User");

	}

	@After("execution (* com.cts.outreach.controller.UserController.updateUser(..))")

	public void updateUserAfter(JoinPoint jointpoint) {

		logger.info("After Updating the User");

	}

	@After("execution (* com.cts.outreach.controller.UserController.deleteUser(..))")

	public void deleteUserAfter() {

		logger.info("After deleting the User");

	}

	@After("execution (* com.cts.outreach.controller.UserController.fetchUserDetails(..))")

	public void fetchUserDetailsAfter() {

		logger.info("After fetching the user details");

	}

}