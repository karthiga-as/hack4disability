package com.cts.outreach.service;

import java.util.List;

import com.cts.outreach.exceptions.EventAlreadyExistsException;
import com.cts.outreach.exceptions.EventNotFoundException;
import com.cts.outreach.model.OutreachEvent;

public interface EventService {

	OutreachEvent registerEvent(OutreachEvent event) throws EventAlreadyExistsException;

	List<OutreachEvent> registerMultipleEvents(List<OutreachEvent> eventList) throws EventAlreadyExistsException;

	OutreachEvent updateEvent(String eventId, OutreachEvent event) throws EventNotFoundException;

	boolean deleteEvent(String eventId) throws EventNotFoundException;

	OutreachEvent getEventById(String eventId) throws EventNotFoundException;

	List<OutreachEvent> getAllEvents() throws EventNotFoundException;

	List<OutreachEvent> getAllFavoriteEvents(String createdBy) throws EventNotFoundException;

}
