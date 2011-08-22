package com.dmma.dashboard.gwt.core.client.meta;


import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityListInterface;
import com.dmma.base.gwt.client.ui.gwtentity.GwtEnumRendererInterface;
import com.dmma.base.gwt.client.ui.gwtentity.column.GwtColumnMetadata;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;

public class EstateCM implements IGwtEntityCM{
	private GwtColumnMetadata idColumn;
	private GwtColumnMetadata midasIdColumn;
	private GwtColumnMetadata finnCodeColumn;
	private GwtColumnMetadata orderNumberColumn;
	private GwtColumnMetadata statusColumn;
	private GwtColumnMetadata titleColumn;
	private GwtColumnMetadata addressColumn;
	private GwtColumnMetadata postCodeColumn;
	private GwtColumnMetadata postCityColumn;
	private GwtColumnMetadata gnrColumn;
	private GwtColumnMetadata bnrColumn;
	private GwtColumnMetadata brokerColumn;
	private GwtColumnMetadata estateViewingsColumn;
	
	
	
	
	public EstateCM() {
		idColumn          = new GwtColumnMetadata(DashboardMessages.MSG.id()	          , Integer.class ,30);
		midasIdColumn     = new GwtColumnMetadata(DashboardMessages.MSG.midasId()      , Long.class    ,45);
		finnCodeColumn    = new GwtColumnMetadata(DashboardMessages.MSG.finnCode()     , Long.class    ,62);
		orderNumberColumn = new GwtColumnMetadata(DashboardMessages.MSG.orderNumberShort(), String.class  ,55);
		statusColumn      = new GwtColumnMetadata(DashboardMessages.MSG.status()       , GwtEnumRendererInterface.class  ,80);
		titleColumn       = new GwtColumnMetadata(DashboardMessages.MSG.name()         , String.class  ,150);
		addressColumn     = new GwtColumnMetadata(DashboardMessages.MSG.address()      , String.class  ,80);
		postCodeColumn    = new GwtColumnMetadata(DashboardMessages.MSG.postCodeShort(), String.class  ,50);
		postCityColumn    = new GwtColumnMetadata(DashboardMessages.MSG.postCity()     , String.class  ,70);
		gnrColumn         = new GwtColumnMetadata(DashboardMessages.MSG.gnr()          , String.class  ,35);
		bnrColumn         = new GwtColumnMetadata(DashboardMessages.MSG.bnr()          , String.class  ,35);
		brokerColumn      = new GwtColumnMetadata(DashboardMessages.MSG.broker()       , BrokerDTO.class  ,75);
		estateViewingsColumn  = new GwtColumnMetadata(DashboardMessages.MSG.viewings() , GwtEntityListInterface.class  ,65);
	}
	
	@Override
	public GwtColumnMetadata[] getColumnMeta(){
		return new GwtColumnMetadata[]{ idColumn, midasIdColumn, finnCodeColumn , orderNumberColumn, statusColumn,
				titleColumn, addressColumn, postCodeColumn, postCityColumn, gnrColumn, bnrColumn, brokerColumn, estateViewingsColumn };
	}
}
