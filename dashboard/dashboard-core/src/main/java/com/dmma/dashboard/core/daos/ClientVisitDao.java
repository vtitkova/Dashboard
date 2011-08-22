package com.dmma.dashboard.core.daos;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.ClientVisit;
import com.dmma.dashboard.core.entities.report.UnfinalyzedViewing;
import com.dmma.dashboard.core.types.ClientVisitStatusType;

public class ClientVisitDao  extends BaseDao<ClientVisit, Integer>{
	public ClientVisitDao() {
		super(ClientVisit.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<ClientVisit> findByEstateViewingId(Integer estateViewingId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from ClientVisit where estateViewingId = ?");
			query.setInteger(0, estateViewingId);
			List<ClientVisit> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ClientVisit> findByEstateId(Integer estateId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from ClientVisit where estateId = ?");
			query.setInteger(0, estateId);
			List<ClientVisit> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}

	public List<UnfinalyzedViewing> findUnfinalyzedViewings(Integer brokerId) {
		Session sesion = sessionFactory.openSession();
		try{
			
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT c.estateViewingId estateViewingId, count(c.id) unknownStatusAmount ");
			sb.append(" FROM clientvisit c, estateViewing v, estate e ");
			sb.append(" where v.id = c.estateViewingId ");
			sb.append(" AND e.id = v.estateId ");
			sb.append(" AND e.brokerId = ? ");
			sb.append(" AND c.status = ? ");
			sb.append(" AND v.dateFrom < ? ");
			sb.append(" group by c.estateViewingId ");
			
			Query query = sesion.createSQLQuery(sb.toString())
			.addScalar("estateViewingId",       Hibernate.INTEGER)
			.addScalar("unknownStatusAmount",   Hibernate.INTEGER)
			.setResultTransformer(Transformers.aliasToBean(UnfinalyzedViewing.class));
			query.setInteger(0, brokerId);
			query.setInteger(1, ClientVisitStatusType.isPlaningToGo.getId());
			query.setDate(2, new Date());
			@SuppressWarnings("unchecked")
			List<UnfinalyzedViewing> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
}
