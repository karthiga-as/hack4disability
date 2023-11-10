package com.cts.outreach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.outreach.exceptions.DataNotFoundException;
import com.cts.outreach.model.OutreachBaseLocation;
import com.cts.outreach.model.OutreachBeneficiary;
import com.cts.outreach.model.OutreachCategory;
import com.cts.outreach.model.OutreachCouncil;
import com.cts.outreach.model.OutreachIIEPCategory;
import com.cts.outreach.model.OutreachNotificationTemplate;
import com.cts.outreach.model.OutreachProject;
import com.cts.outreach.model.OutreachRole;
import com.cts.outreach.repository.BaseLocationRepository;
import com.cts.outreach.repository.BeneficiaryRepository;
import com.cts.outreach.repository.CategoryRepository;
import com.cts.outreach.repository.CouncilRepository;
import com.cts.outreach.repository.IIEPCategoryRepository;
import com.cts.outreach.repository.ProjectRepository;
import com.cts.outreach.repository.RoleRepository;
import com.cts.outreach.repository.TemplateRepository;

@Service
public class CodelistServiceImpl implements CodelistService {
	@Autowired
	private BaseLocationRepository baseLocationRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CouncilRepository councilRepository;

	@Autowired
	private IIEPCategoryRepository iiepCategoryRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private TemplateRepository templateRepository;

	@Override
	public List<OutreachBaseLocation> getAllBaseLocations() throws DataNotFoundException {
		List<OutreachBaseLocation> baseLocationList = baseLocationRepository.findAll();
		if (baseLocationList == null) {
			throw new DataNotFoundException("No OutreachBaseLocations available");
		}
		return baseLocationList;
	}

	@Override
	public List<OutreachBeneficiary> getBeneficiaryList() throws DataNotFoundException {
		List<OutreachBeneficiary> beneficiaryList = beneficiaryRepository.findAll();
		if (beneficiaryList == null) {
			throw new DataNotFoundException("No OutreachBeneficiary available");
		}
		return beneficiaryList;
	}

	@Override
	public List<OutreachCategory> getCategoryList() throws DataNotFoundException {
		List<OutreachCategory> categoryList = categoryRepository.findAll();
		if (categoryList == null) {
			throw new DataNotFoundException("No OutreachCategory available");
		}
		return categoryList;
	}

	@Override
	public List<OutreachCouncil> getAllCouncils() throws DataNotFoundException {
		List<OutreachCouncil> councilList = councilRepository.findAll();
		if (councilList == null) {
			throw new DataNotFoundException("No OutreachCouncil available");
		}
		return councilList;
	}

	@Override
	public List<OutreachIIEPCategory> getIIEPCategoryList() throws DataNotFoundException {
		List<OutreachIIEPCategory> iiepCategoryList = iiepCategoryRepository.findAll();
		if (iiepCategoryList == null) {
			throw new DataNotFoundException("No OutreachIIEPCategory available");
		}
		return iiepCategoryList;
	}

	@Override
	public List<OutreachNotificationTemplate> getAllTemplates() throws DataNotFoundException {
		List<OutreachNotificationTemplate> templateList = templateRepository.findAll();
		if (templateList == null) {
			throw new DataNotFoundException("No OutreachNotificationTemplate available");
		}
		return templateList;
	}

	@Override
	public List<OutreachProject> getAllProjects() throws DataNotFoundException {
		List<OutreachProject> projectList = projectRepository.findAll();
		if (projectList == null) {
			throw new DataNotFoundException("No OutreachProject available");
		}
		return projectList;
	}

	@Override
	public List<OutreachRole> getAllRoles() throws DataNotFoundException {
		List<OutreachRole> roleList = roleRepository.findAll();
		if (roleList == null) {
			throw new DataNotFoundException("No OutreachRole available");
		}
		return roleList;
	}

}
