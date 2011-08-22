package com.dmma.dashboard.gwt.banker.client.mvp.home.presenter;

import java.util.ArrayList;

import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;

public interface BankerHomePresenterDisplay extends IPresenterDisplay {
	public void setTips(ArrayList<TipDTO> data);
	public void setTipsRequested();
}
