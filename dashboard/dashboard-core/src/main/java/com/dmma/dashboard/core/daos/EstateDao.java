package com.dmma.dashboard.core.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.Estate;
import com.dmma.dashboard.core.types.EstateStatusType;

public class EstateDao  extends BaseDao<Estate, Integer>{
	
	
	public EstateDao() {
		super(Estate.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public Estate findByMidasId(Long midasId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Estate where midasId = ?");
			query.setLong(0, midasId);
			List<Estate> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("EstateDao->findByMidasId: " + midasId + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Estate findByFinnCode(Integer finnCode) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Estate where finnCode = ?");
			query.setInteger(0, finnCode);
			List<Estate> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("EstateDao->findByFinnCode: " + finnCode + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Estate findByOrderNumber(Integer orderNumber) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Estate where orderNumber = ?");
			query.setInteger(0, orderNumber);
			List<Estate> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("EstateDao->findByOrderNumber: " + orderNumber + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Estate> findByBrokerId(Integer brokerId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Estate where brokerId = ?");
			query.setInteger(0, brokerId);
			List<Estate> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
	
	


	@SuppressWarnings("unchecked")
	public List<Estate> findBySearchCreteria(Integer statusSearchTypeId, Integer officeId, Integer brokerId) {
		Session sesion = sessionFactory.openSession();
		try{
			StringBuffer SQL = new StringBuffer();
			SQL.append("from Estate where 1=1 ");
			
			if(brokerId!=null){
				SQL.append(" AND brokerId = ? ");
			}else if(officeId!=null){
				SQL.append(" AND brokerId in (select id from Broker where brokerofficeid = ? ) ");
			}
			if(statusSearchTypeId!=null){
				if(statusSearchTypeId==2 ){
					SQL.append(" AND status in ("+EstateStatusType.getActiveIDs()+")");
				}
				if(statusSearchTypeId==3){
					SQL.append(" AND status in ("+EstateStatusType.getNotActiveIDs()+")");
				}
			}
			


			
			Query query = sesion.createQuery(SQL.toString());
			int i = 0;
			if(brokerId!=null){
				query.setInteger(i, brokerId);
				i++;
			}else if(officeId!=null){
				query.setInteger(i, officeId);
				i++;
			}
			
			
			List<Estate> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
	
}
