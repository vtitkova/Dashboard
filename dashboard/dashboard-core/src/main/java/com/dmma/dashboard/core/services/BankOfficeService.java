package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.BankOfficeDao;
import com.dmma.dashboard.core.entities.BankOffice;

public class BankOfficeService implements BaseService<BankOffice, Integer>{
	private static final Logger log = LoggerFactory.getLogger(BankOfficeService.class);
	private BankOfficeDao bankOfficeDao;
	public void setBankOfficeDao(BankOfficeDao bankOfficeDao) {
		this.bankOfficeDao = bankOfficeDao;
	}
	
	@Override
	public BankOffice findById(Integer id) {
		log.debug("findById");
		return bankOfficeDao.findById(id);
	}
	@Override
	public void saveOrUpdate(BankOffice entity) {
		log.debug("saveOrUpdate");
		bankOfficeDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(BankOffice entity) {
		log.debug("delete");
		bankOfficeDao.delete(entity);
	}
	@Override
	public List<BankOffice> findAll() {
		log.debug("findAll");
		return bankOfficeDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return bankOfficeDao.findAllIDs();
	}

	public BankOffice findByExternalId(Long externalId) {
		log.debug("findByExternalId "+externalId);
		return bankOfficeDao.findByExternalId(externalId);
	}

	
}
