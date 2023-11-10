package com.cts.outreach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.outreach.exceptions.DataNotFoundException;
import com.cts.outreach.model.OutreachBaseLocation;
import com.cts.outreach.model.OutreachBeneficiary;
import com.cts.outreach.model.OutreachCategory;
import com.cts.outreach.model.OutreachCouncil;
import com.cts.outreach.model.OutreachIIEPCategory;
import com.cts.outreach.model.OutreachNotificationTemplate;
import com.cts.outreach.model.OutreachProject;
import com.cts.outreach.model.OutreachRole;
import com.cts.outreach.service.CodelistService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping(value = "/api/codelist")
public class CodelistController {

	CodelistService codelistService;

	@Autowired
	public CodelistController(CodelistService eventService) {
		this.codelistService = eventService;
	}

	@ApiOperation(value = "Get all Base Locations", response = Iterable.class)
	@GetMapping("/baselocationlist")
	public ResponseEntity<?> getAllBaseLocations() throws DataNotFoundException {
		List<OutreachBaseLocation> baseLocationlist;
		try {
			baseLocationlist = codelistService.getAllBaseLocations();
			return new ResponseEntity<>(baseLocationlist, HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Get all Beneficiary", response = Iterable.class)
	@GetMapping("/beneficiaryList")
	public ResponseEntity<?> getAllBeneficiary() throws DataNotFoundException {
		List<OutreachBeneficiary> beneficiarylist;
		try {
			beneficiarylist = codelistService.getBeneficiaryList();
			return new ResponseEntity<>(beneficiarylist, HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Get all Category", response = Iterable.class)
	@GetMapping("/categorylist")
	public ResponseEntity<?> getAllCategory() throws DataNotFoundException {
		List<OutreachCategory> categorylist;
		try {
			categorylist = codelistService.getCategoryList();
			return new ResponseEntity<>(categorylist, HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Get all Council", response = Iterable.class)
	@GetMapping("/councillist")
	public ResponseEntity<?> getAllCouncil() throws DataNotFoundException {
		List<OutreachCouncil> councillist;
		try {
			councillist = codelistService.getAllCouncils();
			return new ResponseEntity<>(councillist, HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Get all IIEPCategory", response = Iterable.class)
	@GetMapping("/iiepCategorylist")
	public ResponseEntity<?> getAllIIEPCategory() throws DataNotFoundException {
		List<OutreachIIEPCategory> iiepCategorylist;
		try {
			iiepCategorylist = codelistService.getIIEPCategoryList();
			return new ResponseEntity<>(iiepCategorylist, HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Get all Notification Templates", response = Iterable.class)
	@GetMapping("/templatelist")
	public ResponseEntity<?> getAllTemplate() throws DataNotFoundException {
		List<OutreachNotificationTemplate> templateList;
		try {
			templateList = codelistService.getAllTemplates();
			return new ResponseEntity<>(templateList, HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Get all Project", response = Iterable.class)
	@GetMapping("/projectlist")
	public ResponseEntity<?> getAllProject() throws DataNotFoundException {
		List<OutreachProject> projectList;
		try {
			projectList = codelistService.getAllProjects();
			return new ResponseEntity<>(projectList, HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Get all Roles", response = Iterable.class)
	@GetMapping("/rolelist")
	public ResponseEntity<?> getAllRole() throws DataNotFoundException {
		List<OutreachRole> roleList;
		try {
			roleList = codelistService.getAllRoles();
			return new ResponseEntity<>(roleList, HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
