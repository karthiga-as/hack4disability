package com.cts.outreach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="template")
public class OutreachNotificationTemplate {

	@Id
	private String templateId;

	private String templateName;

	private String templateContent;

	public String getRoleId() {
		return templateId;
	}

	public void setRoleId(String templateId) {
		this.templateId = templateId;
	}

	public String getRoleName() {
		return templateName;
	}

	public void setRoleName(String templateName) {
		this.templateName = templateName;
	}

	public String getRoleDescription() {
		return templateContent;
	}

	public void setRoleDescription(String templateDescription) {
		this.templateContent = templateDescription;
	}

}
