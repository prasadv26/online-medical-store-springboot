package com.sunbeam.services;

import com.sunbeam.entities.Address;

public interface AddressService {

	Address addAddress(Address addr);

	boolean deleteAddress(int id);

	Address getAddress(int id);

}
