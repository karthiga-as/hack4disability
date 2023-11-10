package com.cts.outreach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="baselocation")
public class OutreachBaseLocation {

	@Id
	private String baseLocationId;

	private String baseLocationName;

	public String getBaseLocationId() {
		return baseLocationId;
	}

	public void setBaseLocationId(String baseLocationId) {
		this.baseLocationId = baseLocationId;
	}

	public String getBaseLocationName() {
		return baseLocationName;
	}

	public void setBaseLocationName(String baseLocationName) {
		this.baseLocationName = baseLocationName;
	}

}
