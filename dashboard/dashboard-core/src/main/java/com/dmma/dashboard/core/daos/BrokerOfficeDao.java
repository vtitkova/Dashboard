package com.dmma.dashboard.core.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.BrokerOffice;

public class BrokerOfficeDao  extends BaseDao<BrokerOffice, Integer>{
	
	
	public BrokerOfficeDao() {
		super(BrokerOffice.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public BrokerOffice findByMidasId(Long midasId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from BrokerOffice where midasId = ?");
			query.setLong(0, midasId);
			List<BrokerOffice> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("BrokerOfficeDao->findByMidasId: " + midasId + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}
	
}
