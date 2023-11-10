package com.cts.outreach.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.outreach.model.OutreachBeneficiary;

public interface BeneficiaryRepository extends MongoRepository<OutreachBeneficiary, String> {

}