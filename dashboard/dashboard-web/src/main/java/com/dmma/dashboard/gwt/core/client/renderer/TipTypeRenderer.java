package com.dmma.dashboard.gwt.core.client.renderer;


import com.dmma.base.gwt.client.ui.gwtentity.GwtEnumRendererInterface;
import com.dmma.dashboard.gwt.core.client.types.TipType;

public class TipTypeRenderer implements GwtEnumRendererInterface{
	
	@Override
	public String lookUpById(Integer id) {
		return  TipType.getById(id).getTitle();
	}
	
}

