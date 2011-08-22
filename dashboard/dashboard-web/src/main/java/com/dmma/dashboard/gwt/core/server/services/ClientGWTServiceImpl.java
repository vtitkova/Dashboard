package com.dmma.dashboard.gwt.core.server.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.core.entities.Client;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;
import com.dmma.dashboard.core.services.ClientService;
import com.dmma.dashboard.gwt.core.client.services.ClientGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.ClientMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisPhoneGError;

/**
 * The server side implementation of the RPC service.
 */
public class ClientGWTServiceImpl extends BaseGWTServiceImpl implements ClientGWTService {
	private static final long serialVersionUID = -7075650418182512549L;
	private ClientService clientService;
	
	
	@Override
	protected void initMe(WebApplicationContext context) {
		clientService    = context.getBean("clientService",   ClientService.class);
	}

	
	@Override
	public ClientDTO findById(Integer id) throws ObjectNotExistGError {
		Client entity = clientService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return ClientMapper.toDTO(entity);
	}

	@Override
	public Integer saveOrUpdate(ClientDTO entity) throws SomeoneElseHaveThisPhoneGError {
		Client client = null; 
		if(entity.getId()!=null)
			client = clientService.findById(entity.getId());
		
		if(entity.getId()==null || !entity.getPhone().equals(client.getPhone()))
			checkIfSomeoneElseHaveThisPhone(entity.getPhone());
		
		client = ClientMapper.mapToEntity(entity, client);
		clientService.saveOrUpdate(client);
		return client.getId();
	}

	
	private void checkIfSomeoneElseHaveThisPhone(String phone) throws SomeoneElseHaveThisPhoneGError {
		Client existing = clientService.findByPhone(phone);
		if(existing!=null)
			throw new SomeoneElseHaveThisPhoneGError();
	}
	
	
	@Override
	public ArrayList<ClientDTO> findAll() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		List<Client> entities = clientService.findAll();
		return ClientMapper.toDTOs(entities);
	}

	@Override
	public ArrayList<Integer> findAllIDs() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		List<Integer> list = clientService.findAllIDs();
		if(list==null) return null;
		ArrayList<Integer> retVal = new ArrayList<Integer>(list.size());
		retVal.addAll(list);
		return retVal;
	}

	@Override
	public ClientDTO findByPhone(String phone) {
		Client entity = clientService.findByPhone(phone);
		return ClientMapper.toDTO(entity);
	}

	@Override
	public ArrayList<ClientDTO> findByStartsWithPhone(String phoneStart) {
		List<Client> entities  = clientService.findByStartsWithPhone(phoneStart);
		return ClientMapper.toDTOs(entities);
	}


	@Override
	public ArrayList<ListBoxDTO> findAllShort() {
		List<Client> clientsFromDB = clientService.findAll();
		if(clientsFromDB == null) return null;
		ArrayList<ListBoxDTO> retVal = new ArrayList<ListBoxDTO>(clientsFromDB.size());
		for(Client oneClient : clientsFromDB){
			ListBoxDTO dto = new ListBoxDTO();
			dto.setId(oneClient.getId());
			dto.setName(oneClient.getName());
			retVal.add(dto);
		}
		return retVal;
	}

}
