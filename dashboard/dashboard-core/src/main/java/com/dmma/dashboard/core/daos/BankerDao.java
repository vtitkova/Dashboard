package com.dmma.dashboard.core.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.Banker;

public class BankerDao  extends BaseDao<Banker, Integer>{
	
	
	public BankerDao() {
		super(Banker.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public Banker findByExternalId(Long externalId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Banker where externalId = ?");
			query.setLong(0, externalId);
			List<Banker> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("BankerDao->findByExternalId: " + externalId + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Banker findByUserId(Integer userId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Banker where userId = ?");
			query.setInteger(0, userId);
			List<Banker> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("BankerDao->findByUserId: " + userId + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Banker> findByBankOfficeId(Integer bankOfficeId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Banker where bankofficeid = ?");
			query.setInteger(0, bankOfficeId);
			List<Banker> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
	
	
	public List<Banker> findBrokersRecentBankerList(Integer brokerId) {
		//XXX bewanij sql napiwi
		return null;
	}
	
}
