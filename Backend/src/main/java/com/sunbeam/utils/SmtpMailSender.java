package com.sunbeam.utils;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SmtpMailSender implements MailSender{
	@Autowired 
	private JavaMailSender javaMailSender;
	
	@PostConstruct
	public void init() {
		System.out.println("SmtpMailSender bean is created.");
	}
	
	@Override
	public void send(String to, String from, String body) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setSubject("Spring Boot");
		helper.setTo(to);
		helper.setText(body, true);
		System.out.println("Sending Smtp Mail...");
		javaMailSender.send(message);	
		System.out.println("Smtp Mail Sent.");
	}
}
