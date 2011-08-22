package com.dmma.dashboard.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.base.app.services.base.BaseService;
import com.dmma.dashboard.core.daos.ClientDao;
import com.dmma.dashboard.core.entities.Client;

public class ClientService implements BaseService<Client, Integer>{
	private static final Logger log = LoggerFactory.getLogger(ClientService.class);
	private ClientDao clientDao;
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	
	@Override
	public Client findById(Integer id) {
		log.debug("findById");
		return clientDao.findById(id);
	}
	@Override
	public void saveOrUpdate(Client entity) {
		log.debug("saveOrUpdate");
		clientDao.saveOrUpdate(entity);
	}
	@Override
	public void delete(Client entity) {
		log.debug("delete");
		clientDao.delete(entity);
	}
	@Override
	public List<Client> findAll() {
		log.debug("findAll");
		return clientDao.findAll();
	}
	@Override
	public List<Integer> findAllIDs() {
		log.debug("findAllIDs");
		return clientDao.findAllIDs();
	}
	
	public Client findByPhone(String phone){
		log.debug("findByPhone " + phone);
		return clientDao.findByPhone(phone);
	}

	public List<Client> findByStartsWithPhone(String phoneStart) {
		log.debug("findByStartsWithPhone " + phoneStart);
		return clientDao.findByStartsWithPhone(phoneStart);
	}
	
}
