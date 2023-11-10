package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.outreach.model.OutreachBaseLocation;

public interface BaseLocationRepository extends MongoRepository<OutreachBaseLocation, String> {

}