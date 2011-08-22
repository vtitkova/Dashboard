package com.dmma.dashboard.gwt.core.client.meta;


import java.util.Date;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.ui.gwtentity.GwtEnumRendererInterface;
import com.dmma.base.gwt.client.ui.gwtentity.column.GwtColumnMetadata;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;

public class TipCM implements IGwtEntityCM{
	private GwtColumnMetadata idColumn;
	private GwtColumnMetadata tipDirectionTypeColumn;
	private GwtColumnMetadata brokerColumn;
	private GwtColumnMetadata bankerColumn;
	private GwtColumnMetadata clientColumn;
	private GwtColumnMetadata estateColumn;
	
	private GwtColumnMetadata tipTypeColumn;          //Loan, SellEstate, broker inventory
	private GwtColumnMetadata commentsColumn;
	private GwtColumnMetadata createdColumn;
	private GwtColumnMetadata tipStatusTypeColumn;    // is New, isInProcess, isAccepted, isRejected
	private GwtColumnMetadata modifiedColumn;         // date status has been modified
	private GwtColumnMetadata statusCommentsColumn;
	
	
	public TipCM() {
		idColumn               = new GwtColumnMetadata(DashboardMessages.MSG.id()	          , Integer.class           ,25);
		tipDirectionTypeColumn = new GwtColumnMetadata(DashboardMessages.MSG.tipDirectionType(), GwtEnumRendererInterface.class  ,68);
		brokerColumn           = new GwtColumnMetadata(DashboardMessages.MSG.broker(), BrokerDTO.class, 100);
		bankerColumn           = new GwtColumnMetadata(DashboardMessages.MSG.banker(), BankerDTO.class, 100);
		clientColumn           = new GwtColumnMetadata(DashboardMessages.MSG.client(), ClientDTO.class, 100);
		estateColumn           = new GwtColumnMetadata(DashboardMessages.MSG.estate(), EstateDTO.class, 140);
		tipTypeColumn          = new GwtColumnMetadata(DashboardMessages.MSG.tipType(),  GwtEnumRendererInterface.class  ,70);
		commentsColumn         = new GwtColumnMetadata(DashboardMessages.MSG.comments(), String.class  ,100);
		
		createdColumn          = new GwtColumnMetadata(BaseMessages.MSG.created(),  Date.class    , 65);
		tipStatusTypeColumn    = new GwtColumnMetadata(DashboardMessages.MSG.status(),   GwtEnumRendererInterface.class  ,73);
		modifiedColumn         = new GwtColumnMetadata(DashboardMessages.MSG.modificationDate(), Date.class    ,65);
		statusCommentsColumn   = new GwtColumnMetadata(DashboardMessages.MSG.modificationComments(), String.class  ,90);
	}
	
	@Override
	public GwtColumnMetadata[] getColumnMeta(){
		return new GwtColumnMetadata[]{ idColumn, tipDirectionTypeColumn,
				brokerColumn, bankerColumn, clientColumn,estateColumn,
				tipTypeColumn, commentsColumn, createdColumn, tipStatusTypeColumn,
				modifiedColumn, statusCommentsColumn};
	}
	
}
