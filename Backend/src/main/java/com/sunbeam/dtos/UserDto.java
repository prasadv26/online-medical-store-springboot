package com.sunbeam.dtos;

import org.springframework.beans.BeanUtils;

import com.sunbeam.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String first_name;
	private String last_name;
	private String email;
	private String role;
	private String password;
	private String phone;
	private String addressLine;
	private String city;
	private String state;
	private String country;
	private String postalCode;

	public static UserDto fromEntity(User user) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user, dto);
		dto.setAddressLine(user.getAddress().getAddressLine());
		dto.setCity(user.getAddress().getCity());
		dto.setState(user.getAddress().getState());
		dto.setCountry(user.getAddress().getCountry());
		dto.setPostalCode(user.getAddress().getPostalCode());
		return dto;
		
	}
}
