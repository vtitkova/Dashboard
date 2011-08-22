package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.EstateViewingDao;
import com.dmma.dashboard.core.entities.EstateViewing;

public class EstateViewingService implements BaseService<EstateViewing, Integer>{
	private static final Logger log = LoggerFactory.getLogger(EstateViewingService.class);
	private EstateViewingDao     estateViewingDao;
	public void setEstateViewingDao(EstateViewingDao estateViewingDao) {
		this.estateViewingDao = estateViewingDao;
	}
	@Override
	public EstateViewing findById(Integer id) {
		log.debug("findById");
		return estateViewingDao.findById(id);
	}
	@Override
	public void saveOrUpdate(EstateViewing entity) {
		log.debug("saveOrUpdate");
		estateViewingDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(EstateViewing entity) {
		log.debug("delete");
		estateViewingDao.delete(entity);
	}
	@Override
	public List<EstateViewing> findAll() {
		log.debug("findAll");
		return estateViewingDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return estateViewingDao.findAllIDs();
	}
	
	// Custom methods from EstateDao
	public List<EstateViewing> findByEstateId(Integer estateId) {
		log.debug("findByEstateId "+estateId);
		return estateViewingDao.findByEstateId(estateId);
	}
	
	public List<EstateViewing> findByEstateId(Integer estateId, boolean ifForFuture) {
		log.debug("findByEstateId "+estateId + " " + ifForFuture);
		return estateViewingDao.findByEstateId(estateId, ifForFuture);
	}
}
