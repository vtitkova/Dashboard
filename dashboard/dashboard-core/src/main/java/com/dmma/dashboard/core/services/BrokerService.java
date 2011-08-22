package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.BrokerDao;
import com.dmma.dashboard.core.daos.BrokerOfficeDao;
import com.dmma.dashboard.core.daos.UserDao;
import com.dmma.dashboard.core.daos.UserRoleDao;
import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.core.entities.BrokerOffice;
import com.dmma.dashboard.core.entities.User;
import com.dmma.dashboard.core.entities.UserRole;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;

public class BrokerService implements BaseService<Broker, Integer>{
	private static final Logger log = LoggerFactory.getLogger(BrokerService.class);
	private BrokerDao        brokerDao;
	private UserDao          userDao;
	private UserRoleDao      userRoleDao;
	private BrokerOfficeDao  brokerOfficeDao;
	
	public void setBrokerDao(BrokerDao brokerDao) {
		this.brokerDao = brokerDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	public void setBrokerOfficeDao(BrokerOfficeDao brokerOfficeDao) {
		this.brokerOfficeDao = brokerOfficeDao;
	}
	
	@Override
	public Broker findById(Integer id) {
		log.debug("findById");
		return brokerDao.findById(id);
	}
	@Override
	public void saveOrUpdate(Broker entity) {
		log.debug("saveOrUpdate");
		brokerDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(Broker entity) {
		log.debug("delete");
		brokerDao.delete(entity);
	}
	@Override
	public List<Broker> findAll() {
		log.debug("findAll");
		return brokerDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return brokerDao.findAllIDs();
	}
	
	public Broker findByMidasId(Long midasId) {
		log.debug("findByMidasId "+midasId);
		return brokerDao.findByMidasId(midasId);
	}


	public Broker findByUserId(Integer userId) {
		log.debug("findByUserId "+userId);
		return brokerDao.findByUserId(userId);
	}
	
	public List<Broker> findByBrokerOfficeId(Integer brokerOfficeId) {
		log.debug("findByBrokerOfficeId "+brokerOfficeId);
		return brokerDao.findByBrokerOfficeId(brokerOfficeId);
	}

	
	public void processNewRegistration(Broker brokerFromMidas, String password) {
		log.debug("processNewRegistration...");
		
		BrokerOffice brokerOffice = brokerOfficeDao.findByMidasId(brokerFromMidas.getBrokerOffice().getMidasId());
		if(brokerOffice!=null){
			brokerFromMidas.setBrokerOffice(brokerOffice);
		}else{
			brokerOfficeDao.saveOrUpdate(brokerFromMidas.getBrokerOffice());
		}
		
		Long userCount = userDao.count();
		
		User user = new User(); 
		user.setBrokerMidasId(brokerFromMidas.getMidasId());
		user.setBankerExternalId(null);
		user.setEmail(brokerFromMidas.getEmail());
		user.setTitle(brokerFromMidas.getName());
		user.setEnabled(true);
		user.setPassword(password);
		userDao.saveOrUpdate(user);
		
		UserRole userrole = new UserRole();
		userrole.setUserId(user.getId());
		userrole.setRole(MySecurityUserroleType.ROLE_BROKER.name());
		userRoleDao.saveOrUpdate(userrole);
		
		if(userCount == 0){
			UserRole adminRole = new UserRole();
			adminRole.setUserId(user.getId());
			adminRole.setRole(MySecurityUserroleType.ROLE_ADMIN.name());
			userRoleDao.saveOrUpdate(adminRole);
		}
		
		brokerFromMidas.setUserId(user.getId());
		brokerDao.saveOrUpdate(brokerFromMidas);
		log.info("broker saved with id = "+brokerFromMidas.getId());
	
	}
	
	public List<Broker> findBankersRecentBrokerList(Integer bankerId) {
		log.debug("findBankersRecentBrokerList "+bankerId);
		return brokerDao.findBankersRecentBrokerList(bankerId);
	}
	
}
