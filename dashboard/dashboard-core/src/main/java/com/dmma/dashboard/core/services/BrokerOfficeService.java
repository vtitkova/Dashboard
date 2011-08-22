package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.BrokerOfficeDao;
import com.dmma.dashboard.core.entities.BrokerOffice;

public class BrokerOfficeService implements BaseService<BrokerOffice, Integer>{
	private static final Logger log = LoggerFactory.getLogger(BrokerOfficeService.class);
	private BrokerOfficeDao brokerOfficeDao;
	public void setBrokerOfficeDao(BrokerOfficeDao officeDao) {
		this.brokerOfficeDao = officeDao;
	}
	
	@Override
	public BrokerOffice findById(Integer id) {
		log.debug("findById");
		return brokerOfficeDao.findById(id);
	}
	@Override
	public void saveOrUpdate(BrokerOffice entity) {
		log.debug("saveOrUpdate");
		brokerOfficeDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(BrokerOffice entity) {
		log.debug("delete");
		brokerOfficeDao.delete(entity);
	}
	@Override
	public List<BrokerOffice> findAll() {
		log.debug("findAll");
		return brokerOfficeDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return brokerOfficeDao.findAllIDs();
	}

	public BrokerOffice findByMidasId(Long midasId) {
		log.debug("findByMidasId "+midasId);
		return brokerOfficeDao.findByMidasId(midasId);
	}

	
}
