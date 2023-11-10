package com.cts.outreach.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cts.outreach.model.OutreachEvent;

public interface EventRepository extends MongoRepository<OutreachEvent, String> {
	
	@Query("{isFavoriteEvent : true, createdBy : ?0}")
	public List<OutreachEvent> findAllFavoriteEvents(String createdBy);

}