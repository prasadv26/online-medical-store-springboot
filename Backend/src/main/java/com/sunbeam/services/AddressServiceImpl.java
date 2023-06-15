package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AddressDao;
import com.sunbeam.entities.Address;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao dao;

	@Override
	public Address addAddress(Address addr) {
		return dao.save(addr);
	}

	@Override
	public boolean deleteAddress(int id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Address getAddress(int id) {
		return dao.getById(id);
	}

}
