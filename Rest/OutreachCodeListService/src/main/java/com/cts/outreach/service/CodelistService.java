package com.cts.outreach.service;

import java.util.List;

import com.cts.outreach.exceptions.DataNotFoundException;
import com.cts.outreach.model.OutreachBaseLocation;
import com.cts.outreach.model.OutreachBeneficiary;
import com.cts.outreach.model.OutreachCategory;
import com.cts.outreach.model.OutreachCouncil;
import com.cts.outreach.model.OutreachIIEPCategory;
import com.cts.outreach.model.OutreachNotificationTemplate;
import com.cts.outreach.model.OutreachProject;
import com.cts.outreach.model.OutreachRole;

public interface CodelistService {

	List<OutreachBaseLocation> getAllBaseLocations() throws DataNotFoundException;

	List<OutreachBeneficiary> getBeneficiaryList() throws DataNotFoundException;

	List<OutreachCategory> getCategoryList() throws DataNotFoundException;

	List<OutreachCouncil> getAllCouncils() throws DataNotFoundException;

	List<OutreachIIEPCategory> getIIEPCategoryList() throws DataNotFoundException;

	List<OutreachNotificationTemplate> getAllTemplates() throws DataNotFoundException;

	List<OutreachProject> getAllProjects() throws DataNotFoundException;

	List<OutreachRole> getAllRoles() throws DataNotFoundException;

}
