package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.User;

public interface UserService {
	
	User findById(int id);
	User findByEmail(String email);
	//User findByAdmin(String email);
	User save(User u);
	User authenticate(String email,String password);
	void userPassword(String password, String email);
    List<User> findAllUser();
    User update(int id,User u);
}

//insert into medicine value(4,24,5,"2021-11-02",'',,"2022-12-6",700,20);