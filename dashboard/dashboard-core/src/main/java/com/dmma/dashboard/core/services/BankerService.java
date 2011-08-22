package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.BankerDao;
import com.dmma.dashboard.core.entities.Banker;

public class BankerService implements BaseService<Banker, Integer>{
	private static final Logger log = LoggerFactory.getLogger(BankerService.class);
	private BankerDao   bankerDao;
	public void setBankerDao(BankerDao bankerDao) {
		this.bankerDao = bankerDao;
	}
		
	@Override
	public Banker findById(Integer id) {
		log.debug("findById");
		return bankerDao.findById(id);
	}
	@Override
	public void saveOrUpdate(Banker entity) {
		log.debug("saveOrUpdate");
		bankerDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(Banker entity) {
		log.debug("delete");
		bankerDao.delete(entity);
	}
	@Override
	public List<Banker> findAll() {
		log.debug("findAll");
		return bankerDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return bankerDao.findAllIDs();
	}
	
	public Banker findByExternalId(Long externalId) {
		log.debug("findByMidasId " + externalId);
		return bankerDao.findByExternalId(externalId);
	}

	public Banker findByUserId(Integer userId) {
		log.debug("findByUserId " + userId);
		return bankerDao.findByUserId(userId);
	}
	
	public List<Banker> findByBankOfficeId(Integer bankOfficeId) {
		log.debug("findByBankOfficeId "+bankOfficeId);
		return bankerDao.findByBankOfficeId(bankOfficeId);
	}

	public List<Banker> findBrokersRecentBankerList(Integer brokerId) {
		log.debug("findBrokersRecentBankerList "+brokerId);
		return bankerDao.findBrokersRecentBankerList(brokerId);
	}

}
