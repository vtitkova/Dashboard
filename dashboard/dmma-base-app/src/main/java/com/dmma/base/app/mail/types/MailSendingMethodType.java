package com.dmma.base.app.mail.types;



public enum MailSendingMethodType {
	isStandartSending,    // make entry in the DB
	isSendInstantly,	  // sending performed in separate thread with logging to DB
	isSendInstantlyNoLog; // sending performed in separate thread, no log to DB 	
	
}
