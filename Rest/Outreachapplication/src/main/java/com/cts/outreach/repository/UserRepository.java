package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.outreach.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}