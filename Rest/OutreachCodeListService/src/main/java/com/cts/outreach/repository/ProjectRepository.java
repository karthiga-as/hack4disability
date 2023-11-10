package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.outreach.model.OutreachProject;

public interface ProjectRepository extends MongoRepository<OutreachProject, String> {

}