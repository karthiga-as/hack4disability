package com.cts.outreach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="project")
public class OutreachProject {

	@Id
	private String projectId;

	private String projectName;

	private String councilId;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCouncilId() {
		return councilId;
	}

	public void setCouncilId(String councilId) {
		this.councilId = councilId;
	}

}
