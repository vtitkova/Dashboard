package com.dmma.dashboard.gwt.core.client.onthefly;

import gwt.dmma.base.client.onthefly.core.OnTheFlyEditor;
import gwt.dmma.base.client.onthefly.editor.OnTheFlyEditorLB;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.client.onthefly.flatview.FlatViewClientVisitStatus;

public class OnTheFlyEditorForClientVisitStatus extends OnTheFlyEditor<FlatViewClientVisitStatus, OnTheFlyEditorLB>{
	
	
	public OnTheFlyEditorForClientVisitStatus(){
		super(new FlatViewClientVisitStatus(), new OnTheFlyEditorLB(true));
	}
	
	public void setValues(ArrayList<ListBoxDTO> data) {
		editorDisplay.setValues(data);
	}
	
}
