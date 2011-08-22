package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.ClientVisitDao;
import com.dmma.dashboard.core.entities.ClientVisit;
import com.dmma.dashboard.core.entities.report.UnfinalyzedViewing;

public class ClientVisitService implements BaseService<ClientVisit, Integer>{
	private static final Logger log = LoggerFactory.getLogger(ClientVisitService.class);
	private ClientVisitDao     clientVisitDao;
	public void setClientVisitDao(ClientVisitDao clientVisitDao) {
		this.clientVisitDao = clientVisitDao;
	}

	@Override
	public ClientVisit findById(Integer id) {
		log.debug("findById");
		return clientVisitDao.findById(id);
	}
	@Override
	public void saveOrUpdate(ClientVisit entity) {
		log.debug("saveOrUpdate");
		clientVisitDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(ClientVisit entity) {
		log.debug("delete");
		clientVisitDao.delete(entity);
	}
	@Override
	public List<ClientVisit> findAll() {
		log.debug("findAll");
		return clientVisitDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return clientVisitDao.findAllIDs();
	}


	public List<ClientVisit> findByEstateViewingId(Integer estateViewingId) {
		log.debug("findByEstateViewingId "+estateViewingId);
		return clientVisitDao.findByEstateViewingId(estateViewingId);
	}
	public List<ClientVisit> findByEstateId(Integer estateId) {
		log.debug("findByEstateId "+estateId);
		return clientVisitDao.findByEstateId(estateId);
	}

	public List<UnfinalyzedViewing> findUnfinalyzedViewings(Integer brokerId) {
		log.debug("findUnfinalyzedViewings "+brokerId);
		return clientVisitDao.findUnfinalyzedViewings(brokerId);
	}
	
}
