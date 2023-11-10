package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.outreach.model.OutreachCouncil;

public interface CouncilRepository extends MongoRepository<OutreachCouncil, String> {

}