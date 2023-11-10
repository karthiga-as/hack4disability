package com.cts.outreach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="council")
public class OutreachCouncil {

	@Id
	private String councilId;

	private String councilName;

	private String baseLocationId;

	public String getCouncilId() {
		return councilId;
	}

	public void setCouncilId(String councilId) {
		this.councilId = councilId;
	}

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	public String getBaseLocationId() {
		return baseLocationId;
	}

	public void setBaseLocationId(String baseLocationId) {
		this.baseLocationId = baseLocationId;
	}

}
