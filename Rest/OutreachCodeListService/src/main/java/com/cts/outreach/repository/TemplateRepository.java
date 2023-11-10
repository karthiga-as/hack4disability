package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.outreach.model.OutreachNotificationTemplate;

public interface TemplateRepository extends MongoRepository<OutreachNotificationTemplate, String> {

}