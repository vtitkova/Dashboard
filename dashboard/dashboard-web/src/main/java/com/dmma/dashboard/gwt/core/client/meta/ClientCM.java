package com.dmma.dashboard.gwt.core.client.meta;


import com.dmma.base.gwt.client.ui.gwtentity.column.GwtColumnMetadata;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;

public class ClientCM implements IGwtEntityCM{
	private GwtColumnMetadata idColumn;
	private GwtColumnMetadata nameColumn;
	private GwtColumnMetadata surnameColumn;
	private GwtColumnMetadata emailColumn;
	private GwtColumnMetadata phoneColumn;
	private GwtColumnMetadata commentsColumn;
	
	
	
	public ClientCM() {
		idColumn       = new GwtColumnMetadata(DashboardMessages.MSG.id()	  , Integer.class ,50);
		nameColumn     = new GwtColumnMetadata(DashboardMessages.MSG.name()    , String.class  ,150);
		surnameColumn  = new GwtColumnMetadata(DashboardMessages.MSG.surname() , String.class  ,200);
		emailColumn    = new GwtColumnMetadata(DashboardMessages.MSG.email()   , String.class  ,180);
		phoneColumn    = new GwtColumnMetadata(DashboardMessages.MSG.phone()   , String.class  ,90);
		commentsColumn = new GwtColumnMetadata(DashboardMessages.MSG.comments(), String.class  ,200);
		
		nameColumn.editable   = true;
		nameColumn.filterable = true;
		nameColumn.required   = true;
		
		surnameColumn.editable   = true;
		surnameColumn.filterable = true;

		emailColumn.editable   = true;
		emailColumn.filterable = true;
		emailColumn.required   = true;
		
		phoneColumn.editable   = true;
		phoneColumn.filterable = true;
		phoneColumn.required   = true;
		
		commentsColumn.editable   = true;
		commentsColumn.filterable = true;
	}
	
	@Override
	public GwtColumnMetadata[] getColumnMeta(){
		return new GwtColumnMetadata[]{ idColumn, nameColumn,surnameColumn,emailColumn, phoneColumn, commentsColumn };
	}
	
}
