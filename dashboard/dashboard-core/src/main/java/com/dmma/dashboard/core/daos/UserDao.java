package com.dmma.dashboard.core.daos;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.User;

public class UserDao  extends BaseDao<User, Integer>{
	
	public UserDao() {
		super(User.class);
	}
		
	@SuppressWarnings("unchecked")
	public User findByMidasId(Long midasId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from User where brokerMidasId = ?");
			query.setLong(0, midasId);
			List<User> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("UserDao->findByMidasId: " + midasId + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public User findByEmail(String email) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from User where email = ?");
			query.setString(0, email);
			List<User> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("UserDao->findByEmail: " + email + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}

	public User findByEmailOrBrokerMidasId(String usernLoginString) {
		Long midasId = null;
		try{
			midasId = new Long(usernLoginString);
		}catch (NumberFormatException e) {
			// it's ok .. that could be an email 
			log.debug("findByEmailOrBrokerMidasId:"+usernLoginString+" Is not a number, that could be an email, no error ");
		}
		if(midasId!=null){
			return findByMidasId(midasId);
		}else{
			return findByEmail(usernLoginString);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findBySearchCreteria(String emailPart, Long midasId, Long externalId, Integer roleType, Integer statusType){
		Session sesion = sessionFactory.openSession();
		try{
			StringBuffer SQL = new StringBuffer();
			SQL.append("from User where 1=1 ");
			
			if(emailPart!=null&&emailPart.length()>0){
				SQL.append(" AND email like ? ");
			}
			if(midasId!=null){
				SQL.append(" AND brokerMidasId = ? ");
			}
			if(externalId!=null){
				SQL.append(" AND bankerExternalId = ? ");
			}
			if(statusType!=null&&statusType>1&&statusType<4){
				SQL.append(" AND enabled = ? ");
			}
			if(roleType!=null&&roleType>1&&roleType<5){
				SQL.append(" AND id in (select userId from UserRole where role = ? ) ");
			}
			


			
			Query query = sesion.createQuery(SQL.toString());
			int i = 0;
			if(emailPart!=null&&emailPart.length()>0){
				query.setString(i, "%"+emailPart+"%");
				i++;
			}
			if(midasId!=null){
				query.setLong(i, midasId);
				i++;
			}
			if(externalId!=null){
				query.setLong(i, externalId);
				i++;
			}
			if(statusType!=null&&statusType>1&&statusType<4){
				query.setBoolean(i, statusType==2);
				i++;
			}
			if(roleType!=null&&roleType>1&&roleType<5){
				if(roleType==2)
					query.setString(i, "ROLE_BROKER");
				else if(roleType==3)
					query.setString(i, "ROLE_BANKER");
				else 
					query.setString(i, "ROLE_ADMIN");
				i++;
			}
			
			List<User> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}

	public Long count() {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createSQLQuery("select count(*) from user");
			BigInteger result = (BigInteger) query.uniqueResult();
			return result==null?null:result.longValue();
		}finally{
			sesion.close();
		}
	}
	
	
}
