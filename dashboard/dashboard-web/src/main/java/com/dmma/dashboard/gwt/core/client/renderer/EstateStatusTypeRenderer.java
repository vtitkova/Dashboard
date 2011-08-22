package com.dmma.dashboard.gwt.core.client.renderer;


import com.dmma.base.gwt.client.ui.gwtentity.GwtEnumRendererInterface;
import com.dmma.dashboard.gwt.core.client.types.EstateStatusType;

public class EstateStatusTypeRenderer implements GwtEnumRendererInterface{
	
	@Override
	public String lookUpById(Integer id) {
		return EstateStatusType.getById(id).getTitle();
	}
	
}

