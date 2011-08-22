package com.dmma.dashboard.gwt.core.client.meta;


import com.dmma.base.gwt.client.ui.gwtentity.column.GwtColumnMetadata;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;

public class BrokerOfficeCM implements IGwtEntityCM{
	private GwtColumnMetadata idColumn;
	private GwtColumnMetadata midasIdColumn;
	private GwtColumnMetadata nameColumn;
	private GwtColumnMetadata addressColumn;
	private GwtColumnMetadata zipColumn;
	private GwtColumnMetadata cityColumn;
	private GwtColumnMetadata phoneColumn;
	private GwtColumnMetadata emailColumn;
	
	public BrokerOfficeCM() {
		idColumn       = new GwtColumnMetadata(DashboardMessages.MSG.id()	  , Integer.class ,50);
		midasIdColumn  = new GwtColumnMetadata(DashboardMessages.MSG.midasId() , Long.class    ,60);
		nameColumn     = new GwtColumnMetadata(DashboardMessages.MSG.name()    , String.class  ,150);
		addressColumn  = new GwtColumnMetadata(DashboardMessages.MSG.address() , String.class  ,200);
		zipColumn      = new GwtColumnMetadata(DashboardMessages.MSG.zip()     , String.class  ,80);
		cityColumn     = new GwtColumnMetadata(DashboardMessages.MSG.city()    , String.class  ,80);
		phoneColumn    = new GwtColumnMetadata(DashboardMessages.MSG.phone()   , String.class  ,90);
		emailColumn    = new GwtColumnMetadata(DashboardMessages.MSG.email()   , String.class  ,180);
		
		
		midasIdColumn.editable   = true;
		midasIdColumn.required   = true;
		
		nameColumn.editable   = true;
		nameColumn.filterable = true;
		nameColumn.required   = true;

		addressColumn.editable   = true;
		addressColumn.filterable = true;
		addressColumn.required   = true;

		zipColumn.editable   = true;
		zipColumn.filterable = true;
		zipColumn.required   = true;
		
		cityColumn.editable   = true;
		cityColumn.filterable = true;
		cityColumn.required   = true;

		phoneColumn.editable   = true;
		phoneColumn.filterable = true;
		phoneColumn.required   = true;

		emailColumn.editable   = true;
		emailColumn.filterable = true;
		emailColumn.required   = true;
	}
	
	@Override
	public GwtColumnMetadata[] getColumnMeta(){
		return new GwtColumnMetadata[]{ idColumn, midasIdColumn, nameColumn, addressColumn,
		zipColumn, cityColumn, phoneColumn, emailColumn};
	}
	
}
