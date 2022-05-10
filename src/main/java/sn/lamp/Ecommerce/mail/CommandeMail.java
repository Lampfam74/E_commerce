package sn.lamp.Ecommerce.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import sn.lamp.Ecommerce.model.Client;

//@Service
public class CommandeMail {


		@Autowired
		private JavaMailSender mailSender;
		public void sendSimpleMail(Client client,String body,String subject) {
			SimpleMailMessage mes=new SimpleMailMessage();
			mes.setFrom("ClassLamp196@gmail.com");
			mes.setTo(client.getEmail());
			mes.setText(body);
			mes.setSubject(subject);
			System.out.println("bismilah barke mame cheikh ibra fall2");
			mailSender.send(mes);
			System.out.println("bismilah barke mame cheikh ibra fall3");
			
		}
		
		public void sendMailWithAttachement(String toEmail,String body,String subject,String attachement)throws MessagingException {
			MimeMessage mimemessage=mailSender.createMimeMessage();
			MimeMessageHelper messageHelper=new MimeMessageHelper(mimemessage,true);
			messageHelper.setFrom("ClassLamp196@gmail.com");
			messageHelper.setTo(toEmail);
			messageHelper.setText(body);
			messageHelper.setSubject(subject);
			FileSystemResource fileSystemResource=new FileSystemResource(new File(attachement));
			messageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
			mailSender.send(mimemessage);
			System.out.println("bismilah barke mame cheikh ibra fall4");
			
		}

	

	public JavaMailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}


}
