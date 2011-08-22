package com.dmma.dashboard.gwt.broker.client.mvp.home.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.UnfinalyzedViewingDTOW;
import com.google.gwt.user.client.ui.Widget;

public interface BrokerHomePresenterDisplay {
	public Widget asWidget();
	
	public void setTips(ArrayList<TipDTO> data);
	public void setTipsRequested();

	public void setMyHTS(ArrayList<HaveToSellDTO> data);
	public void setMyHTSRequested();
	
	public void setPartnersHTS(ArrayList<HaveToSellDTO> data);
	public void setPartnersHTSRequested();
	
	public void setUnfinalyzedViewings(ArrayList<UnfinalyzedViewingDTOW> data);
	public void setUnfinalyzedViewingsRequested();
	
	
}
