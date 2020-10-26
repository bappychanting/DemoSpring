package com.bappy.npspring5tutorial.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	/*
	 * @Value("${spring.mail.host:}") private String host;
	 * 
	 * @Value("${spring.mail.username:}") private String username;
	 * 
	 * @Value("${spring.mail.password:}") private String password;
	 */

	@Bean
	// @Profile("dev")
	@ConditionalOnProperty(name="spring.mail.host", havingValue="foo",
	matchIfMissing=true)
	public MailSender mockMailSender(){
		return new MockMailSender();
	}
	
	@Bean
	@ConditionalOnProperty("spring.mail.host") 
	public MailSender smtpMailSender(JavaMailSender javaMailSender) { 
		return new SmtpMailSender(javaMailSender); 
	}
	
	/*
	 * @Bean // @Profile("!dev")
	 * 
	 * @ConditionalOnProperty("spring.mail.host") public MailSender smtpMailSender()
	 * { SmtpMailSender mailSender = new SmtpMailSender();
	 * mailSender.setJavaMailSender(javaMailSender()); return mailSender; }
	 * 
	 * @Bean public JavaMailSender javaMailSender() { JavaMailSenderImpl sender =
	 * new JavaMailSenderImpl();
	 * 
	 * sender.setHost(host); sender.setSession(getMailSession());
	 * 
	 * return sender; }
	 * 
	 * private Session getMailSession() { Properties props = new Properties();
	 * 
	 * props.put("mail.smtp.auth", true); props.put("mail.smtp.socketFactory.port",
	 * 465); props.put("mail.smtp.socketFactory.class",
	 * "javax.net.ssl.SSLSocketFactory");
	 * props.put("mail.smtp.socketFactory.fallback", false);
	 * 
	 * return Session.getInstance(props, getAuthenticator()); }
	 * 
	 * private Authenticator getAuthenticator() { SmtpAuthenticator authenticator =
	 * new SmtpAuthenticator(); authenticator.setUsername(username);
	 * authenticator.setPassword(password); return authenticator; }
	 */
}
