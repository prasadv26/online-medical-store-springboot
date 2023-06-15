package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.CompanyDao;
import com.sunbeam.entities.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao dao;

	@Override
	public Company findById(int id) {
		return dao.getById(id);
	}

	@Override
	public Company findByCompanyName(String name) {
		return dao.findByCompanyName(name);
	}

	@Override
	public Company addCompany(Company company) {
		return dao.save(company);
	}

	@Override
	public Boolean deleteCompany(int id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Company> getAllCompany() {
		return dao.findAll();
	}
	@Override
	public void updateCompany(int companyId, String contact) {
		dao.updateCompany(companyId,contact);
		
	}
}
