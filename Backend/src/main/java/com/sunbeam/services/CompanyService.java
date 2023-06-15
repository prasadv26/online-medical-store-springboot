package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Company;

public interface CompanyService {
	
	Company findById(int id);
	Company findByCompanyName(String name);
	Company addCompany(Company company);
	Boolean deleteCompany(int id);
	List<Company> getAllCompany();
	public void updateCompany(int companyId, String contact);
}
