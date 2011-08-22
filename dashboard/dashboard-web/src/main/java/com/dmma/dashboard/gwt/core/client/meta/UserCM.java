package com.dmma.dashboard.gwt.core.client.meta;


import com.dmma.base.gwt.client.ui.gwtentity.column.GwtColumnMetadata;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;

public class UserCM implements IGwtEntityCM{
	private GwtColumnMetadata idColumn;
	private GwtColumnMetadata brokerMidasIdColumn;
	private GwtColumnMetadata bankerExternalIdColumn;
	private GwtColumnMetadata emailColumn;
	private GwtColumnMetadata titleColumn;
	private GwtColumnMetadata enabledColumn;
	private GwtColumnMetadata passwordColumn;
	
	public UserCM() {
		idColumn               = new GwtColumnMetadata(DashboardMessages.MSG.id()	    , Integer.class ,50);
		brokerMidasIdColumn    = new GwtColumnMetadata(DashboardMessages.MSG.midasId()   , Long.class    ,50);
		bankerExternalIdColumn = new GwtColumnMetadata(DashboardMessages.MSG.externalId(), Long.class    ,50);
		emailColumn            = new GwtColumnMetadata(DashboardMessages.MSG.email()     , String.class  ,180);
		titleColumn            = new GwtColumnMetadata(DashboardMessages.MSG.name()      , String.class  ,200);
		enabledColumn          = new GwtColumnMetadata(DashboardMessages.MSG.enabled()   , Boolean.class ,70);
		passwordColumn         = new GwtColumnMetadata(DashboardMessages.MSG.password()  , String.class  ,150);
		
		emailColumn.editable    = true;
		emailColumn.filterable  = true;
		emailColumn.required    = true;
		
		titleColumn.editable    = true;
		titleColumn.filterable  = true;
		titleColumn.required    = true;

		
		enabledColumn.editable  = true;
		enabledColumn.required  = true;
		
		passwordColumn.editable = true;
		passwordColumn.required    = true;
	}
	
	@Override
	public GwtColumnMetadata[] getColumnMeta(){
		return new GwtColumnMetadata[]{ idColumn, brokerMidasIdColumn,bankerExternalIdColumn,emailColumn, titleColumn
				, enabledColumn , passwordColumn };
	}
	
}
