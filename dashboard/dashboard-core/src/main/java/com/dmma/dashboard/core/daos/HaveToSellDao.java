package com.dmma.dashboard.core.daos;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.configuration.AppProperties;
import com.dmma.dashboard.core.entities.HaveToSell;

public class HaveToSellDao  extends BaseDao<HaveToSell, Integer>{

	public HaveToSellDao() {
		super(HaveToSell.class);	

	}

	@SuppressWarnings("unchecked")
	public List<HaveToSell> findHTSToBeProcessedForBroker(Integer brokerId) {
		Session sesion = sessionFactory.openSession();
		try{
			StringBuffer SQL = new StringBuffer()
			.append(" from HaveToSell ")
			.append(" WHERE processedDate is null ")
			.append(" AND defaultbrokerid = ? ")
			.append(" AND activeFrom < ? ");

			Query query = sesion.createQuery(SQL.toString());
			query.setInteger(0, brokerId);
			query.setTimestamp(1, new Date());

			List<HaveToSell> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<HaveToSell> findHTSToBeProcessedForPartnersOfBroker(Integer brokerId, Integer brokerOfficeId) {
		Session sesion = sessionFactory.openSession();
		try{
			StringBuffer SQL = new StringBuffer();
			SQL
			.append(" from HaveToSell ")
			.append(" WHERE processedDate is null ")
			.append(" AND activeFrom < ? ")
			.append(" AND defaultbrokerid in ( select id from Broker where brokerofficeid = ? ) ")
			.append(" and defaultbrokerid <> ? ");
			Query query = sesion.createQuery(SQL.toString());
			
			Long time  = (new Date()).getTime() - (AppProperties.htsAvailableForPartnersAfterDays*24*60*60*1000);
			query.setTimestamp( 0, new Date(time));
			query.setInteger( 1, brokerOfficeId);
			query.setInteger( 2, brokerId);
			
			List<HaveToSell> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}

	public List<HaveToSell> findByClientId(Integer clientId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from HaveToSell where clientid = ? ");
			query.setInteger(0, clientId);
			@SuppressWarnings("unchecked")
			List<HaveToSell> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
	
	public List<HaveToSell> findHtsByCreteria(Integer bId, Integer status,Integer wts, Date dFrom, Date dTo){
		Session sesion = sessionFactory.openSession();
		try{
			StringBuilder sb = new StringBuilder("from HaveToSell where 1=1 ");
			//all "-1"
			//processed "1"
			//toBeDone "2"
			if(status == 1){    
				sb.append("AND processedbyid = ? ");
			}else if(status == 2){   
				sb.append("AND defaultbrokerid = ? and processedDate is null ");
			}else{
				sb.append("AND ( ");
				sb.append("( processedbyid = ?)");
				sb.append(" or ");
				sb.append("( defaultbrokerid = ? and processedDate is null)");
				sb.append(" ) ");
			}
			
			//all "-1"
			//yes "1"
			//no  "2"
			if(wts == 1 || wts == 2 ){
				sb.append("AND  wantsToSell = ? ");
			}
			
			if(dFrom!=null){
				sb.append(" AND activeFrom >= ? ");
			}
			if(dTo!=null){
				sb.append(" AND activeFrom <= ? ");
			}
			
			Query query = sesion.createQuery(sb.toString());
			int i = 0;
			if(status == 1){    
				query.setInteger(i, bId);
				i++;
			}else if(status == 2){   
				query.setInteger(i, bId);
				i++;
			}else{
				query.setInteger(i, bId);
				i++;
				query.setInteger(i, bId);
				i++;
			}
			
			if(wts == 1 || wts == 2){
				query.setBoolean(i, wts==1);
				i++;
			}
			if(dFrom!=null){
				query.setDate(i, dFrom);
				i++;
			}
			if(dTo!=null){
				query.setDate(i, dTo);
				i++;
			}
			
			
			@SuppressWarnings("unchecked")
			List<HaveToSell> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}


	
}
