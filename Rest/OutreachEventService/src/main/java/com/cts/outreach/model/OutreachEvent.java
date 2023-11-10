package com.cts.outreach.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "event")
public class OutreachEvent {

	@Id
	private String eventId;

	private String baseLocation;

	private String beneficiaryName;

	private String councilName;

	private String projectName;

	private String eventCategory;

	private String eventTitle;

	private String eventDescription;

	private String eventDate;

	private String eventStartTime;

	private String eventEndTime;

	private String volunteersHours;

	private String volunteersRequired;

	private String pocId;

	private String transportBoardingType;

	private String transportBoardingPoints;

	private String transportDropPoint;

	private String link;

	private String volunteersSignedupsofar;

	private String status;

	private boolean isFavoriteEvent;

	private String createdBy;

	private String updatedBy;

	private Date createdTimestamp;

	private Date lastUpdateTimestamp;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public String getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public String getVolunteersHours() {
		return volunteersHours;
	}

	public void setVolunteersHours(String volunteersHours) {
		this.volunteersHours = volunteersHours;
	}

	public String getVolunteersRequired() {
		return volunteersRequired;
	}

	public void setVolunteersRequired(String volunteersRequired) {
		this.volunteersRequired = volunteersRequired;
	}

	public String getPocId() {
		return pocId;
	}

	public void setPocId(String pocId) {
		this.pocId = pocId;
	}

	public String getTransportBoardingType() {
		return transportBoardingType;
	}

	public void setTransportBoardingType(String transportBoardingType) {
		this.transportBoardingType = transportBoardingType;
	}

	public String getTransportBoardingPoints() {
		return transportBoardingPoints;
	}

	public void setTransportBoardingPoints(String transportBoardingPoints) {
		this.transportBoardingPoints = transportBoardingPoints;
	}

	public String getTransportDropPoint() {
		return transportDropPoint;
	}

	public void setTransportDropPoint(String transportDropPoint) {
		this.transportDropPoint = transportDropPoint;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getVolunteersSignedupsofar() {
		return volunteersSignedupsofar;
	}

	public void setVolunteersSignedupsofar(String volunteersSignedupsofar) {
		this.volunteersSignedupsofar = volunteersSignedupsofar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean getIsFavoriteEvent() {
		return isFavoriteEvent;
	}

	public void setIsFavoriteEvent(boolean isFavoriteEvent) {
		this.isFavoriteEvent = isFavoriteEvent;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

}
