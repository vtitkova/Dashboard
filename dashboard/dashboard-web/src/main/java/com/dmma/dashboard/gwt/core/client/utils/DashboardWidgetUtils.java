package com.dmma.dashboard.gwt.core.client.utils;

import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.ui.contactInfo.ContactInfoBigPopup;
import com.dmma.base.gwt.client.ui.estateInfo.PlaceInfoBigPopup;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DashboardWidgetUtils {

	public static Widget createBrokerWidget(final BrokerDTO broker){
		final Label brokerLA = new Label();
		if(broker!=null){
			brokerLA.setText(broker.getFullName());
			brokerLA.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent arg0) {
					ContactInfoBigPopup.show(broker, brokerLA);
				}
			});
			brokerLA.setStyleName(CssStyles.ACTION_WRAP);
			brokerLA.addStyleName(CssStyles.HIGHLITABLE);
		}
		return brokerLA;
	}

	public static Widget createBankerWidget(final BankerDTO banker){
		final Label bankerLA = new Label();
		if(banker!=null){
			bankerLA.setText(banker.getFullName());
			bankerLA.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent arg0) {
					ContactInfoBigPopup.show(banker, bankerLA);
				}
			});
			bankerLA.setStyleName(CssStyles.ACTION_WRAP);
			bankerLA.addStyleName(CssStyles.HIGHLITABLE);
		}
		return bankerLA;
	}

	public static Widget createClientWidget(final ClientDTO client){
		final Label clientLA = new Label();
		if(client!=null){
			clientLA.setText(client.getFullName());
			clientLA.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent arg0) {
					ContactInfoBigPopup.show(client, clientLA);
				}
			});
			clientLA.setStyleName(CssStyles.ACTION_WRAP);
			clientLA.addStyleName(CssStyles.HIGHLITABLE);
		}
		return clientLA;
	}
	
	public static Widget createEstateWidget(final EstateDTO estate){
		final Label estateLA = new Label();
		if(estate!=null){
			estateLA.setText(estate.getDisplayName());
			estateLA.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent arg0) {
					PlaceInfoBigPopup.show(estate, estateLA);
				}
			});
			estateLA.setStyleName(CssStyles.ACTION_WRAP);
			estateLA.addStyleName(CssStyles.HIGHLITABLE);	
		}
		return estateLA;
	}
}
