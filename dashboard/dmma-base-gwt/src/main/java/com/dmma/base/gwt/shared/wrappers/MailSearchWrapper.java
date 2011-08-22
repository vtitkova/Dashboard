package com.dmma.base.gwt.shared.wrappers;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MailSearchWrapper implements IsSerializable{
	private Integer statusId;
	private String  mailTemplateName;
	private Date    dateFrom;
	private Date    dateTo;
	
	public MailSearchWrapper() {
	}

	public Integer getStatusIdId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		if(statusId != null && statusId>0)
			this.statusId = statusId;
		else
			this.statusId = null;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getMailTemplateName() {
		return mailTemplateName;
	}

	public void setMailTemplateName(String mailTemplateName) {
		if(mailTemplateName != null && !"-1".equals(mailTemplateName))
			this.mailTemplateName = mailTemplateName;
		else
			this.mailTemplateName = null;
	}

}
