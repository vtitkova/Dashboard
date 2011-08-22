package com.dmma.dashboard.core.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.BankOffice;

public class BankOfficeDao  extends BaseDao<BankOffice, Integer>{
	
	
	public BankOfficeDao() {
		super(BankOffice.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public BankOffice findByExternalId(Long externalId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from BankOffice where externalId = ?");
			query.setLong(0, externalId);
			List<BankOffice> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("BankOfficeDao->findByExternalId: " + externalId + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}
	
}
