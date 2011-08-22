package com.dmma.dashboard.gwt.core.client.onthefly.flatview;

import gwt.dmma.base.client.onthefly.flatview.FlatViewDisplay;

import com.dmma.dashboard.gwt.core.client.types.ClientVisitStatusType;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;

public class FlatViewClientVisitStatus extends Composite implements FlatViewDisplay{
	private HTML content;
	private FlatViewListener listener;


	public FlatViewClientVisitStatus() {
		this.content = new HTML();
		content.setStyleName("OTFFlatViewDisplay");
		content.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				if(listener!=null)
					listener.onStartEditEvent();
			}
		});
		initWidget(content);
	}

	@Override
	public void setText(String text) {
		content.setHTML(ClientVisitStatusType.createIconHTML(Integer.parseInt(text)));
	}

	@Override
	public void setFlatViewListener(FlatViewListener listener) {
		this.listener = listener;

	}



}
