package com.dmma.dashboard.gwt.core.client.renderer;


import java.util.ArrayList;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityListInterface;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.dashboard.gwt.core.shared.entities.EstateViewingDTO;

public class ViewingListRenderer implements GwtEntityListInterface<EstateViewingDTO>{
	
	@Override
	public String getValue(ArrayList<EstateViewingDTO> entities) {
		if(entities==null||entities.isEmpty()){
			return " - ";
		}else{
			StringBuffer sb = new StringBuffer();
			int i = 0;
			int size = entities.size();
			for (EstateViewingDTO viewing : entities) {
				sb.append(BaseFormats.getFormattedInterval(viewing.getDateFrom(), viewing.getDateTo()));
				
				if (i < size - 1) {
					sb.append(", ");
				}
				i++;
			}
			
			return sb.toString();
		}		
	}
	
}

