package com.dmma.base.app.mail.runnable;

import javax.mail.MessagingException;

import com.dmma.base.app.mail.SendMailUsingAuthentication;
import com.dmma.base.app.mail.callback.MailSendingCallback;
import com.dmma.base.app.mail.config.MailServerConfigurator;
import com.dmma.base.app.mail.entities.Mail;



public class SendMailRunnable implements Runnable{
	private Mail mail;
	private MailServerConfigurator mailServerConfigurator;
	private MailSendingCallback callback;

	public SendMailRunnable(Mail mail, MailServerConfigurator mailServerConfigurator, MailSendingCallback callback) {
		this.mail = mail;
		this.mailServerConfigurator = mailServerConfigurator;
		this.callback = callback;
	}


	@Override
	public void run() {
		if(!mailServerConfigurator.sendMails()) {
			if(callback!=null){
				callback.onMailSent(mail, false, "mail sending is disabled. see system configuration");
			}
			return;
		}
		SendMailUsingAuthentication sender = new SendMailUsingAuthentication();
		try {
			sender.postMail(mail, mailServerConfigurator.getHostName()
					, mailServerConfigurator.getHostPort(), mailServerConfigurator.getHostUser()
					, mailServerConfigurator.getHostPwd());
			if(callback!=null){
				callback.onMailSent(mail, true, null);
			}
		} catch (MessagingException e) {
			e.printStackTrace();
			if(callback!=null){
				callback.onMailSent(mail, false, e.getMessage());
			}
		}
		
	}




}
