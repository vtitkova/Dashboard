package com.dmma.dashboard.gwt.core.client.meta;


import com.dmma.base.gwt.client.ui.gwtentity.column.GwtColumnMetadata;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;

public class BankerCM implements IGwtEntityCM{
	private GwtColumnMetadata idColumn;
	private GwtColumnMetadata userIdColumn;
	private GwtColumnMetadata externalIdColumn;
	private GwtColumnMetadata nameColumn;
	private GwtColumnMetadata surnameColumn;
	private GwtColumnMetadata emailColumn;
	private GwtColumnMetadata phoneColumn;
	private GwtColumnMetadata cellPhoneColumn;
	private GwtColumnMetadata avcoColumn;
	private GwtColumnMetadata brokerOfficeColumn;
	
	
	
	public BankerCM() {
		idColumn        = new GwtColumnMetadata(DashboardMessages.MSG.id()	    , Integer.class ,45);
		userIdColumn    = new GwtColumnMetadata(DashboardMessages.MSG.userId()   , Integer.class ,45);
		externalIdColumn= new GwtColumnMetadata(DashboardMessages.MSG.externalId(), Long.class   ,45);
		nameColumn      = new GwtColumnMetadata(DashboardMessages.MSG.name()     , String.class  ,120);
		surnameColumn   = new GwtColumnMetadata(DashboardMessages.MSG.surname()  , String.class  ,150);
		emailColumn     = new GwtColumnMetadata(DashboardMessages.MSG.email()    , String.class  ,150);
		phoneColumn     = new GwtColumnMetadata(DashboardMessages.MSG.phone()    , String.class  ,80);
		cellPhoneColumn = new GwtColumnMetadata(DashboardMessages.MSG.cellphone(), String.class  ,80);
		avcoColumn      = new GwtColumnMetadata(DashboardMessages.MSG.avco()     , Integer.class ,80);
		brokerOfficeColumn = new GwtColumnMetadata(DashboardMessages.MSG.office(), BrokerOfficeDTO.class  ,140);
		
		externalIdColumn.editable   = true;
		externalIdColumn.required = true;
		
		nameColumn.editable   = true;
		nameColumn.filterable = true;
		nameColumn.required = true;
		
		surnameColumn.editable   = true;
		surnameColumn.filterable = true;

		emailColumn.editable   = true;
		emailColumn.filterable = true;
		emailColumn.required = true;
		
		phoneColumn.editable   = true;
		phoneColumn.filterable = true;
		
		cellPhoneColumn.editable   = true;
		cellPhoneColumn.filterable = true;
		cellPhoneColumn.required = true;
		
		avcoColumn.editable   = true;
		
		brokerOfficeColumn.editable = true;
		brokerOfficeColumn.required = true;
	}
	
	@Override
	public GwtColumnMetadata[] getColumnMeta(){
		return new GwtColumnMetadata[]{ idColumn, userIdColumn,externalIdColumn, nameColumn,surnameColumn,
				emailColumn, phoneColumn, cellPhoneColumn, avcoColumn, brokerOfficeColumn };
	}
	
}
