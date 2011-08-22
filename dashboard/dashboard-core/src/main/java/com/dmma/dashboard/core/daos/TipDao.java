package com.dmma.dashboard.core.daos;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.Tip;
import com.dmma.dashboard.core.types.TipDirectionType;
import com.dmma.dashboard.core.types.TipStatusType;
import com.dmma.dashboard.core.types.TipType;

public class TipDao  extends BaseDao<Tip, Integer>{
	
	
	public TipDao() {
		super(Tip.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Tip> findBySearchCreteria(
			TipDirectionType tipDirectionType,
			TipType          tipType,
			TipStatusType    tipStatusType,
			Integer bankOfficeId,   Integer bankerId,
			Integer brokerOfficeId, Integer brokerId,
			Date dateFrom, Date dateTo) {
		Session sesion = sessionFactory.openSession();
		try{
			StringBuffer SQL = new StringBuffer();
			SQL.append("from Tip where 1=1 ");
			if(tipDirectionType!=null){
				SQL.append(" AND tipDirectionType = ? ");
			}
			if(tipType!=null){
				SQL.append(" AND tipType = ? ");
			}
			if(tipStatusType!=null){
				SQL.append(" AND tipStatusType = ? ");
			}
			if(bankerId!=null){
				SQL.append(" AND bankerid = ? ");
			}else if(bankOfficeId!=null){
				SQL.append(" AND bankerid in (select id from Banker where bankofficeid = ? ) ");
			}
			if(brokerId!=null){
				SQL.append(" AND brokerId = ? ");
			}else if(brokerOfficeId!=null){
				SQL.append(" AND brokerId in (select id from Broker where brokerofficeid = ? ) ");
			}
			if(dateFrom!=null){
				SQL.append(" AND created >= ? ");
			}
			if(dateTo!=null){
				SQL.append(" AND created <= ? ");
			}
			
			
			Query query = sesion.createQuery(SQL.toString());
			int i = 0;
			if(tipDirectionType!=null){
				query.setInteger(i, tipDirectionType.getId());
				i++;
			}
			if(tipType!=null){
				query.setInteger(i, tipType.getId());
				i++;
			}
			if(tipStatusType!=null){
				query.setInteger(i, tipStatusType.getId());
				i++;
			}
			if(bankerId!=null){
				query.setInteger(i, bankerId);
				i++;
			}else if(bankOfficeId!=null){
				query.setInteger(i, bankOfficeId);
				i++;
			}
			if(brokerId!=null){
				query.setInteger(i, brokerId);
				i++;
			}else if(brokerOfficeId!=null){
				query.setInteger(i, brokerOfficeId);
				i++;
			}
			if(dateFrom!=null){
				query.setDate(i, dateFrom);
				i++;
			}
			if(dateTo!=null){
				query.setDate(i, dateTo);
				i++;
			}
			
			List<Tip> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}


	public List<Tip> findTipsTodoForBroker(Integer brokerId) {
		Session sesion = sessionFactory.openSession();
		try{
			StringBuffer SQL = new StringBuffer();
			SQL.append("from Tip where brokerId = ? ");  
			SQL.append("and tipDirectionType = ? ");
			SQL.append("and tipStatusType in ( ? , ? )");
			
			Query query = sesion.createQuery(SQL.toString());
			query.setInteger(0, brokerId);
			query.setInteger(1, TipDirectionType.isBtoM.getId());
			query.setInteger(2, TipStatusType.isNew.getId());
			query.setInteger(3, TipStatusType.isInProcess.getId());
			
			@SuppressWarnings("unchecked")
			List<Tip> list = query.list();
			return list;

		}finally{
			sesion.close();
		}
	}


	public List<Tip> findTipsTodoForBanker(Integer bankerId) {
		Session sesion = sessionFactory.openSession();
		try{
			StringBuffer SQL = new StringBuffer();
			SQL.append("from Tip where bankerId = ? ");  
			SQL.append("and tipDirectionType = ? ");
			SQL.append("and tipStatusType in ( ? , ? )");
			
			Query query = sesion.createQuery(SQL.toString());
			query.setInteger(0, bankerId);
			query.setInteger(1, TipDirectionType.isMtoB.getId());
			query.setInteger(2, TipStatusType.isNew.getId());
			query.setInteger(3, TipStatusType.isInProcess.getId());
			
			@SuppressWarnings("unchecked")
			List<Tip> list = query.list();
			return list;

		}finally{
			sesion.close();
		}
	}
	
}
