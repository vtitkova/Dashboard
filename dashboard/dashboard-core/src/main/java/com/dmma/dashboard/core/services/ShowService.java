package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.EstateViewingDao;
import com.dmma.dashboard.core.entities.EstateViewing;

public class ShowService implements BaseService<EstateViewing, Integer>{
	private static final Logger log = LoggerFactory.getLogger(ShowService.class);
	private EstateViewingDao showDao;
	
	@Override
	public EstateViewing findById(Integer id) {
		log.debug("findById");
		return showDao.findById(id);
	}
	@Override
	public void saveOrUpdate(EstateViewing entity) {
		log.debug("saveOrUpdate");
		showDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(EstateViewing entity) {
		log.debug("delete");
		showDao.delete(entity);
	}
	@Override
	public List<EstateViewing> findAll() {
		log.debug("findAll");
		return showDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return showDao.findAllIDs();
	}
	
	
	
	public void setShowDao(EstateViewingDao showDao) {
		this.showDao = showDao;
	}

	public List<EstateViewing> findByMidasId(Integer estateId) {
		log.debug("findByMidasId "+estateId);
		return showDao.findByEstateId(estateId);
	}

	
}
