package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.UserRoleDao;
import com.dmma.dashboard.core.entities.UserRole;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;

public class UserRoleService implements BaseService<UserRole, Integer>{
	private static final Logger log = LoggerFactory.getLogger(UserRoleService.class);

	private UserRoleDao userRoleDao;
	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	@Override
	public UserRole findById(Integer id) {
		log.debug("findById "+id);
		return userRoleDao.findById(id);
	}
	@Override
	public void saveOrUpdate(UserRole entity) {
		log.debug("saveOrUpdate");
		userRoleDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(UserRole entity) {
		log.debug("delete");
		userRoleDao.delete(entity);
	}
	@Override
	public List<UserRole> findAll() {
		log.debug("findAll");
		return userRoleDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return userRoleDao.findAllIDs();
	}
	
	public List<UserRole> findByUserId(Integer userId) {
		log.debug("findByUserId:"+userId);
		return userRoleDao.findByUserId(userId);
	}
	
	public Boolean isUserAdmin(Integer userId) {
		log.debug("isUserAdmin:"+userId);
		List<UserRole> userRoles = findByUserId(userId);
		if(userRoles==null || userRoles.isEmpty()) return false;
		for(UserRole role :userRoles){
			if(MySecurityUserroleType.ROLE_ADMIN.name().equals(role.getRole())){
				return true;
			}
		}
		return false;
	}

	public Boolean setUserIsAdmin(Integer userId, Boolean isAdmin) {
		log.debug("setUserIsAdmin: userId="+userId+", isAdmin="+isAdmin);
		List<UserRole> userRoles = findByUserId(userId);
		if(isAdmin){
			//Lets make him admin
			for(UserRole role :userRoles){
				if(MySecurityUserroleType.ROLE_ADMIN.name().equals(role.getRole())){
					return true;
				}
			}
			UserRole myNewRole = new UserRole();
			myNewRole.setRole(MySecurityUserroleType.ROLE_ADMIN.name());
			myNewRole.setUserId(userId);
			saveOrUpdate(myNewRole);
			return true;
		}else{
			//Lets make him NOT admin
			for(UserRole role :userRoles){
				if(MySecurityUserroleType.ROLE_ADMIN.name().equals(role.getRole())){
					delete(role);
					return true;
				}
			}
			return true;
		}
	}
	
}
