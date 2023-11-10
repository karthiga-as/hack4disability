package com.cts.outreach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="iiepcategory")
public class OutreachIIEPCategory {

	@Id
	private String iiepCategoryId;

	private String iiepCategoryName;

	public String getIiepCategoryId() {
		return iiepCategoryId;
	}

	public void setIiepCategoryId(String iiepCategoryId) {
		this.iiepCategoryId = iiepCategoryId;
	}

	public String getIiepCategoryName() {
		return iiepCategoryName;
	}

	public void setIiepCategoryName(String iiepCategoryName) {
		this.iiepCategoryName = iiepCategoryName;
	}

}
