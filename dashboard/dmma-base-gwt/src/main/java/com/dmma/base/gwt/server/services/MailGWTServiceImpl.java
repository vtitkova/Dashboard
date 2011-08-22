package com.dmma.base.gwt.server.services;

import java.util.ArrayList;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.app.mail.entities.Mail;
import com.dmma.base.app.mail.entities.MailTemplate;
import com.dmma.base.app.mail.services.MailService;
import com.dmma.base.app.mail.services.MailTemplateService;
import com.dmma.base.gwt.client.services.MailGWTService;
import com.dmma.base.gwt.server.mappers.MailMapper;
import com.dmma.base.gwt.server.mappers.MailTemplateMapper;
import com.dmma.base.gwt.server.services.base.BaseGWTServiceImpl;
import com.dmma.base.gwt.shared.entities.MailDTO;
import com.dmma.base.gwt.shared.entities.MailTemplateDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.base.gwt.shared.wrappers.MailSearchWrapper;


public class MailGWTServiceImpl extends BaseGWTServiceImpl implements MailGWTService {
	private static final long serialVersionUID = 7516288737599084327L;

	private MailService mailService;
	private MailTemplateService mailTemplateService;
	
	@Override
	protected void initMe(WebApplicationContext context) {
		mailService    = context.getBean("mailService",   MailService.class);
		mailTemplateService = context.getBean("mailTemplateService",   MailTemplateService.class);
	}

	@Override
	public MailDTO findMailById(Integer id) throws ObjectNotExistGError, MethodPermissionGError {
		Mail entity = mailService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return MailMapper.toDTO(entity);
	}

	@Override
	public ArrayList<MailDTO> findAllMails() throws MethodPermissionGError {
		return MailMapper.toDTOs(mailService.findAll());
	}

	@Override
	public ArrayList<MailDTO> findAllMails(MailSearchWrapper wrapper) throws MethodPermissionGError {
		// TODO Auto-generated method stub
		return MailMapper.toDTOs(mailService.findAll());
	}


	@Override
	public Integer saveOrUpdateMail(MailDTO entity)	throws MethodPermissionGError {
		Mail existingMail = null;
		if(entity.getId() != null)
			existingMail = mailService.findById(entity.getId());
		
		existingMail = MailMapper.mapToEntity(entity, existingMail);
		mailService.saveOrUpdate(existingMail);
		return existingMail.getId();
	}

	@Override
	public MailTemplateDTO findTemplateById(Integer id) throws ObjectNotExistGError, MethodPermissionGError {
		MailTemplate entity = mailTemplateService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return MailTemplateMapper.toDTO(entity);
	}

	@Override
	public MailTemplateDTO findTemplateByKey(String name) throws ObjectNotExistGError, MethodPermissionGError {
		MailTemplate entity = mailTemplateService.findByKey(name);
		if(entity==null) throw new ObjectNotExistGError();
		return MailTemplateMapper.toDTO(entity);
	}

	@Override
	public ArrayList<MailTemplateDTO> findAllTemplates() throws MethodPermissionGError {
		return MailTemplateMapper.toDTOs(mailTemplateService.findAll());
	}

	@Override
	public Integer saveOrUpdateTemplate(MailTemplateDTO entity)	throws MethodPermissionGError {
		MailTemplate existingTemplate = null;
		if(entity.getId() != null)
			existingTemplate = mailTemplateService.findById(entity.getId());
		
		existingTemplate = MailTemplateMapper.mapToEntity(entity, existingTemplate);
		mailTemplateService.saveOrUpdate(existingTemplate);
		return existingTemplate.getId();
	}

	@Override
	public ArrayList<String> findRegisteredTemplateKeys() {
		return mailTemplateService.findAllKeys();
	}

	
}