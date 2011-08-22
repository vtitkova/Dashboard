package com.dmma.dashboard.core.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.UserRole;

public class UserRoleDao  extends BaseDao<UserRole, Integer>{
	public UserRoleDao() {
		super(UserRole.class);
	}

	@SuppressWarnings("unchecked")
	public List<UserRole> findByUserId(Integer userId) {
		Session sesion = sessionFactory.openSession();
		try{
			Query query = sesion.createQuery("from UserRole where userId = ?");
			query.setInteger(0, userId);
			List<UserRole> list = query.list();
			return list;
		}finally{
			sesion.close();
		}
	}
		
}
