package com.sunbeam.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.common.CustomResponse;
import com.sunbeam.dtos.UserDto;
import com.sunbeam.entities.User;
import com.sunbeam.services.UserService;
import com.sunbeam.utils.MailSender;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private CustomResponse response;
	
	@Autowired
	private MailSender mailSender;
	
	Random random = new Random(1000);

	@PostMapping("/login")
	public CustomResponse login(@RequestParam String email, @RequestParam String password) {
		User user = null;
		try {
			user = service.authenticate(email, password);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("error");
		}
		if (user == null) {
			response.setStatus("error");
			response.setData("");
		} else {
			response.setStatus("success");
			response.setData(user);
		}
		return response;
	}

//	@PostMapping("/addUser")
//	public CustomResponse signup( @RequestBody User user) {
//
//		User user1 = null;
//
//		try {
//			user1 = service.save(user);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			response.setStatus("error");
//		}
//		if (user1 == null) {
//			response.setStatus("error");
//			response.setData("");
//		} else {
//			response.setStatus("success");
//			response.setData(user1);
//		}
//
//		return response;
//	}
	
	@PostMapping("/addUser")
	public CustomResponse signup(@ModelAttribute @RequestBody User us) {
		User user = null;
		try {
			user = service.save(us);
			
			String message = "" + "<div style='border:1px solid #e2e2e2; padding:20px'>" 
			+"Welcome To MedicalStore.com" + " " + user.getFirst_name()
			+ "<h1>"	
			+ "you have suscessfully registered to MedicalStore.com :" 
			+ "<br>" 
			+ "USERNAME = "+ user.getFirst_name()
			+ "Wish you good health and happiness in life.\r\n"
			+ "</n>" 
			+ "<br>"
			+ "Thank You !" 
			+ "</h1> " 
			+ "</div>";
			String to = user.getEmail();
			String from = "";
			
			mailSender.send(to, from, message);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("error");
			response.setData(null);
		}
		response.setStatus("success");
		response.setData(user);
		return response;
	}

	
	
	@GetMapping("/getUser/{id}")
	public CustomResponse getUser(@PathVariable("id") int id) {

		User user = null;
		UserDto userdto = null;
		try {
			user = service.findById(id);
			userdto = UserDto.fromEntity(user);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("error");
		}

		response.setStatus("success");
		response.setData(userdto);
		return response;

	}
	@GetMapping("/inVoiceOrder/{email}")
	public CustomResponse placeOrder(@PathVariable String email) {
		User u = null;
		System.out.println(email);
		try {
			String message = "Order placed Successfully";
			u = service.findByEmail(email);
			String to = u.getEmail();
			String from = "roosharma45@gmail.com";
			mailSender.send(to, from, message);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("error");
			response.setData(null);
		}
		response.setStatus("success");
		response.setData(u);
		return response;
	}

	@GetMapping("/getAllUsers")
	public CustomResponse getAllUsers() {

		List<User> list = new ArrayList<User>();

		try {
			list = service.findAllUser();
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("error");
		}

		response.setStatus("success");
		response.setData(list);
		return response;
	}

	@PutMapping("/updateUser")
	public CustomResponse updateUser(int id, User user) {
		User user1 = null;
		try {
			user1 = service.update(id, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user1 == null) {
			response.setStatus("error");
			response.setData("");
		} else {
			response.setStatus("success");
			response.setData(user1);
		}
		return response;
	}
	
	@PostMapping("/otpVerification")
	public CustomResponse otpVerification(@RequestParam int otp ,HttpSession session) {
		try {
			String email = (String)session.getAttribute("email");
			String password = (String)session.getAttribute("password");
			int ori = (int)session.getAttribute("otp");
			
			System.out.println("the value of user is : "+ori);
			System.out.println(email+"	"+password);
			
			if(ori == otp) {
				service.userPassword(password, email);
				System.out.println("changed successfully");
				response.setStatus("success");
				response.setData("Password Changed Password");
			}else {
				System.out.println("Incorrect Otp!!!");
				response.setStatus("error");
				response.setData("Change Failed to Proceed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	

	@PutMapping("/changePassword")
	public CustomResponse changePassword( @RequestParam String password, @RequestParam String email ,HttpSession session) {
			try {
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				
				int otp = random.nextInt(999999);
				System.out.println("OTP "+otp);
				session.setAttribute("otp", otp);
				
				String from = "roosharma45@gmail.com";
				String body = ""
						+ "<div style='border:1px solid #e2e2e2; padding:20px'>"
						+ "<h1>"
						+ "Online Medical Store"+"<br>"
						+ "Change your Password by entering given OTP"
						+ "</h1> "+"<br>"
						+ "<h1>"
						+ "Your OTP is "
						+ "<b>"+otp
						+ "</n>"
						+ "</h1> "
						+ "</div>";
				mailSender.send(email, from, body);
			} catch (MessagingException e) {
				
				e.printStackTrace();
			}
			
			response.setStatus("success");
			response.setData("Waiting For otp verification");
			
			return response;
	}
	
	
	
//	@PostMapping("/otpVerification")
//	public CustomResponse otpVerification(@RequestParam int otp, HttpSession session) {
//		try {
//			String email = (String)session.getAttribute("email");
//			String password = (String)session.getAttribute("password");
//			int originalOtp = (int)session.getAttribute("otp");
//			
//			System.out.println("user value : "+ originalOtp);
//			System.out.println(email+ " "+ password);
//			
//			if(originalOtp == otp) {
//				service.userPassword(password, email);
//				response.setStatus("success");
//				response.setData("Password changed successfullly");
//			}else {
//				System.out.println("Incorrect otp");
//				response.setStatus("error");
//				response.setData("Something went wrong");
//			}
//			session.setAttribute("email", null);
//			session.setAttribute("password", null);	
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return response;
//	}
	
	
	//otp 
//	@PutMapping("/changePassword")
//	public CustomResponse changePassword(@RequestParam String password, @RequestParam String email, HttpSession session) {
//		session.setAttribute("email", email);
//		session.setAttribute("password", password);
//		
//		int otp = random.nextInt(999999);
//		System.out.println("otp : "+otp);
//		session.setAttribute("otp", otp);
//		
//		response.setStatus("success");
//		response.setData("Waititng for otp verification");
//		
//		return response;
//	}
	

	@PutMapping("/updatepassword")
	public CustomResponse updatepassword(@RequestParam String password, @RequestParam String email) {
		try {
			service.userPassword(password, email);
			System.out.println("changed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setStatus("success");
		response.setData("Password Changed Successfully!!!!!");
		return response;
	}
}
