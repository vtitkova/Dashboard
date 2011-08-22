package com.dmma.dashboard.gwt.core.server.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.app.mail.entities.Mail;
import com.dmma.base.app.mail.services.MailProcessor;
import com.dmma.base.app.mail.types.MailSendingMethodType;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.core.entities.User;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;
import com.dmma.dashboard.core.services.UserRoleService;
import com.dmma.dashboard.gwt.core.client.services.UserGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.UserMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;
import com.dmma.dashboard.gwt.core.shared.errors.EmailIsNotUniqueGError;
import com.dmma.dashboard.gwt.core.shared.wrappers.UserSearchWrapper;

/**
 * The server side implementation of the RPC service.
 */
public class UserGWTServiceImpl extends BaseGWTServiceImpl implements UserGWTService {
	private static final long serialVersionUID = 3333153923994886123L;
	private UserRoleService userRoleService;
	private MailProcessor mailProcessor;
	@Override
	protected void initMe(WebApplicationContext context) {
		userRoleService    = context.getBean("userRoleService",   UserRoleService.class);
		mailProcessor = context.getBean("mailProcessor",   MailProcessor.class);
	}


	@Override
	public Boolean changeMyPassword(String oldPassword, String newPassword) {
		
		
		Mail mail = new Mail(); 
		mail.setMailTo("dmitrijs.marcenkovs@gmail.com");
		mail.setSubject("some subject 2");
		mail.setMessage("Hello, this is factory test 2");	
		mailProcessor.sendMail(mail, MailSendingMethodType.isStandartSending);
		
		
		
		return userService.changePassword(getLoggedInBrokerId(), oldPassword, newPassword);
	}


	@Override
	public UserDTO findById(Integer id) throws ObjectNotExistGError {
		User entity = userService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return UserMapper.toDTO(entity);
	}


	@Override
	public ArrayList<UserDTO> findAll() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		List<User> entities = userService.findAll();
		return UserMapper.toDTOs(entities);
	}


	@Override
	public Integer saveOrUpdate(UserDTO entity) throws MethodPermissionGError, EmailIsNotUniqueGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		User user = null; 
		if(entity.getId()!=null)
			user = userService.findById(entity.getId());
		
		if(entity.getId()==null || !entity.getEmail().equals(user.getEmail()))
			checkEmailIsUniqueLogin(entity.getEmail());
		
		user = UserMapper.mapToEntity(entity, user);
		userService.saveOrUpdate(user);
		return user.getId();
	}

	private void checkEmailIsUniqueLogin(String email) throws EmailIsNotUniqueGError {
		if(userService.findByEmail(email)!=null)
			throw new EmailIsNotUniqueGError();
	}

	@Override
	public ArrayList<UserDTO> findByUserSearchWrapper(UserSearchWrapper wrapper) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		
		List<User> entities = userService.findBySearchCreteria(wrapper.getPartOfEmail()
				, wrapper.getMidasId(), wrapper.getExternalId(), wrapper.getRoleTypeId(), wrapper.getStatusTypeId());
		return UserMapper.toDTOs(entities);
	}


	@Override
	public Boolean isUserAdmin(Integer userId) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		if(userService.findById(userId)!=null)
			return userRoleService.isUserAdmin(userId);
		else{
			log.warn("Hey, user "+userId+" is not existing, ABORTING operation");
			return null;
		}
	}


	@Override
	public Boolean setUserIsAdmin(Integer userId, Boolean isAdmin) throws MethodPermissionGError, ObjectNotExistGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		if(userService.findById(userId)!=null)
			return userRoleService.setUserIsAdmin(userId, isAdmin);
		else{
			log.warn("Hey, user "+userId+" is not existing, ABORTING operation");
			throw new ObjectNotExistGError();
		}
	}


	
	
	
}
