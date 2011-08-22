package com.dmma.base.gwt.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.entities.MailDTO;
import com.dmma.base.gwt.shared.entities.MailTemplateDTO;
import com.dmma.base.gwt.shared.wrappers.MailSearchWrapper;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>MailTemplateGWTService</code>.
 */
public interface MailGWTServiceAsync {
	public void findMailById(Integer id, AsyncCallback<MailDTO> callback);
	public void findAllMails(AsyncCallback<ArrayList<MailDTO>> callback);
	public void findAllMails(MailSearchWrapper wrapper,	AsyncCallback<ArrayList<MailDTO>> callback);
	public void saveOrUpdateMail(MailDTO entity, AsyncCallback<Integer> callback);
	
	public void findTemplateById(Integer id, AsyncCallback<MailTemplateDTO> callback);
	public void findTemplateByKey(String name, AsyncCallback<MailTemplateDTO> callback);
	public void findAllTemplates(AsyncCallback<ArrayList<MailTemplateDTO>> callback);
	public void saveOrUpdateTemplate(MailTemplateDTO entity, AsyncCallback<Integer> callback);
	public void findRegisteredTemplateKeys(AsyncCallback<ArrayList<String>> callback);
}
