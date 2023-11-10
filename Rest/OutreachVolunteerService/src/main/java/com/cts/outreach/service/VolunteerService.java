package com.cts.outreach.service;

import java.util.List;

import com.cts.outreach.exceptions.VolunteerAlreadyExistsException;
import com.cts.outreach.exceptions.VolunteerNotFoundException;
import com.cts.outreach.model.OutreachVolunteer;

public interface VolunteerService {

	OutreachVolunteer registerVolunteer(OutreachVolunteer volunteer) throws VolunteerAlreadyExistsException;

	List<OutreachVolunteer> registerMultipleVolunteers(List<OutreachVolunteer> volunteerList) throws VolunteerAlreadyExistsException;

	OutreachVolunteer updateVolunteer(String volunteerId, OutreachVolunteer volunteer) throws VolunteerNotFoundException;

	boolean deleteVolunteer(String volunteerId) throws VolunteerNotFoundException;

	OutreachVolunteer getVolunteerById(String volunteerId) throws VolunteerNotFoundException;

	List<OutreachVolunteer> getAllVolunteers() throws VolunteerNotFoundException;

}
