package com.cts.outreach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.outreach.exceptions.VolunteerAlreadyExistsException;
import com.cts.outreach.exceptions.VolunteerNotFoundException;
import com.cts.outreach.model.OutreachVolunteer;
import com.cts.outreach.service.VolunteerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping(value = "/api/volunteerService")
public class VolunteerController {

	private VolunteerService volunteerService;

	@Autowired
	public VolunteerController(VolunteerService volunteerService) {
		this.volunteerService = volunteerService;
	}

	@ApiOperation(value = "Get all Volunteers", response = Iterable.class)
	@GetMapping("/getVolunteerList")
	public ResponseEntity<?> getAllVolunteers() throws VolunteerNotFoundException {
		List<OutreachVolunteer> volunteerlist;
		try {
			volunteerlist = volunteerService.getAllVolunteers();
			return new ResponseEntity<>(volunteerlist, HttpStatus.OK);
		} catch (VolunteerNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Register Volunteer")
	@PostMapping("/saveVolunteer")
	public ResponseEntity<?> registerVolunteer(@RequestBody OutreachVolunteer volunteer) throws VolunteerAlreadyExistsException {
		OutreachVolunteer volunteerObj;
		try {
			volunteerObj = volunteerService.registerVolunteer(volunteer);
			return new ResponseEntity<>(volunteerObj, HttpStatus.CREATED);
		} catch (VolunteerAlreadyExistsException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@ApiOperation(value = "Register Multiple Volunteers")
	@PostMapping("/saveVolunteerList")
	public ResponseEntity<?> registerMultipleVolunteers(@RequestBody List<OutreachVolunteer> volunteerList)
			throws VolunteerAlreadyExistsException {
		List<OutreachVolunteer> volunteerObjList;
		try {
			volunteerObjList = volunteerService.registerMultipleVolunteers(volunteerList);
			return new ResponseEntity<>(volunteerObjList.size(), HttpStatus.CREATED);
		} catch (VolunteerAlreadyExistsException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@ApiOperation(value = "Update OutreachVolunteer")
	@PutMapping("/updateVolunteer/{id}")
	public ResponseEntity<?> updateVolunteer(@RequestBody OutreachVolunteer volunteer, @PathVariable("id") String volunteerId)
			throws Exception {
		try {
			OutreachVolunteer volunteerObj = volunteerService.updateVolunteer(volunteerId, volunteer);
			return new ResponseEntity<>(volunteerObj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Delete OutreachVolunteer")
	@DeleteMapping("/deleteVolunteer/{id}")
	public ResponseEntity<?> deleteVolunteer(@PathVariable("id") String volunteerId) throws VolunteerNotFoundException {
		try {
			boolean status = volunteerService.deleteVolunteer(volunteerId);
			return new ResponseEntity<>(status, HttpStatus.OK);
		} catch (VolunteerNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Get OutreachVolunteer Details")
	@GetMapping("/getVolunteer/{id}")
	public ResponseEntity<?> fetchVolunteerDetails(@PathVariable String id) throws VolunteerNotFoundException {
		try {
			OutreachVolunteer volunteerInfo = volunteerService.getVolunteerById(id);
			return new ResponseEntity<>(volunteerInfo, HttpStatus.OK);
		} catch (VolunteerNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
