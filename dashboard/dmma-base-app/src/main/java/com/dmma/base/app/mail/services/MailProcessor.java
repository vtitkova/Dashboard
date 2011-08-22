package com.dmma.base.app.mail.services;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.mail.callback.MailSendingCallback;
import com.dmma.base.app.mail.config.MailServerConfigurator;
import com.dmma.base.app.mail.entities.Mail;
import com.dmma.base.app.mail.runnable.SendMailRunnable;
import com.dmma.base.app.mail.types.MailSendingMethodType;
import com.dmma.base.app.mail.types.MailStatusType;

public class MailProcessor {
	private static final Logger log = LoggerFactory.getLogger(MailProcessor.class);
	private MailService mailService;
	private MailServerConfigurator mailServerConfigurator;
	
	
	
	
	public Boolean sendMail(Mail mail, MailSendingMethodType sendingType) {
		if(mail.getMailFrom() == null || mail.getMailFrom().length() == 0)
			mail.setMailFrom(mailServerConfigurator.getHostUser());
		
		if(mailServerConfigurator.redirectAllTo() != null && mailServerConfigurator.redirectAllTo().length() == 0){
			String originalDestination = "<br>This mail was redirected, original email address was : "+ mail.getMailTo();
			mail.setMailTo(mailServerConfigurator.redirectAllTo());
			mail.setMessage(mail.getMessage() + originalDestination);
		}
		
		
		mail.setCreated(new Date());
		mail.setStatus(MailStatusType.isNew.getId());
		
		
		
		if(MailSendingMethodType.isStandartSending.equals(sendingType)){
			log.info("performing standart mail sending");
			mailService.saveOrUpdate(mail);

		}else if(MailSendingMethodType.isSendInstantly.equals(sendingType)){
			log.info("performing instant mail sending - sending performed in separate thread with logging to DB");
			SendMailRunnable runable = new SendMailRunnable(mail, mailServerConfigurator, new MailSendingCallback() {
				@Override
				public void onMailSent(Mail mail, boolean isSuccess, String errorDescription) {
					if(isSuccess){
						mail.setStatus(MailStatusType.isSent.getId());
						mail.setSent(new Date());
					}else{
						mail.setStatus(MailStatusType.isFailed.getId());
						mail.setSent(new Date());
						
					}
					mailService.saveOrUpdate(mail);
				}
			} );
			Thread t = new Thread(runable);
			t.start();
			return true;
		
		}else if(MailSendingMethodType.isSendInstantlyNoLog.equals(sendingType)){
			log.info("performing instant mail sending with out logging - sending performed in separate thread, no log to DB ");
			SendMailRunnable runable = new SendMailRunnable(mail, mailServerConfigurator, null);
			Thread t = new Thread(runable);
			t.start();
			return true;
		}
		return null;
	}


	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}


	public void setMailServerConfigurator(MailServerConfigurator mailServerConfigurator) {
		this.mailServerConfigurator = mailServerConfigurator;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
