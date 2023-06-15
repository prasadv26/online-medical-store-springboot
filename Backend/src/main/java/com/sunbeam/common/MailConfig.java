package com.sunbeam.common;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sunbeam.utils.MailSender;
import com.sunbeam.utils.SmtpMailSender;

@Configuration
public class MailConfig {
	
	@ConditionalOnProperty(name="spring.mail.host", havingValue="smtp.gmail.com")
	@Bean
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}
}
