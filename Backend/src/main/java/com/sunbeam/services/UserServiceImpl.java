package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public User findById(int id) {
		return dao.getById(id);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public User save(User u) {
		String encPassword = passwordEncoder.encode(u.getPassword());
		u.setPassword(encPassword);
		return dao.save(u);

	}

//	@Override
//	public User authenticate(String email, String password) {
//
//		User admin = findByEmail(email);
//		if (admin.getEmail().equals("admin@gmail.com") && admin.getPassword().equals("admin")) {
//			return admin;
//		}
//
//		User user = findByEmail(email);
//		if (user != null && user.getPassword().equals(password))
//			return user;
//		return null;
//	}
	
	@Override
	public User authenticate(String email, String password) {
	
		User admin = findByEmail(email);
		if (admin.getRole().equals("Admin") &&
				admin.getEmail().equals(email) &&
				passwordEncoder.matches(password, admin.getPassword())) {
				return admin;
		}
		
		User user = findByEmail(email);
		System.out.println(user);

		if (user != null && passwordEncoder.matches(password, user.getPassword()))
			return user;
		return null;


	}
	
	@Override
	public void userPassword(String password,String email) {
	    String encPassword = passwordEncoder.encode(password);
		dao.changePassword(encPassword, email);
	}
	
	
	

	@Override
	public List<User> findAllUser() {
		List<User> userList = dao.findAll();
		return userList;
	}

//	@Override
//	public void userPassword(String password, String email) {
//		dao.changePassword(password, email);
//	}

	@Override
	public User update(int id, User u) {
		User user = findById(id);
		user.setFirst_name(u.getFirst_name());
		user.setLast_name(u.getLast_name());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		user.setPhone(u.getPhone());
		user.setAddress(u.getAddress());
		return dao.save(user);
	}

}
