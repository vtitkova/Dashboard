package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.UserDao;
import com.dmma.dashboard.core.entities.User;

public class UserService implements BaseService<User, Integer>{
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private UserDao     userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findById(Integer id) {
		log.debug("findById");
		return userDao.findById(id);
	}
	@Override
	public void saveOrUpdate(User entity) {
		log.debug("saveOrUpdate");
		userDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(User entity) {
		log.debug("delete");
		userDao.delete(entity);
	}
	@Override
	public List<User> findAll() {
		log.debug("findAll");
		return userDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return userDao.findAllIDs();
	}


	public User findByMidasId(Long midasId) {
		log.debug("findByMidasId "+midasId);
		return userDao.findByMidasId(midasId);
	}

	public User findByEmail(String email) {
		log.debug("findByMidasId "+email);
		return userDao.findByEmail(email);
	}

	public User findByEmailOrBrokerMidasId(String username) {
		log.debug("findByEmailOrBrokerMidasId:"+username);
		return userDao.findByEmailOrBrokerMidasId(username);
	}

	public Boolean changePassword(Integer userId, String oldPassword, String newPassword) {
		User user = findById(userId);
		if(user==null){
			log.error("changePassword-> user no found by :"+userId);
			return null;
		} 
		if(user.getPassword().equals(oldPassword)){
			user.setPassword(newPassword);
			saveOrUpdate(user);
			return true;
		}else{
			return false;
		}
	}

	public List<User> findBySearchCreteria(String emailPart, Long midasId, Long externalId, Integer roleType, Integer statusType){
		log.debug("findBySearchCreteria: email="+emailPart+", midasId="+midasId
				+", externalId="+externalId+", roleType="+roleType+", statusType="+statusType);
		return userDao.findBySearchCreteria(emailPart, midasId, externalId, roleType, statusType);
	}
	
	public Long count() {
		return userDao.count();
	}
	
}
