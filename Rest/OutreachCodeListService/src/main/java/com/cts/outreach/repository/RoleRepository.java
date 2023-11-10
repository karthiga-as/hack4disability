package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.outreach.model.OutreachRole;

public interface RoleRepository extends MongoRepository<OutreachRole, String> {

}