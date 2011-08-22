package com.dmma.base.gwt.client.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

public interface BaseMessages extends Constants{
	public static final BaseMessages  MSG = (BaseMessages)     GWT.create(BaseMessages.class);
	
	public String appPingerError();
	
	public String id();
	public String nr();
	
	public String na();
	public String notFound();
	public String select();
	public String all();
	
	public String from();
	public String to();
	public String find(); 
	public String today(); 
	public String thisMonth(); 
	public String lastMonth(); 
	
	public String warning();
	public String error();
	public String info();
	public String confirmation();
	
	public String methodPermissionGError();
	public String objectPermissionGError();
	public String objectNotExistGError(); 
	public String applicationError();
	
	public String yes();  
	public String add();
	public String edit();
	public String pdf();
	public String no();
	public String cancel();
	public String ok();     
	public String close();
	public String save();
	public String pickUp();
	public String saveAndPickUp();
	public String createNew();	
	
	//ChangePasswordWidget
	public String changePasswordTile();
	public String currentPassword();
	public String newPassword();    
	public String repeatPasswors(); 
	public String update();
	public String currentPasswordIsEmptyError();
	public String newPasswordIsNotEqualError();
	public String passwordUpdateSwccessfully();
	public String passwordUpdateFailed();
	public String requiredFieldsError(); 
	public String saveOperationFailed(); // operation failed  
	public String saveOperationSuccessed();
	public String requestingData();
	public String dataNotFound();
	
	public String loading();
	public String clientContext();

	public String menuMails();
	public String created();
	public String mailStatusIsNew();
	public String mailStatusIsSent();
	public String mailStatusIsFailed();
	public String mailTemplate();
	public String mailStatus();
	
	public String menuMailTemplates();



	
}
