package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.outreach.model.OutreachIIEPCategory;

public interface IIEPCategoryRepository extends MongoRepository<OutreachIIEPCategory, String> {

}