package com.cts.outreach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="beneficiary")
public class OutreachBeneficiary {

	@Id
	private String beneficiaryId;

	private String beneficiaryName;

	private String baseLocationId;

	private String beneficiaryType;

	private BeneficiaryAddress beneficiaryAddress;

	public String getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(String beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBaseLocationId() {
		return baseLocationId;
	}

	public void setBaseLocationId(String baseLocationId) {
		this.baseLocationId = baseLocationId;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public BeneficiaryAddress getBeneficiaryAddress() {
		return beneficiaryAddress;
	}

	public void setBeneficiaryAddress(BeneficiaryAddress beneficiaryAddress) {
		this.beneficiaryAddress = beneficiaryAddress;
	}

}
