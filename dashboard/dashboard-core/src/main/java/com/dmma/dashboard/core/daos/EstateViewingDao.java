package com.dmma.dashboard.core.daos;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.EstateViewing;

public class EstateViewingDao  extends BaseDao<EstateViewing, Integer>{
	
	
	public EstateViewingDao() {
		super(EstateViewing.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<EstateViewing> findByEstateId(Integer estateId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from EstateViewing where estateId = ?");
			query.setInteger(0, estateId);
			List<EstateViewing> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EstateViewing> findByEstateId(Integer estateId,  boolean ifForFuture) {
		Session sesion = sessionFactory.openSession();
		try{
			StringBuffer SQL = new StringBuffer();
			SQL.append("from EstateViewing where estateId = ? ");
			if(ifForFuture)
				SQL.append(" and dateFrom > ? order by dateFrom asc");
			else
				SQL.append(" and dateFrom < ? order by dateFrom desc ");
				
				
			Query query = sesion.createQuery(SQL.toString());
			query.setInteger(0, estateId);
			query.setDate(1, new Date());
			List<EstateViewing> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
	
}
