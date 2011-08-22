package com.dmma.base.app.mail.daos;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.base.app.mail.entities.Mail;

public class MailDao  extends BaseDao<Mail, Integer>{
	
	public MailDao() {
		super(Mail.class);
	}
	
	
}
