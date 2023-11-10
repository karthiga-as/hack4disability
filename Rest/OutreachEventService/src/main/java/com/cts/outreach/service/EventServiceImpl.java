package com.cts.outreach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.outreach.exceptions.EventAlreadyExistsException;
import com.cts.outreach.exceptions.EventNotFoundException;
import com.cts.outreach.model.OutreachEvent;
import com.cts.outreach.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	EventRepository eventRepository;

	@Autowired
	public EventServiceImpl(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public OutreachEvent registerEvent(OutreachEvent event) throws EventAlreadyExistsException {
		OutreachEvent obj = eventRepository.insert(event);
		if (obj != null) {
			return obj;
		} else {
			throw new EventAlreadyExistsException("OutreachEvent already exists");
		}
	}

	@Override
	public List<OutreachEvent> registerMultipleEvents(List<OutreachEvent> eventList)
			throws EventAlreadyExistsException {
		List<OutreachEvent> result = eventRepository.insert(eventList);
		if (result == null) {
			throw new EventAlreadyExistsException("OutreachEvents already exists");
		} else if (result.size() != eventList.size()) {
			throw new EventAlreadyExistsException(
					eventList.size() - result.size() + " of the OutreachEvents already exists");
		} else {
			return result;
		}
	}

	@Override
	public OutreachEvent updateEvent(String eventId, OutreachEvent event) throws EventNotFoundException {
		OutreachEvent eventObj = eventRepository.findById(eventId).get();
		if (eventObj != null) {
			eventObj = eventRepository.save(event);
			return event;
		} else {
			throw new EventNotFoundException("OutreachEvent Not Found");
		}
	}

	@Override
	public boolean deleteEvent(String eventId) throws EventNotFoundException {
		OutreachEvent eventObj = eventRepository.findById(eventId).get();
		boolean eventDeleted = false;
		if (eventObj != null) {
			eventRepository.delete(eventObj);
			eventDeleted = true;
		} else {
			throw new EventNotFoundException("OutreachEvent Not Found");
		}
		return eventDeleted;
	}

	@Override
	public OutreachEvent getEventById(String eventId) throws EventNotFoundException {
		OutreachEvent eventObj = eventRepository.findById(eventId).get();
		if (eventObj == null) {
			throw new EventNotFoundException("OutreachEvent Not Found");
		}
		return eventObj;
	}

	@Override
	public List<OutreachEvent> getAllEvents() throws EventNotFoundException {
		List<OutreachEvent> eventlist = eventRepository.findAll();
		if (eventlist == null) {
			throw new EventNotFoundException("No OutreachEvents available");
		}
		return eventlist;
	}

	@Override
	public List<OutreachEvent> getAllFavoriteEvents(String createdBy) throws EventNotFoundException {
		List<OutreachEvent> eventlist = eventRepository.findAllFavoriteEvents(createdBy);
		if (eventlist == null) {
			throw new EventNotFoundException("No OutreachEvents available");
		}
		return eventlist;
	}

}
