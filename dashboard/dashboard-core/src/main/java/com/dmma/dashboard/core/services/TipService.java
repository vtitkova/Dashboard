package com.dmma.dashboard.core.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.TipDao;
import com.dmma.dashboard.core.entities.Tip;
import com.dmma.dashboard.core.types.TipDirectionType;
import com.dmma.dashboard.core.types.TipStatusType;
import com.dmma.dashboard.core.types.TipType;

public class TipService implements BaseService<Tip, Integer>{
	private static final Logger log = LoggerFactory.getLogger(TipService.class);
	private TipDao tipDao;
	
	public void setTipDao(TipDao tipDao) {
		this.tipDao = tipDao;
	}
	
	@Override
	public Tip findById(Integer id) {
		log.debug("findById");
		return tipDao.findById(id);
	}
	@Override
	public void saveOrUpdate(Tip entity) {
		log.debug("saveOrUpdate");
		tipDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(Tip entity) {
		log.debug("delete");
		tipDao.delete(entity);
	}
	@Override
	public List<Tip> findAll() {
		log.debug("findAll");
		return tipDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return tipDao.findAllIDs();
	}
	
	// Custom methods from EstateDao
	public List<Tip> findBySearchCreteria(
			TipDirectionType tipDirectionType,
			TipType          tipType,
			TipStatusType    tipStatusType,
			Integer bankOfficeId,   Integer bankerId,
			Integer brokerOfficeId, Integer brokerId,
			Date dateFrom, Date dateTo){
		StringBuilder logString = new StringBuilder("findBySearchCreteria: tipDirectionType=");
		logString.append(tipDirectionType==null?"null":tipDirectionType.getId().toString());
		logString.append(" tipType=");
		logString.append(tipType==null?"null":tipType.getId().toString());
		logString.append(" tipStatusType=");
		logString.append(tipStatusType==null?"null":tipStatusType.getId().toString());
		

		log.info(logString.toString());
		return tipDao.findBySearchCreteria(tipDirectionType, tipType, tipStatusType, bankOfficeId, bankerId,
				brokerOfficeId, brokerId,
				dateFrom, dateTo );
	}

	public List<Tip> findTipsTodoForBroker(Integer brokerId) {
		log.debug("findTipsTodoForBroker : " + brokerId  );
		return tipDao.findTipsTodoForBroker(brokerId);
	}

	public List<Tip> findTipsTodoForBanker(Integer bankerId) {
		log.debug("findTipsTodoForBanker : " + bankerId  );
		return tipDao.findTipsTodoForBanker(bankerId);
	}
	
}
