package com.dmma.dashboard.gwt.broker.client.mvp.estates.details.view;

import gwt.dmma.base.client.ui.lookup.LookUpPanelListener;
import gwt.dmma.base.client.ui.lookup.LookupDialog;
import gwt.dmma.base.client.ui.lookup.LookupPresenterAndView;
import gwt.dmma.base.client.utils.CssStyles;

import java.util.ArrayList;
import java.util.Date;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.presenter.LookupClientPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.clientvisit.planner.presenter.ClientVisitPlannerPresenter;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.client.types.ClientVisitStatusType;
import com.dmma.dashboard.gwt.core.client.utils.DashboardWidgetUtils;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateViewingDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitDTOS;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Hidden;

public class FuturePartView extends BaseComposite{
	private final FlowPanel content;
	private final Integer estateViewingId;
	private final Integer estateId;
	private FormPanel pdfDownForm;
	private Hidden formParameter;
	
	public FuturePartView(EstateViewingDTO estateViewing, Integer estateId) {
		super(null);
		this.content = new FlowPanel();
		this.estateId = estateId;
		this.estateViewingId = estateViewing.getId();
		Date from = estateViewing.getDateFrom();
		Date to = estateViewing.getDateTo();
		String dpHeader = BaseFormats.getFormattedInterval(from, to);
		DisclosurePanel dp = new DisclosurePanel(dpHeader);
		dp.setContent(content);
		this.add(dp);
	}
	
	private FlexTable clientVisitTable;
	public void addOneRow(ClientVisitDTOS cv){
		int row = clientVisitTable.getRowCount();
		clientVisitTable.setHTML(  row, 0, ""+row);
		clientVisitTable.setWidget(row, 1, DashboardWidgetUtils.createClientWidget(cv.getClient()));
		clientVisitTable.setHTML(  row, 2, cv.getComments());
		//clientVisitTable.setHTML(  row, 3, "");
	
	}
	
	public void setClientVisits(ArrayList<ClientVisitDTOS> clientVisits){
		clientVisitTable = new FlexTable();
		clientVisitTable.setHTML(0, 0, BaseMessages.MSG.nr());
		clientVisitTable.setHTML(0, 1, DashboardMessages.MSG.client());
		clientVisitTable.setHTML(0, 2, DashboardMessages.MSG.comments());
		//clientVisitTable.setHTML(0, 3, "");
		clientVisitTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
			
		if(clientVisits!=null && !clientVisits.isEmpty()){
			for(ClientVisitDTOS cv: clientVisits){
				addOneRow(cv);
			}
		}
		content.add(clientVisitTable);
		
		FlexTable table = new FlexTable();
		Button add = new Button(BaseMessages.MSG.add());
		add.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				LookupPresenterAndView<ClientDTO> presenterAndView = new LookupClientPresenter();
				final LookupDialog<ClientDTO> dialog = new LookupDialog<ClientDTO>(presenterAndView);
				presenterAndView.setLookUpPanelListener(new LookUpPanelListener<ClientDTO>() {
					@Override
					public void onLookUpPickUp(ClientDTO client) {
						ClientVisitDTOS clientVisit = new ClientVisitDTOS();
						clientVisit.setClient(client);
						//we will setup at server 
						//clientVisit.setCreated(new Date());
						clientVisit.setEstateId(estateId);
						clientVisit.setEstateViewingId(estateViewingId);
						clientVisit.setStatus(ClientVisitStatusType.isPlaningToGo.getId());
						saveClientVisit(clientVisit);
						dialog.hide();
					}
					@Override
					public void onLookUpCanceled() {
						dialog.hide();
					}
				});
				dialog.center();
			}
		});

		table.setWidget(0, 0, add);

		Button pdf = new Button(BaseMessages.MSG.pdf());
		pdf.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				pdfDownForm.submit();
			}
		});
		
		
		Button edit = new Button(BaseMessages.MSG.edit());
		table.setWidget(0, 1, pdf);
		table.setWidget(0, 2, edit);
		edit.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				AppEvent event = new AppEvent(ClientVisitPlannerPresenter.PRESENTER_ID, this.getClass().getName());
				event.addParam(EKP.ID, estateViewingId);
				History.newItem(URLParser.toHistoryToken(event));
			}
		});
		
		pdfDownForm = new FormPanel();
		pdfDownForm.setAction("ClientVisitPlannerPDF");
		formParameter = new Hidden("id", ""+estateViewingId);
		pdfDownForm.add(formParameter);
		table.setWidget(0, 3,pdfDownForm);

		
		content.add(table);
		
	}

	public void setWeAreBusy(){
		//TODO
	}
	
	public void saveClientVisit(ClientVisitDTOS clientVisit) {
		setWeAreBusy();
		ServiceFactory.getClientVisitService().saveOrUpdateDTOS(clientVisit, saveCVCallback);
	}
	public void clientVisitSaved(ClientVisitDTOS clientVisit) {
		addOneRow(clientVisit);
	}
	private SaveCVCallback saveCVCallback = new SaveCVCallback();
	private class SaveCVCallback extends MyAsyncCallback<ClientVisitDTOS>{
		@Override
		public void onSuccess(ClientVisitDTOS clientVisit) {
			clientVisitSaved(clientVisit);			
		}
	}
	
	
	
}
