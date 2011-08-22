package com.dmma.dashboard.gwt.core.client.renderer;


import com.dmma.base.gwt.client.ui.gwtentity.GwtEnumRendererInterface;
import com.dmma.dashboard.gwt.core.client.types.TipDirectionType;

public class TipDirectionTypeRenderer implements GwtEnumRendererInterface{
	
	@Override
	public String lookUpById(Integer id) {
		return  TipDirectionType.getById(id).getTitle();
	}
	
}

