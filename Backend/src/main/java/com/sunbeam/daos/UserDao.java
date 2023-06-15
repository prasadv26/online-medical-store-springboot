package com.sunbeam.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update User a set password=:password where a.email=:email")
	public void changePassword(@Param("password") String password, @Param("email") String email);

}
