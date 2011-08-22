package com.dmma.dashboard.gwt.core.client.meta;


import java.util.Date;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.ui.gwtentity.column.GwtColumnMetadata;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;

public class HaveToSellCM implements IGwtEntityCM{
	private GwtColumnMetadata idColumn;
	private GwtColumnMetadata clientColumn;
	private GwtColumnMetadata createdColumn;
	private GwtColumnMetadata createdByColumn;
	private GwtColumnMetadata askedDateColumn;
	private GwtColumnMetadata askedByColumn;
	private GwtColumnMetadata askCommentsColumn;
	private GwtColumnMetadata wantsToSellColumn;
	private GwtColumnMetadata remindColumn;
	private GwtColumnMetadata remindDateColumn;
	private GwtColumnMetadata remindedDateColumn;
	private GwtColumnMetadata remindedByColumn;
	private GwtColumnMetadata remindCommentsColumn;
	
	
	public HaveToSellCM() {
		idColumn        = new GwtColumnMetadata(DashboardMessages.MSG.id(),          Integer.class           ,25);
		clientColumn    = new GwtColumnMetadata(DashboardMessages.MSG.client(),      ClientDTO.class, 100);
		createdColumn   = new GwtColumnMetadata(BaseMessages.MSG.created(),     Date.class    , 65);
		createdByColumn = new GwtColumnMetadata(DashboardMessages.MSG.htsCreatedBy(),BrokerDTO.class  ,100);
	
		askedDateColumn     = new GwtColumnMetadata(DashboardMessages.MSG.htsAskDate(),    Date.class, 65);
		askedByColumn     = new GwtColumnMetadata(DashboardMessages.MSG.htsAskedBy(),    BankerDTO.class, 100);
		askCommentsColumn = new GwtColumnMetadata(DashboardMessages.MSG.htsAskComments(),String.class, 100);
		wantsToSellColumn = new GwtColumnMetadata(DashboardMessages.MSG.htsWantsToSell(),Boolean.class  ,40);

		remindColumn     = new GwtColumnMetadata(DashboardMessages.MSG.htsRemind(),     Boolean.class   ,40);
		remindDateColumn = new GwtColumnMetadata(DashboardMessages.MSG.htsRemindDate(),    Date.class      ,65);
		remindedDateColumn =  new GwtColumnMetadata(DashboardMessages.MSG.htsRemindedDate(), Date.class, 65);
		remindedByColumn = new GwtColumnMetadata(DashboardMessages.MSG.htsRremindedBy(),BankerDTO.class ,100);
		remindCommentsColumn = new GwtColumnMetadata(DashboardMessages.MSG.htsRemindComments(), String.class  ,100);
	}
	
	@Override
	public GwtColumnMetadata[] getColumnMeta(){
		return new GwtColumnMetadata[]{ idColumn, clientColumn,
				createdColumn, createdByColumn, askedDateColumn,askedByColumn,
				askCommentsColumn, wantsToSellColumn, remindColumn, remindDateColumn,
				remindedDateColumn, remindedByColumn, remindCommentsColumn};
	}
	
}
