package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.EstateDao;
import com.dmma.dashboard.core.entities.Estate;

public class EstateService implements BaseService<Estate, Integer>{
	private static final Logger log = LoggerFactory.getLogger(EstateService.class);
	private EstateDao          estateDao;
	public void setEstateDao(EstateDao estateDao) {
		this.estateDao = estateDao;
	}
	
	@Override
	public Estate findById(Integer id) {
		log.debug("findById");
		return estateDao.findById(id);
	}
	@Override
	public void saveOrUpdate(Estate entity) {
		log.debug("saveOrUpdate");
		estateDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(Estate entity) {
		log.debug("delete");
		estateDao.delete(entity);
	}
	@Override
	public List<Estate> findAll() {
		log.debug("findAll");
		return estateDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return estateDao.findAllIDs();
	}
	
	// Custom methods from EstateDao
	public Estate findByMidasId(Long midasId) {
		log.debug("findByMidasId "+midasId);
		return estateDao.findByMidasId(midasId);
	}
	public Estate findByFinnCode(Integer finnCode) {
		log.debug("findByFinnCode "+finnCode);
		return estateDao.findByFinnCode(finnCode);
	}
	
	public Estate findByOrderNumber(Integer orderNumber) {
		log.debug("findByOrderNumber "+orderNumber);
		return estateDao.findByOrderNumber(orderNumber);
	}
	
	public List<Estate> findByBrokerId(Integer brokerId) {
		log.debug("findByBrokerId "+brokerId);
		return estateDao.findByBrokerId(brokerId);
	}

	public List<Estate> findBySearchCreteria(Integer statusSearchTypeId, Integer officeId, Integer brokerId) {
		log.info("findBySearchCreteria: statusSearchTypeId="+statusSearchTypeId+", officeId="+officeId
				+", brokerId="+brokerId);
		return estateDao.findBySearchCreteria(statusSearchTypeId, officeId, brokerId);
	}
	
}
