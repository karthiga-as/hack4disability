package com.cts.outreach.aspectj;

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

	@Before("execution (* com.cts.outreach.controller.CodelistController.getAllBaseLocations(..))")
	public void getAllBaseLocations() {
		logger.info("Before Getting the Base location list");
	}

	@Before("execution (* com.cts.outreach.controller.CodelistController.getAllBeneficiary(..))")
	public void getAllBeneficiary() {
		logger.info("Before Getting the Beneficairy list");
	}

	@Before("execution (* com.cts.outreach.controller.CodelistController.getAllCategory(..))")
	public void getAllCategory() {
		logger.info("Before Getting the Category list");
	}

	@Before("execution (* com.cts.outreach.controller.CodelistController.getAllCouncil(..))")
	public void getAllCouncil() {
		logger.info("Before Getting the Council list");
	}

	@Before("execution (* com.cts.outreach.controller.CodelistController.getAllIIEPCategory(..))")
	public void getAllIIEPCategory() {
		logger.info("Before Getting the IIEP category list");
	}

	@Before("execution (* com.cts.outreach.controller.CodelistController.getAllTemplate(..))")
	public void getAllTemplate() {
		logger.info("Before Getting the template list");
	}

	@Before("execution (* com.cts.outreach.controller.CodelistController.getAllProject(..))")
	public void getAllProject() {
		logger.info("Before Getting the project list");
	}

	@Before("execution (* com.cts.outreach.controller.CodelistController.getAllRole(..))")
	public void getAllRole() {
		logger.info("Before Getting the Role list");
	}

	@After("execution (* com.cts.outreach.controller.CodelistController.getAllBaseLocations(..))")
	public void getAllBaseLocationsAfter() {
		logger.info("After Getting the Base location list");
	}

	@After("execution (* com.cts.outreach.controller.CodelistController.getAllBeneficiary(..))")
	public void getAllBeneficiaryAfter() {
		logger.info("After Getting the Beneficairy list");
	}

	@After("execution (* com.cts.outreach.controller.CodelistController.getAllCategory(..))")
	public void getAllCategoryAfter() {
		logger.info("After Getting the Category list");
	}

	@After("execution (* com.cts.outreach.controller.CodelistController.getAllCouncil(..))")
	public void getAllCouncilAfter() {
		logger.info("After Getting the Council list");
	}

	@After("execution (* com.cts.outreach.controller.CodelistController.getAllIIEPCategory(..))")
	public void getAllIIEPCategoryAfter() {
		logger.info("After Getting the IIEP category list");
	}

	@After("execution (* com.cts.outreach.controller.CodelistController.getAllTemplate(..))")
	public void getAllTemplateAfter() {
		logger.info("After Getting the template list");
	}

	@After("execution (* com.cts.outreach.controller.CodelistController.getAllProject(..))")
	public void getAllProjectAfter() {
		logger.info("After Getting the project list");
	}

	@After("execution (* com.cts.outreach.controller.CodelistController.getAllRole(..))")
	public void getAllRoleAfter() {
		logger.info("After Getting the Role list");
	}

}