package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.outreach.model.OutreachCategory;

public interface CategoryRepository extends MongoRepository<OutreachCategory, String> {

}