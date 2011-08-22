package com.dmma.dashboard.core.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.Client;

public class ClientDao  extends BaseDao<Client, Integer>{

	public ClientDao() {
		super(Client.class);
	}
	
	@SuppressWarnings("unchecked")
	public Client findByPhone(String phone) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Client where phone = ?");
			query.setString(0, phone);
			List<Client> list = query.list();
			if(list==null||list.isEmpty()){
				return null;
			}else if(list.size()>1){
				log.error("ClientDao->findByPhone: " + phone + " found more than one result");
				return null;
			}else
				return list.get(0);
		}finally{
			sesion.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> findByStartsWithPhone(String phoneStart) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from Client where phone like ?");
			query.setString(0, phoneStart+"%");
			List<Client> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
}
