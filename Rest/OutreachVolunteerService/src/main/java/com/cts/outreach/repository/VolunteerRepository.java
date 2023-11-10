package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cts.outreach.model.OutreachVolunteer;

public interface VolunteerRepository extends MongoRepository<OutreachVolunteer, String> {

}