package com.cts.outreach.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cts.outreach.exceptions.EventAlreadyExistsException;
import com.cts.outreach.exceptions.EventNotFoundException;
import com.cts.outreach.model.OutreachEvent;
import com.cts.outreach.service.EventService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping(value = "/api/eventService")
public class EventController {

	EventService eventService;

	@Autowired
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@ApiOperation(value = "Get all Events", response = Iterable.class)
	@GetMapping("/getEventList")
	public ResponseEntity<?> getAllEvents() throws EventNotFoundException {
		List<OutreachEvent> eventlist;
		try {
			eventlist = eventService.getAllEvents();
			return new ResponseEntity<>(eventlist, HttpStatus.OK);
		} catch (EventNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Register Event")
	@PostMapping("/saveEvent")
	public ResponseEntity<?> registerEvent(@RequestBody OutreachEvent event) throws EventAlreadyExistsException {
		OutreachEvent eventObj;
		try {
			eventObj = eventService.registerEvent(event);
			return new ResponseEntity<>(eventObj, HttpStatus.CREATED);
		} catch (EventAlreadyExistsException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@ApiOperation(value = "Register Multiple Events")
	@PostMapping("/saveEventList")
	public ResponseEntity<?> registerMultipleEvents(@RequestParam("file") MultipartFile multipartFile)
			throws EventAlreadyExistsException {
		System.out.println("Entered !!!");
		try {
			List<OutreachEvent> eventList = getEventListFromFile(multipartFile);
			List<OutreachEvent> eventObjList;
			eventObjList = eventService.registerMultipleEvents(eventList);
			return new ResponseEntity<>(eventObjList.size(), HttpStatus.CREATED);
		} catch (EventAlreadyExistsException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	private List<OutreachEvent> getEventListFromFile(MultipartFile multipartFile) throws Exception {
		System.out.println("In getEventListFromFile method");
		List<OutreachEvent> eventList = new ArrayList<>();
		if (multipartFile != null) {
			File file = new File(multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
				FileInputStream excelFile = new FileInputStream(file);
				Workbook workbook = new XSSFWorkbook(excelFile);
				Sheet worksheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = worksheet.iterator();

				while (rowIterator.hasNext()) {
					Row currentRow = rowIterator.next();
					System.out.println(currentRow.getCell(0).getStringCellValue());
				}
			} catch (IllegalStateException | IOException e1) {
				throw new Exception();
			} 
		}
		return eventList;
	}

	@ApiOperation(value = "Update OutreachEvent")
	@PutMapping("/updateEvent/{id}")
	public ResponseEntity<?> updateEvent(@RequestBody OutreachEvent event, @PathVariable("id") String eventId)
			throws Exception {
		try {
			OutreachEvent eventObj = eventService.updateEvent(eventId, event);
			return new ResponseEntity<>(eventObj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Delete OutreachEvent")
	@DeleteMapping("/deleteEvent/{id}")
	public ResponseEntity<?> deleteEvent(@PathVariable("id") String eventId) throws EventNotFoundException {
		try {
			boolean status = eventService.deleteEvent(eventId);
			return new ResponseEntity<>(status, HttpStatus.OK);
		} catch (EventNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Get OutreachEvent Details")
	@GetMapping("/getEvent/{id}")
	public ResponseEntity<?> fetchEventDetails(@PathVariable String id) throws EventNotFoundException {
		try {
			OutreachEvent eventInfo = eventService.getEventById(id);
			return new ResponseEntity<>(eventInfo, HttpStatus.OK);
		} catch (EventNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Get all Favorite Events", response = Iterable.class)
	@GetMapping("/getFavoriteEventList/{createdBy}")
	public ResponseEntity<?> getAllFavoriteEvents(@PathVariable String createdBy) throws EventNotFoundException {
		System.out.println("***********IN**************");
		System.out.println("*************************" + createdBy);
		List<OutreachEvent> eventlist;
		try {
			eventlist = eventService.getAllFavoriteEvents(createdBy);
			return new ResponseEntity<>(eventlist, HttpStatus.OK);
		} catch (EventNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
