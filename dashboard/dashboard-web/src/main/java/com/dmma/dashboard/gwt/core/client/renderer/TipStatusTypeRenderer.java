package com.dmma.dashboard.gwt.core.client.renderer;


import com.dmma.base.gwt.client.ui.gwtentity.GwtEnumRendererInterface;
import com.dmma.dashboard.gwt.core.client.types.TipStatusType;

public class TipStatusTypeRenderer implements GwtEnumRendererInterface{
	
	@Override
	public String lookUpById(Integer id) {
		return  TipStatusType.getById(id).getTitle();
	}
	
}

