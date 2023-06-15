package com.sunbeam.utils;

import javax.mail.MessagingException;


public interface MailSender {
	public void send(String to, String from, String body) throws MessagingException;
}
