package com.sunbeam.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Company;

public interface CompanyDao extends JpaRepository<Company, Integer> {

	Company findByCompanyName(String name);
	@Transactional
	   @Modifying(clearAutomatically = true)
	   @Query(value = "update company set contact=:contact where company_id=:companyId",
	   nativeQuery = true)
	   public void updateCompany( @Param("companyId") int companyId,@Param("contact") String contact);
}
