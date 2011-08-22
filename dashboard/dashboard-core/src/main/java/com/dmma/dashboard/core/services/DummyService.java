package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.DummyDao;
import com.dmma.dashboard.core.entities.Dummy;

public class DummyService implements BaseService<Dummy, Integer>{
	private static final Logger log = LoggerFactory.getLogger(DummyService.class);
	private DummyDao dummyDao;
	
	@Override
	public Dummy findById(Integer id) {
		log.debug("findById");
		return dummyDao.findById(id);
	}
	@Override
	public void saveOrUpdate(Dummy entity) {
		log.debug("saveOrUpdate");
		dummyDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(Dummy entity) {
		log.debug("delete");
		dummyDao.delete(entity);
	}
	@Override
	public List<Dummy> findAll() {
		log.debug("findAll");
		return dummyDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return dummyDao.findAllIDs();
	}
	
	public void setDummyDao(DummyDao dummyDao) {
		this.dummyDao = dummyDao;
	}
}
