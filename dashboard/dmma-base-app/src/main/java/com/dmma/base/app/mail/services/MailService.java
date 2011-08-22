package com.dmma.base.app.mail.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.mail.daos.MailDao;
import com.dmma.base.app.mail.entities.Mail;
import com.dmma.base.app.services.base.BaseService;

public class MailService implements BaseService<Mail, Integer>{
	private static final Logger log = LoggerFactory.getLogger(MailService.class);
	private MailDao mailDao;
	
	@Override
	public Mail findById(Integer id) {
		log.debug("findById");
		return mailDao.findById(id);
	}
	@Override
	public void saveOrUpdate(Mail entity) {
		log.debug("saveOrUpdate");
		mailDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(Mail entity) {
		log.debug("delete");
		mailDao.delete(entity);
	}
	@Override
	public List<Mail> findAll() {
		log.debug("findAll");
		return mailDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return mailDao.findAllIDs();
	}
	
	
	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}
}
