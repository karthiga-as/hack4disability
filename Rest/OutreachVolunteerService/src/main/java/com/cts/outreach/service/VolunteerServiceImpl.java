package com.cts.outreach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.outreach.exceptions.VolunteerAlreadyExistsException;
import com.cts.outreach.exceptions.VolunteerNotFoundException;
import com.cts.outreach.model.OutreachVolunteer;
import com.cts.outreach.repository.VolunteerRepository;

@Service
public class VolunteerServiceImpl implements VolunteerService {

	private VolunteerRepository volunteerRepository;

	@Autowired
	public VolunteerServiceImpl(VolunteerRepository volunteerRepository) {
		this.volunteerRepository = volunteerRepository;
	}

	@Override
	public OutreachVolunteer registerVolunteer(OutreachVolunteer volunteer) throws VolunteerAlreadyExistsException {
		OutreachVolunteer obj = volunteerRepository.insert(volunteer);
		if (obj != null) {
			return obj;
		} else {
			throw new VolunteerAlreadyExistsException("OutreachVolunteer already exists");
		}
	}

	@Override
	public List<OutreachVolunteer> registerMultipleVolunteers(List<OutreachVolunteer> volunteerList)
			throws VolunteerAlreadyExistsException {
		List<OutreachVolunteer> result = volunteerRepository.insert(volunteerList);
		if (result == null) {
			throw new VolunteerAlreadyExistsException("OutreachVolunteers already exists");
		} else if (result.size() != volunteerList.size()) {
			throw new VolunteerAlreadyExistsException(
					volunteerList.size() - result.size() + " of the OutreachVolunteers already exists");
		} else {
			return result;
		}
	}

	@Override
	public OutreachVolunteer updateVolunteer(String volunteerId, OutreachVolunteer volunteer) throws VolunteerNotFoundException {
		OutreachVolunteer volunteerObj = volunteerRepository.findById(volunteerId).get();
		if (volunteerObj != null) {
			volunteerObj = volunteerRepository.save(volunteer);
			return volunteer;
		} else {
			throw new VolunteerNotFoundException("OutreachVolunteer Not Found");
		}
	}

	@Override
	public boolean deleteVolunteer(String volunteerId) throws VolunteerNotFoundException {
		OutreachVolunteer volunteerObj = volunteerRepository.findById(volunteerId).get();
		boolean volunteerDeleted = false;
		if (volunteerObj != null) {
			volunteerRepository.delete(volunteerObj);
			volunteerDeleted = true;
		} else {
			throw new VolunteerNotFoundException("OutreachVolunteer Not Found");
		}
		return volunteerDeleted;
	}

	@Override
	public OutreachVolunteer getVolunteerById(String volunteerId) throws VolunteerNotFoundException {
		OutreachVolunteer volunteerObj = volunteerRepository.findById(volunteerId).get();
		if (volunteerObj == null) {
			throw new VolunteerNotFoundException("OutreachVolunteer Not Found");
		}
		return volunteerObj;
	}

	@Override
	public List<OutreachVolunteer> getAllVolunteers() throws VolunteerNotFoundException {
		List<OutreachVolunteer> volunteerList = volunteerRepository.findAll();
		if (volunteerList == null) {
			throw new VolunteerNotFoundException("No OutreachVolunteers available");
		}
		return volunteerList;
	}

}
