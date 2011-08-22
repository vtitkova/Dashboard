package com.dmma.dashboard.core.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.configuration.AppProperties;
import com.dmma.dashboard.core.daos.HaveToSellDao;
import com.dmma.dashboard.core.entities.HaveToSell;

public class HaveToSellService implements BaseService<HaveToSell, Integer>{
	
	private static final Logger log = LoggerFactory.getLogger(HaveToSellService.class);
	private HaveToSellDao haveToSellDao;

	
	@Override
	public HaveToSell findById(Integer id) {
		log.debug("findById");
		return haveToSellDao.findById(id);
	}
	@Override
	public void saveOrUpdate(HaveToSell entity) {
		log.debug("saveOrUpdate");
		haveToSellDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(HaveToSell entity) {
		log.debug("delete");
		haveToSellDao.delete(entity);
	}
	@Override
	public List<HaveToSell> findAll() {
		log.debug("findAll");
		return haveToSellDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return haveToSellDao.findAllIDs();
	}
	
	public void setHaveToSellDao(HaveToSellDao haveToSellDao) {
		this.haveToSellDao = haveToSellDao;
	}
	
	public List<HaveToSell> findHTSToBeProcessedForBroker(Integer brokerId) {
		log.debug("findHTSToBeProcessedForBroker:"+brokerId);
		return haveToSellDao.findHTSToBeProcessedForBroker(brokerId);
	}
	
	public List<HaveToSell> findHTSToBeProcessedForPartnersOfBroker(Integer brokerId, Integer brokerOfficeId) {
		log.debug("findHTSToBeProcessedForBroker:"+brokerId);
		return haveToSellDao.findHTSToBeProcessedForPartnersOfBroker(brokerId, brokerOfficeId);
	}
	
	
	public List<HaveToSell> findByClientId(Integer clientId) {
		log.debug("findByClientId:"+clientId);
		return haveToSellDao.findByClientId(clientId);
	}
	
	public Boolean doWeNeedToCreateHTS(Integer clientId){
		List<HaveToSell> htss = findByClientId(clientId);
		if(htss==null || htss.isEmpty()) return true ;
		Date maxDate = null;
		for(HaveToSell hts : htss){
			if(hts.getProcessedDate()==null) return false;
			if(maxDate == null || hts.getProcessedDate().after(maxDate))
				maxDate = hts.getProcessedDate();
		}
		Long time  = (new Date()).getTime() - (AppProperties.htsExpiryAfterDays*24*60*60*1000);
		Date when = new Date(time);
		if(maxDate.before(when))
			return true;
		else 
			return false;
		
	}
	
	public List<HaveToSell> findHtsByCreteria(Integer bId, Integer status,Integer wts, Date dFrom, Date dTo){
		return haveToSellDao.findHtsByCreteria(bId, status, wts, dFrom, dTo);
	}
}
	
	
