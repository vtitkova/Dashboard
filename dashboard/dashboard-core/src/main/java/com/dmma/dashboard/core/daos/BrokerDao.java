package com.dmma.dashboard.core.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.Broker;

public class BrokerDao  extends BaseDao<Broker, Integer>{
	
	
	public BrokerDao() {
		super(Broker.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public Broker findByMidasId(Long midasId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Broker where midasId = ?");
			query.setLong(0, midasId);
			List<Broker> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("BrokerDao->findByMidasId: " + midasId + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Broker findByUserId(Integer userId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Broker where userId = ?");
			query.setInteger(0, userId);
			List<Broker> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("BrokerDao->findByUserId: " + userId + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Broker> findByBrokerOfficeId(Integer brokerOfficeId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Broker where brokerofficeid = ?");
			query.setInteger(0, brokerOfficeId);
			List<Broker> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
	
	public List<Broker> findBankersRecentBrokerList(Integer bankerId) {
		//XXX bewanij sql napiwi
		return null;
	}
	
}
